package organizationModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import POMUtilities.CreateOrgPompage;
import POMUtilities.HomePompage;
import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;

public class CreateOrgWithPhnoTest extends BaseClass {

	@Test
	public void createOrgWithPhnoTest() throws InterruptedException, IOException {

		// Creating instances
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility exutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// Get the random no
		int randomint = jutil.generateRandomNo();

		// Fetch data from excel utility
		String orgname = exutil.fetchDataFromExcelFile("organization", 7, 2) + randomint;
		String phno = exutil.fetchDataFromExcelFile("organization", 7, 3);

		HomePompage home = new HomePompage(driver);

		// Identify org tab and click on it
		home.getOrg_tab();

		// Identify plus icon and click on it
		OrgPompage org = new OrgPompage(driver);
		org.getPlusicon();

		// Identify org TF and enter orgname
		CreateOrgPompage createOrg = new CreateOrgPompage(driver);
		createOrg.getOrgnameTF(orgname);
		// identify Phno Tf and pass the phno
		createOrg.getPhnoTF(phno);
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

		// Validate ph no
		String verifyphno = orginfo.getVerifyPhno();

		if (verifyphno.contains(phno)) {
			Reporter.log("Create org with phno Test pass", true);
		} else {
			Reporter.log("Create org with phno Test fail", true);
		}
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
