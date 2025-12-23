package POMUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPompage {

	// Declare
	@FindBy(xpath = "//span[contains(text(),'Organization Information')]")
	private WebElement orginfo_header;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement verifyOrg;

	@FindBy(id = "dtlview_Phone")
	private WebElement verifyPhno;

	@FindBy(id = "dtlview_Industry")
	private WebElement verifyIndustry;

	@FindBy(id = "dtlview_Type")
	private WebElement verifyType;

	// Initialize
	public OrgInfoPompage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilize
	public String getOrginfo_header() {
		return orginfo_header.getText();
	}

	public String getVerifyOrg() {
		return verifyOrg.getText();
	}

	public String getVerifyPhno() {
		return verifyPhno.getText();
	}

	public String getVerifyIndustry() {
		return verifyIndustry.getText();
	}

	public String getVerifyType() {
		return verifyType.getText();
	}

}
