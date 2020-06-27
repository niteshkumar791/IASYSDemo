package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
	WebDriver driver;
	
	@FindBy(id="txtUsername")
	WebElement user_name;
	
	@FindBy(id="txtPassword")
	WebElement pass_word;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id="menu_dashboard_index")
	WebElement dash_board;
	
	@FindBy(id="spanMessage")
	WebElement msg;
	
	public login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void set_data(String username, String password) {		
		user_name.sendKeys(username);
		pass_word.sendKeys(password);		
	}
	
	public void click_loginbutton() {
		btnLogin.click();	
	}
	
	public boolean validate_PositiveTC(String expected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dash_board));
		
		if(dash_board.getText().equalsIgnoreCase(expected))
			return true;
		else
			return false;
		
	}
	
	public boolean validate_NegativeTC(String exptd) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(msg));
		
		if(msg.getText().equals(exptd))
			return true;
		else
			return false;
	}

}
