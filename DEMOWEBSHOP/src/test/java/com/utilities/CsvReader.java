package com.utilities;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReader {

    // Read full CSV file and return data as list of maps
    // Each row = (Header -> Value)
    public static List<Map<String, String>> getData(String filePath) {

        List<Map<String, String>> result = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).build()) {

            List<String[]> rows = reader.readAll();

            // Check if file is empty
            if (rows.isEmpty()) {
                throw new RuntimeException("CSV file is empty: " + filePath);
            }

            // First row = column names
            String[] headers = rows.get(0);

            // Start reading from second row (actual data)
            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                // Skip empty rows
                if (isEmpty(row)) continue;

                Map<String, String> rowMap = new LinkedHashMap<>();

                for (int j = 0; j < headers.length; j++) {

                    String key = headers[j]; // column name
                    String value = (j < row.length) ? row[j] : ""; // cell value

                    rowMap.put(key, value);
                }

                result.add(rowMap);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }

        return result;
    }

    // Get all values from a specific column
    public static List<String> getColumn(String filePath, String columnName) {

        List<String> values = new ArrayList<>();

        List<Map<String, String>> data = getData(filePath);

        for (Map<String, String> row : data) {
            values.add(row.get(columnName));
        }

        return values;
    }

    // Get total number of data rows (excluding header)
    public static int getRowCount(String filePath) {
        return getData(filePath).size();
    }

    // Check if row is empty
    private static boolean isEmpty(String[] row) {

        for (String cell : row) {
            if (cell != null && !cell.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}