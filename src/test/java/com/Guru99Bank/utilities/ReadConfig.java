package com.Guru99Bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		}catch(IOException e)
		{
			System.out.println("IO Error is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String appUurl=pro.getProperty("url");
		return appUurl;
	}

	public String getUserName()
	{
		String userName=pro.getProperty("uname");
		return userName;
	}
	
	public String getPassword()
	{
		String userPassword=pro.getProperty("pass");
		return userPassword;
	}
	
	public String getChromePath()
	{
		String chroPath=pro.getProperty("chropath");
		return chroPath;
	}
	public String getFirefoxPath()
	{
		String chroPath=pro.getProperty("firefoxpath");
		return chroPath;
	}
	public String getIEPath()
	{
		String chroPath=pro.getProperty("iepath");
		return chroPath;
	}
	public String getXLSPath()
	{
		String xlsPath=pro.getProperty("xlsbookPath");
		return xlsPath;
	}
	
	public String getXlsSheetName()
	{
		String xlsFileName=pro.getProperty("loginSheet");
		return xlsFileName;
	}
}
