package organizationModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import POMUtilities.CreateOrgPompage;
import POMUtilities.HomePompage;
import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;

public class CreateOrgWithIndAndTypeTest extends BaseClass {

	@Test
	public void OrgWithIndAndTypeTest() throws IOException, InterruptedException {

		// Creating instances
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility exutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// Get the random no
		int randomint = jutil.generateRandomNo();

		// Fetch data from excel utility
		String orgname = exutil.fetchDataFromExcelFile("organization", 4, 2) + randomint;
		String industry = exutil.fetchDataFromExcelFile("organization", 4, 3);
		String type = exutil.fetchDataFromExcelFile("organization", 4, 4);

		HomePompage home = new HomePompage(driver);

		// Identify org tab and click on it
		home.getOrg_tab();

		// Identify plus icon and click on it
		OrgPompage org = new OrgPompage(driver);
		org.getPlusicon();
		// Identify org TF and enter orgname
		CreateOrgPompage createOrg = new CreateOrgPompage(driver);
		createOrg.getOrgnameTF(orgname);
		// Identify industry DD and select the value
		WebElement ind_dd = createOrg.getIndustryDD();

		wutil.selectDDByValue(ind_dd, industry);

		// Identify type DD and select the value
		WebElement type_dd = createOrg.getTypeDD();

		wutil.selectDDByValue(type_dd, type);

		// Identify save btn and click on it
		createOrg.getSaveBtn();
		// Validate org name
		OrgInfoPompage orginfo = new OrgInfoPompage(driver);
		String verifyorg = orginfo.getVerifyOrg();

		if (verifyorg.contains(orgname)) {
			System.out.println("Create Org Test Pass");
		} else {
			System.out.println("Create Org Test Fail");
		}

		// Verify industry
		String verifyInd = orginfo.getVerifyIndustry();

		if (verifyInd.contains(industry)) {
			System.out.println("Create org with industry Test pass");
		} else {
			System.out.println("Create org with industry Test fail");
		}

		// Verify type
		String verifytype = orginfo.getVerifyType();

		if (verifytype.contains(type)) {
			System.out.println("Create org with Type Test pass");
		} else {
			System.out.println("Create org with Type Test fail");
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
