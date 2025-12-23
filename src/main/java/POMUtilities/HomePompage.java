package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePompage {

	// Declare
	@FindBy(partialLinkText = "Home")
	private WebElement homeheader;

	@FindBy(linkText = "Organizations")
	private WebElement org_tab;

	@FindBy(linkText = "Contacts")
	private WebElement contact_tab;

	@FindBy(xpath = "//img[contains(@src,'user')]")
	private WebElement admin;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	// Initialize
	public HomePompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilize

	public String getHomeheader() {
		return homeheader.getText();
	}

	public void getOrg_tab() {
		org_tab.click();
	}

	public void getContact_tab() {
		contact_tab.click();
	}

	public WebElement getAdmin() {
		return admin;
	}

	public void getSignout() {
		signout.click();
	}

	// Bussiness logic
	public void logout(WebDriverUtility wutil, WebDriver driver) {
		wutil.mousehoverOnEle(driver, getAdmin());
		signout.click();
	}
}
