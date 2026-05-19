package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static List<Map<String, String>> getCellData(String filePath,String sheetName,int row) {

        List<Map<String, String>> data=new ArrayList<>();

        try {

            FileInputStream fis=new FileInputStream(filePath);

            XSSFWorkbook workbook=new XSSFWorkbook(fis);

            Sheet sheet=workbook.getSheet(sheetName);

            DataFormatter formatter=new DataFormatter();

            Row headerRow=sheet.getRow(0);

            for (int i=1;i<=sheet.getLastRowNum();i++) {

                Row currentRow=sheet.getRow(i);

                if (currentRow==null) {
                    continue;
                }

                Map<String, String> rowData=new LinkedHashMap<>();

                for (int j=0;j<headerRow.getPhysicalNumberOfCells();j++) {

                    String key=formatter.formatCellValue(headerRow.getCell(j));
                    String value=formatter.formatCellValue(currentRow.getCell(j));

                    rowData.put(key, value);
                }

                data.add(rowData);
            }

            workbook.close();
        }
        catch (IOException e) {

            throw new RuntimeException("Unable to read excel file: "+ filePath, e);
        }

        return data;
    }

    public static String getCellData(String filePath,
                                     String sheetName,
                                     int rowNum,
                                     int cellNum) {

        String value="";

        try {

            FileInputStream fis=new FileInputStream(filePath);

            XSSFWorkbook workbook=new XSSFWorkbook(fis);

            Sheet sheet=workbook.getSheet(sheetName);

            DataFormatter formatter=new DataFormatter();

            Row row=sheet.getRow(rowNum);

            value=formatter.formatCellValue(row.getCell(cellNum));

            workbook.close();
        }
        catch (IOException e) {

            throw new RuntimeException("Unable to read excel file: "+ filePath, e);
        }

        return value;
    }
}