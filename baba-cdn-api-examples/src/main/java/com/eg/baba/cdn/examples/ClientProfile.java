package com.eg.baba.cdn.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ClientProfile{
	
	private static final Properties config = new Properties();

	static {
		try {
			load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private static void load() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream in = new FileInputStream(".clientprofile");
		config.load(in);
		in.close();
	}

	public static String getKeyId() {
		// TODO Auto-generated method stub
		return config.getProperty("key.id");
	}

	public static String getKeySecret() {
		// TODO Auto-generated method stub
		return config.getProperty("key.secret");
	}

	public static String getEntry() {
		// TODO Auto-generated method stub
		return config.getProperty("entry");
	}


}
