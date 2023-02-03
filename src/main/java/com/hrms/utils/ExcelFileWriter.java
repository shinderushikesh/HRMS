package com.hrms.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWriter {

	public static <T> XSSFWorkbook writeToExcel(List<T> data, String[] columnNames) {
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet();
//			logger.info("Class name - {}", data.get(0).getClass());
			// Set column names
			List<String> fieldNames = Arrays.asList(columnNames);
//			logger.info("Column size- {}", fieldNames.size());
			int rowCount = 0;
			int columnCount = 0;
			Row row = sheet.createRow(rowCount++);
			for (String fieldName : fieldNames) {
				Cell cell = row.createCell(columnCount++);
				cell.setCellValue(fieldName);
			}
			// Get column names and get it's methods
			fieldNames = getFieldNamesForClass(data.get(0).getClass());
			Class<? extends Object> classz = data.get(0).getClass();
			for (T t : data) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					if(fieldName.equals("serialVersionUID"))
						continue;
					Cell cell = row.createCell(columnCount);
					Method method = null;
					try {
						method = classz.getMethod("get" + capitalize(fieldName));
					} catch (NoSuchMethodException nme) {
						method = classz.getMethod("get" + fieldName);
					}
					Object value = method.invoke(t, (Object[]) null);
					if (value != null) {
						if (value instanceof String) {
							cell.setCellValue((String) value);
						} else if (value instanceof Long) {
							cell.setCellValue((Long) value);
						} else if (value instanceof Integer) {
							cell.setCellValue((Integer) value);
						} else if (value instanceof Double) {
							cell.setCellValue((Double) value);
						} else if (value instanceof Boolean && fieldName.contains("active")) {
							if ((Boolean)value == true) {
								cell.setCellValue("Active");
							} else {
								cell.setCellValue("Inactive");
							}

						} else if (value instanceof Boolean) {
							cell.setCellValue((Boolean) value);
						}

					}
					columnCount++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (workbook != null) {
//			logger.info("Data converted to excel workbook.");
			System.out.println("Data converted to excel workbook.");
		} else {
//			logger.error("Error converting data to excel workbook");
			System.out.println("Error converting data to excel workbook");
			return null;
		}
		return workbook;
	}

	// retrieve field names from a POJO class
	private static List<String> getFieldNamesForClass(Class<?> clazz) throws Exception {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return fieldNames;
	}

	// capitalize the first letter of the field name for retriving value of the
	// field later
	private static String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

}
