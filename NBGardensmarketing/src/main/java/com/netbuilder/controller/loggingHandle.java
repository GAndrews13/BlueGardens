package com.netbuilder.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class loggingHandle {
	private static final String errorLogPath = "errLog.txt";
	private static final String eventLogPath = "eventLog.txt";
	
	
	public static void errorLog(Exception e, String inErrorLocation)
	{
		File file = new File(errorLogPath);
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				
				bw.write(
						String.format("ERROR (%s) @ %s: %s", dateFormat.format(cal.getTime()),inErrorLocation, e.getMessage())
						);
				bw.flush();
				bw.close();
			}
			catch (Exception E)
			{
				
			}
		}
	}
	
	public static void log(String inLocation, String inMessage)
	{
		File file = new File(eventLogPath);
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				
				bw.write(
						String.format("Event (%s) @ %s: %s", dateFormat.format(cal.getTime()),inLocation, inMessage)
						);
				bw.flush();
				bw.close();
			}
			catch (Exception e)
			{
				errorLog(e, "loggingLOG01");
			}
		}
	}
}
