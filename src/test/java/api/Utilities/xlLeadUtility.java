package api.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;

public class xlLeadUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet Sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public xlLeadUtility(String path) {
		// TODO Auto-generated method stub
				this.path = path;
	}

	public int getRowCount(String SheetName) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		Sheet = workbook.getSheet(SheetName);
		int rowCount = Sheet.getLastRowNum();
		workbook.close();
		fi.close();
		System.out.println("No of Row Count" + rowCount);
		return rowCount;
	}
	public int getCellCount(String SheetName, int rownum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		Sheet = workbook.getSheet(SheetName);
		row = Sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		System.out.println("No of Cell Count" + cellCount);
		return cellCount;
	}
	
	public String getCellData(String SheetName, int rownum, int colnum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		Sheet = workbook.getSheet(SheetName);
		row = Sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter Formatter = new DataFormatter();
		String data;
		try {
		data = Formatter.formatCellValue(cell);
		} catch (Exception e){
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String SheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(path);
		
		if(!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		if (workbook.getSheetIndex(SheetName)== -1) 
			 workbook.createSheet(SheetName);
		Sheet = workbook.getSheet(SheetName);
		
		if(Sheet.getRow(rownum)==null)
			Sheet.createRow(rownum);
		row = Sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		}
	}
	
