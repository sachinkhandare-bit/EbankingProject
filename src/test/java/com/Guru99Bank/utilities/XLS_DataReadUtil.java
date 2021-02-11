package com.Guru99Bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLS_DataReadUtil extends ReadConfig {
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static int rowcount=0;
	public static int columncount=0;
	public static FileInputStream fis;
	static ReadConfig config=new ReadConfig();
	
	static String path=config.getXLSPath();
	static String filename=config.getXlsSheetName();
	
	public static void getXSlWorkbook()
	{
		//File src=new File("C:\\Users\\admin\\My-Eclipse-Workspace\\eBankingGuru99Bank\\src\\test\\java\\com\\Guru99Bank\\testData\\Book123.xlsx");
		File src=new File(path);
		
		try {
			fis = new FileInputStream(src);
			wbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File not found Exception"+e.getMessage());
			//e.printStackTrace();
		}catch(IOException e)
		{
			System.out.println("Input/Output related Exception"+e.getMessage());
		}
		
		sheet=wbook.getSheet(filename);
		//sheet=wbook.getSheet("Guru99");
		
	}
	
	public static int getRowcount()
	{
		getXSlWorkbook();
		rowcount=sheet.getLastRowNum();
		System.out.println("Number of Rows="+rowcount);
		return rowcount;
		
	}
	
	public static int getcolumnCount(int rownum)
	{  
		getXSlWorkbook();
		columncount=sheet.getRow(rownum).getLastCellNum();
		System.out.println("Number of Columns "+columncount);
		return columncount;
		
	}
	
	public static void closeWB()
	{
		try {
			wbook.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static String getCellData(int rowNum, int columNum)
	{
			getXSlWorkbook();
			XSSFRow row=sheet.getRow(rowNum);
			System.out.println("Get cell data called number="+rowNum);
			Cell cell=row.getCell(columNum);
				
				String cellData;
				try
				{
					DataFormatter formatdata=new DataFormatter();
					String cellValue=formatdata.formatCellValue(cell);
					return cellValue;
				}
				catch(Exception e)
				{
					cellData="";
					return cellData;
				}
				/*switch(cell.getCellType())
				{
				case STRING:
					System.out.print(" "+cell.getStringCellValue()+"\t");
					
					break;
				case NUMERIC:
					System.out.print(" "+cell.getNumericCellValue()+"\t");
					
					break;
				case BLANK:
					System.out.println("Value in cell is "+cell.getStringCellValue());
					
					break;
				default:
					break;*/
				
			
	}
	

}
