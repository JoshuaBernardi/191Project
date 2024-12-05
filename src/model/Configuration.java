package model;

import java.util.Calendar;
import java.util.Date;

public class Configuration
{
	public static Date currentDate;
	
	static {
		currentDate = Calendar.getInstance().getTime();
	}
}
