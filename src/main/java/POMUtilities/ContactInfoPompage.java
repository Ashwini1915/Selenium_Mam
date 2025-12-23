package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPompage {

	// Declare
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement coninfo_header;

	@FindBy(id = "dtlview_Last Name")
	private WebElement verifyLastname;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement verifyOrgname;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement verifyStartdate;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement verifyEnddate;

	// Initialization
	public ContactInfoPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getConinfo_header() {
		return coninfo_header.getText();
	}

	public String getVerifyLastname() {
		return verifyLastname.getText();
	}

	public String getVerifyOrgname() {
		return verifyOrgname.getText();
	}

	public String getVerifyStartdate() {
		return verifyStartdate.getText();
	}

	public String getVerifyEnddate() {
		return verifyEnddate.getText();
	}

}
