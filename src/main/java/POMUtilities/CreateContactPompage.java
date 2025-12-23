package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPompage {

	// Declare
	@FindBy(xpath = "//span[text()='Creating New Contact']")
	private WebElement createCon_header;

	@FindBy(xpath = "//img[contains(@onclick,'Accounts&action')]")
	private WebElement org_plusicon;

	@FindBy(name = "support_start_date")
	private WebElement suppStartdateTF;

	@FindBy(name = "support_end_date")
	private WebElement suppEnddateTF;

	@FindBy(name = "lastname")
	private WebElement lastnameTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(id = "search_txt")
	private WebElement searchTF;

	@FindBy(name = "search")
	private WebElement searchNowBtn;

	// Initialize
	public CreateContactPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilize

	public String getCreateCon_header() {
		return createCon_header.getText();
	}

	public void getOrg_plusicon() {
		org_plusicon.click();
	}

	public void getSuppStartdateTF(String startdate) {
		suppStartdateTF.clear();
		suppStartdateTF.sendKeys(startdate);
	}

	public void getSuppEnddateTF(String enddate) {
		suppEnddateTF.clear();
		suppEnddateTF.sendKeys(enddate);
	}

	public void getLastnameTF(String conname) {
		lastnameTF.sendKeys(conname);
	}

	public void getSaveBtn() {
		saveBtn.click();
	}

	public void getSearchTF(String orgname) {
		searchTF.sendKeys(orgname);
	}

	public void getSearchNowBtn() {
		searchNowBtn.click();
	}

}
