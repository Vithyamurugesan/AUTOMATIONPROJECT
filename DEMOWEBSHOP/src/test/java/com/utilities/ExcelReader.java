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

        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return data;
    }
    
    public static List<Map<String, String>> getData(String filePath,String sheetName) {

        List<Map<String, String>> data=new ArrayList<>();

        try {
            FileInputStream fis=new FileInputStream(filePath);

            Workbook workbook=WorkbookFactory.create(fis);
            
            Sheet sheet=workbook.getSheet(sheetName);

            DataFormatter formatter=new DataFormatter();

            Row headerRow=sheet.getRow(0);

            for (int i=1;i<=sheet.getLastRowNum();i++) {

                Row currentRow=sheet.getRow(i);

                if (currentRow == null) {
                    continue;
                }

                Map<String, String> rowData=new LinkedHashMap<>();

                // Read all columns
                for (int j=0;j<headerRow.getPhysicalNumberOfCells();j++) {

                    String key=formatter.formatCellValue(headerRow.getCell(j));

                    String value=formatter.formatCellValue(currentRow.getCell(j));

                    rowData.put(key, value);
                }

                data.add(rowData);
            }

            workbook.close();
        }
        catch (Exception e) {
        	
            System.out.println(e.getMessage());
            throw new RuntimeException("Unable to read excel file: "+ filePath, e);

        }

        return data;
    }
    
}
