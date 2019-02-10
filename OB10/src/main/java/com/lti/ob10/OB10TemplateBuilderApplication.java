package com.lti.ob10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OB10TemplateBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OB10TemplateBuilderApplication.class, args);
		
		System.out.println("Hello");
	}
	
	static void readExcel() {

		//XSSFWorkbook workbook = null;
		try(XSSFWorkbook workbook= new XSSFWorkbook(new FileInputStream(new File("")))) {
			XSSFSheet worksheet = null;
			for (int k = 0; k < workbook.getNumberOfSheets(); k++) {
//				System.out.println("Sheet No: "+ k);
				worksheet = workbook.getSheetAt(k);
//				if(worksheet.getRow(0) == null || !worksheet.getRow(0).getCell(0).getStringCellValue().equals(Invoice.EMP_NO.getVal()))
//					continue;
				for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
					XSSFRow row = worksheet.getRow(i);
					// row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(29).setCellType(Cell.CELL_TYPE_STRING);
					//row.getCell(30).setCellType(Cell.CELL_TYPE_STRING);
					//row.getCell(31).setCellType(Cell.CELL_TYPE_STRING);
					String empName = row.getCell(5).getStringCellValue();
					// System.out.println(row.getCell(0).getStringCellValue());
//					EmployeeBuilder e = Employee.builder()
//							.name(empName)
//							.poNo(row.getCell(15).getStringCellValue())
//							.attn(row.getCell(17).getStringCellValue())
//							.qty(row.getCell(29).getStringCellValue())
//							.rate(String.format("%,.2f",row.getCell(30).getNumericCellValue()))
//							.amt(String.format("%,.2f",row.getCell(31).getNumericCellValue()));
//					empMap.put(empName, e.build());
				}
				//System.out.println("Collected record count: "+empMap.size());
			}
			//
			//System.out.println(empMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	}

}

