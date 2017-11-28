package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configure {
	private static Configure configure;
	private static Properties properties;
	private Configure(){
		System.out.println("----进入单例创建----");	
		try {
			properties = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static Configure getInstance() {
		if(configure==null){
			configure = new Configure();
		}
		return configure;
	}
	public static String getProperties(String key){
		return properties.getProperty(key);
	}
	
}
