package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String> readTranslations(String filePath, String sheetName) {
        List<String> translations = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    translations.add(cell.getStringCellValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return translations;
    }
}