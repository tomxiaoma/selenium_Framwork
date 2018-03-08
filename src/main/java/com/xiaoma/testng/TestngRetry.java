package com.xiaoma.testng;

import com.xiaoma.log4j.LoggerControler;
import com.xiaoma.testng.utils.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * TestNG retry Analyzer.
 * @author xiaoma
 *
 */
public class TestngRetry implements IRetryAnalyzer {
	private final static LoggerControler logger = LoggerControler.getLoggerControler(TestngRetry.class);
	private int retryCount = 1;
	private static int maxRetryCount;

	static {
		ConfigReader config = ConfigReader.getInstance();
		maxRetryCount = config.getRetryCount();
		logger.info("retrycount=" + maxRetryCount);
		logger.info("sourceCodeDir=" + config.getSourceCodeDir());
		logger.info("sourceCodeEncoding=" + config.getSrouceCodeEncoding());
	}

	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "Retry for [" + result.getName() + "] on class [" + result.getTestClass().getName() + "] Retry "
					+ retryCount + " times";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		//support testng dataprovider retry
		if(maxRetryCount - retryCount == -1) {
			retryCount = 1;
		}
		return false;
	}

	public static int getMaxRetryCount() {
		return maxRetryCount;
	}
	
	public int getRetryCount() {
		return retryCount;
	}
	
}
