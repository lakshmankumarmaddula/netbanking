package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties pro;

	public Readconfig() {
		File src = new File("C:\\Users\\kumar\\eclipse-workspace\\netbanking\\Configurations\\Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src); // to open file in read moaded
			pro = new Properties();
			pro.load(fis); // it will load the file
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getApplicationURL() {

		String appurl = pro.getProperty("baseURL");
		return appurl;
	}

	public String getusername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getchromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfireffoxpath() {
		String fireffoxpath = pro.getProperty("fireffoxpath");
		return fireffoxpath;
	}

}
