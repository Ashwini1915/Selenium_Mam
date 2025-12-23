package contactModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import POMUtilities.ContactInfoPompage;
import POMUtilities.ContactPompage;
import POMUtilities.CreateContactPompage;
import POMUtilities.CreateOrgPompage;
import POMUtilities.HomePompage;
import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void conWithOrgTest() throws IOException, InterruptedException {

		// Creating instances
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility exutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// Get the random no
		int randomint = jutil.generateRandomNo();

		// Fetch data from excel utility
		String conname = exutil.fetchDataFromExcelFile("contact", 4, 2) + randomint;
		String orgname = exutil.fetchDataFromExcelFile("contact", 4, 3) + randomint;

		HomePompage home = new HomePompage(driver);

		// Identify org tab and click on it
		home.getOrg_tab();

		// Identify plus icon and click on it
		OrgPompage org = new OrgPompage(driver);
		org.getPlusicon();

		// Identify org TF and enter orgname
		CreateOrgPompage createOrg = new CreateOrgPompage(driver);
		createOrg.getOrgnameTF(orgname);

		// Identify save btn and click on it
		createOrg.getSaveBtn();

		// Validate org name
		OrgInfoPompage orginfo = new OrgInfoPompage(driver);

		String verifyorg = orginfo.getVerifyOrg();

		if (verifyorg.contains(orgname)) {
			Reporter.log("Create Org Test Pass", true);
		} else {
			Reporter.log("Create Org Test Fail", true);
		}

		// Identify contact tab and click on it
		home.getContact_tab();

		// Identify plus icon and click on it
		ContactPompage con = new ContactPompage(driver);
		con.getConplusicon();

		// Identify lastname TF and enter cont name
		CreateContactPompage createcon = new CreateContactPompage(driver);
		createcon.getLastnameTF(conname);

		// Identify org plus icon and click on it
		createcon.getOrg_plusicon();

		// Fetch parent window id
		String pwid = wutil.fetchTheParentWindowId(driver);

		// Switch the driver control to child window
		wutil.switchToWindowUsingUrl(driver, "Accounts&action");

		// Search for org name
		createcon.getSearchTF(orgname);
		createcon.getSearchNowBtn();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// Switch back to parent window
		wutil.switchBackToParent(driver, pwid);

		// Identify save btn and click on it
		createcon.getSaveBtn();

		// Validate contact name
		ContactInfoPompage coninfo = new ContactInfoPompage(driver);
		String verifyconname = coninfo.getVerifyLastname();

		if (verifyconname.contains(conname)) {
			Reporter.log("Create contact Test pass", true);
		} else {
			Reporter.log("Create contact Test fail", true);
		}

		// Validate org name in contact info
		String verifyorg_con = coninfo.getVerifyOrgname();
		if (verifyorg_con.contains(orgname)) {
			Reporter.log("Create contact with org Test pass", true);
		} else {
			Reporter.log("Create contact with org Test fail", true);
		}

		// Identify contact tab and click on it
		home.getContact_tab();

		// Identify delete link and click on it
		driver.findElement(
				By.xpath("//a[text()='" + conname + "']/ancestor::tr[@bgcolor='white']/descendant::a[text()='del']"))
				.click();

		Thread.sleep(2000);

		// Handle alert popup
		wutil.switchToAlert_ClickOK(driver);

		// Identify org tab and click on it
		home.getOrg_tab();

		// Delete the org
		driver.findElement(By.xpath(
				"//a[text()='" + orgname + "' and contains(@href,'Marketing&')]/../../descendant::a[text()='del']"))
				.click();

		Thread.sleep(2000);

		// Handle alert popup
		wutil.switchToAlert_ClickOK(driver);

		// Close the excel
		exutil.closeExcelFile();
	}

}
