package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPompage {

	// Declare

	@FindBy(linkText = "vtiger")
	private WebElement vtiger_header;

	@FindBy(name = "user_name")
	private WebElement usernameTF;

	@FindBy(name = "user_password")
	private WebElement passwordTF;

	@FindBy(id = "submitButton")
	private WebElement loginBTN;

	// Initialize

	public LoginPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilize

	public String getVtiger_header() {
		return vtiger_header.getText();
	}

	public void getUsernameTF(String user) {
		usernameTF.sendKeys(user);
	}

	public void getPasswordTF(String pass) {
		passwordTF.sendKeys(pass);
	}

	public void getLoginBTN() {
		loginBTN.click();
	}

	// Bussiness logic
	public void login(String user, String pass) {
		usernameTF.sendKeys(user);
		passwordTF.sendKeys(pass);
		loginBTN.click();
	}

	public void login() {
		usernameTF.sendKeys("admin");
		passwordTF.sendKeys("password");
		loginBTN.click();
	}
}
