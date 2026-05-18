package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    public static String getCellData(String path, String sheetName, int rowNum, int cellNum) {

        String data = "";

        try {

            FileInputStream fis = new FileInputStream(path);

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);

            Cell cell = row.getCell(cellNum);

            data = cell.toString();

            workbook.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return data;
    }
}