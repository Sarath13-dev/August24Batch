package org.task;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="login")
	public static Object[][] getData(){
		return new Object[][]
				{
			{"qatest@habile.in","Qatest123$"},
			{"abcv","1234"},
			{"avxcbf","123412"}
				};
				
			
		
	
	}
	

}
