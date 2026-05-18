package com.utilities;

public class LoginTestData {

    public static String email;
    public static String password;

    static {

        String path = "TestData/TestData.xlsx";

        email = ExcelReader.getCellData(path, "Login", 1, 0);

        password = ExcelReader.getCellData(path, "Login", 1, 1);
    }
}