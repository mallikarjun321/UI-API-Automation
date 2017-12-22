package TestNG;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;


public class Rerun_failed_TCS {
	
	@Test
	public  void TC2() {
		
		TestNG runner=new TestNG();
		List<String> list=new ArrayList<String>();
		list.add("C:\\Users\\shreesai\\eclipse-workspace\\API_Automation\\test-output\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
		
		
	}

}
