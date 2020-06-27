package Funct_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Common_utility.Base;
import Pages.login_page;

public class Sprint1 extends Base {

	@Test(priority=1,enabled=true)
	public void postive_TC01() {
		logger=extent.createTest("Positive Test Scenerio");
		
		logger.log(Status.INFO, "------Test started-------");
		login_page obj = new login_page(driver);
		obj.set_data("Admin", "admin123");

		obj.click_loginbutton();
		
		Assert.assertTrue(obj.validate_PositiveTC("Dashboard"));
		logger.log(Status.INFO, "------Test end-------");
	}
	
	@Test(priority=2,enabled=false)
	public void negative_TC01() {	
		logger=extent.createTest("Positive Test Scenerio");
		
		login_page obj = new login_page(driver);
		obj.set_data("Admin12345", "05465123");

		obj.click_loginbutton();
		
		Assert.assertTrue(obj.validate_NegativeTC("Invalid credentials"));
		
	}



}
