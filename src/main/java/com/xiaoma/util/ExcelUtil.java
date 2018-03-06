package com.xiaoma.util;

import com.xiaoma.log4j.LoggerControler;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/03/06 0006.
 */
public class ExcelUtil {
    final static LoggerControler logger = LoggerControler.getLoggerControler(ExcelUtil.class);

    /**
     * @param file 读取某个excel文件
     * @return Object
     */
    public Object[][] testData(String file) {
        ArrayList<String> arrkey = new ArrayList<String>();
        Workbook workbook = ExcelUtil.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        //获取总行数
        int rowTotalNum = sheet.getLastRowNum()+1;
        //总列数
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        HashMap<String, String>[][] map = new HashMap[rowTotalNum - 1][1];
        // 对数组中所有元素hashmap进行初始化
        if (rowTotalNum > 1) {
            for (int i = 0; i < rowTotalNum - 1; i++) {
                map[i][0] = new HashMap();
            }
        } else {
            logger.error("测试的Excel" + file + "中没有数据");
        }
        // 获得首行的列名，作为hashmap的key值
        for (int c = 0; c < columns; c++) {
            String cellvalue = ExcelUtil.getCellValue(sheet, 0, c);
            arrkey.add(cellvalue);
        }
        // 遍历所有的单元格的值添加到hashmap中
        for (int r = 1; r < rowTotalNum; r++) {
            for (int c = 0; c < columns; c++) {
                String cellvalue = ExcelUtil.getCellValue(sheet, r, c);
                map[r - 1][0].put(arrkey.get(c), cellvalue);
            }
        }
        return map;

    }


    /**
     * 创建 workbook
     *
     * @param filePath excel文件路径
     * @return Workbook 对象
     * @throws IOException
     */
    public static Workbook getWorkbook(String filePath) {
        Workbook wb = null;
        try {
            if (filePath.endsWith(".xls")) {
                File file = new File(filePath);
                InputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            } else if (filePath.endsWith(".xlsx") || filePath.endsWith(".xlsm")) {
                wb = new XSSFWorkbook(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    /**
     * 通过sheet 行号和列返回值
     *
     * @param sheet   sheet name
     * @param rowNum  行号
     * @param cellNum 列号
     * @return
     */
    public static String getCellValue(Sheet sheet, int rowNum, int cellNum) {
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        String value = ExcelUtil.getCellValue(cell);
        return value;
    }


    /**
     * 把不同类型的单元格转换成字符串，并返回
     *
     * @param cell cell
     * @return 当个单元格值
     */

    public static String getCellValue(Cell cell) {
        String value = "";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = String.valueOf(cell.getRichStringCellValue());
                return value;
            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                return value;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;

            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;

            case ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            case BLANK:
                return value;
            default:
                logger.warn("未知该单元格类型");
                return value;

        }
    }



}
