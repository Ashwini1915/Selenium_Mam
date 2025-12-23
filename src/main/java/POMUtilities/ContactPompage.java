package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPompage {

	// Declare
	@FindBy(linkText = "Contacts")
	private WebElement contact_header;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement conplusicon;

	// Initialization

	public ContactPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public String getContact_header() {
		return contact_header.getText();
	}

	public void getConplusicon() {
		conplusicon.click();
	}

}
