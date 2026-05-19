package com.utilities;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class CsvReader {

    // Read CSV file and return all data
    public static List<Map<String, String>> getData(String filePath) {

        List<Map<String, String>> dataList=new ArrayList<>();

        try {

            CSVReader reader=new CSVReader(new FileReader(filePath));

            List<String[]> allRows=reader.readAll();

            // First row = headers
            String[] headers=allRows.get(0);

            // Start from row 1 because row 0 is header
            for (int i=1;i<allRows.size();i++) {

                String[] currentRow=allRows.get(i);

                Map<String, String> rowData=new HashMap<>();

                for (int j=0;j<headers.length;j++) {

                    String key = headers[j];
                    String value = "";

                    if (j < currentRow.length) {
                        value = currentRow[j];
                    }

                    rowData.put(key, value);
                }

                dataList.add(rowData);
            }

            reader.close();

        } catch (Exception e) {

            throw new RuntimeException("Unable to read CSV file : " + filePath);
        }

        return dataList;
    }

    // Get single column values
    public static List<String> getColumn(String filePath, String columnName) {

        List<String> columnValues = new ArrayList<>();

        List<Map<String, String>> data = getData(filePath);

        for (Map<String, String> row : data) {

            columnValues.add(row.get(columnName));
        }

        return columnValues;
    }

    // Get total row count
    public static int getRowCount(String filePath) {

        return getData(filePath).size();
    }
}