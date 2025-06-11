package com.dio.master.utils;

import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.*;

public class UtilsExcel {

    public static Map<Integer, List<String>> readSheetValues(Sheet sheet) {
        Map<Integer, List<String>> excelValues = new HashMap<>();
        for (Row row : sheet) {
            List<String> rowValues = new ArrayList<>();

            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case NUMERIC:
                        rowValues.add(String.valueOf(cell.getNumericCellValue()).replaceAll("\\.", Strings.EMPTY));
                        break;
                    case STRING:
                        rowValues.add(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        rowValues.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    default:
                        break;
                }
            }
            if (!rowValues.isEmpty())
                excelValues.put(row.getRowNum(), rowValues);
        }
        return excelValues;
    }

    /**
     * Função lê os valores de um arquivo Excel:
     * <p>
     * Map Principal: Map <String, Map<Integer, List<String>
     * Key: refere-se ao nome da planílha, (uma vez que o arquivo pode conter várias)
     * Value: refere-se aos valores da planílha
     * <p>
     * Map Secundário: Map<Integer, List<String>>
     * Key: refere-se ao número da linha da planílha
     * Value: refere-se aos valores contidos em cada coluna da linha
     */
    public static Map<String, Map<Integer, List<String>>> readExcelValues(String path) {
        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(file)) {
            Map<String, Map<Integer, List<String>>> excelValues = new HashMap<>();

            workbook.sheetIterator()
                    .forEachRemaining((sheet) ->
                            excelValues.put(sheet.getSheetName(), readSheetValues(sheet))
                    );

            return excelValues;
        } catch (Exception exception) {
            return new HashMap<>();
        }
    }
}