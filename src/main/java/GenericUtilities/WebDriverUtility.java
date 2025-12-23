package GenericUtilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author B.Nandini This class contains all reusable methods from selenium
 *         library
 */
public class WebDriverUtility {

	public void navigateToAnAppln(WebDriver driver, String url) {
		driver.get(url);
	}

	public String fetchTheTitle(WebDriver driver) {

		String title = driver.getTitle();
		return title;
	}

	public String fetchTheCurrentUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String fetchThePageSource(WebDriver driver) {
		String sc = driver.getPageSource();
		return sc;
	}

	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeTheWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void windowFullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	public Dimension fetchTheSize(WebDriver driver) {
		Dimension dim = driver.manage().window().getSize();
		return dim;
	}

	public Point fetchThePosition(WebDriver driver) {
		Point position = driver.manage().window().getPosition();
		return position;
	}

	public void setTheSize(WebDriver driver, int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	public void setThePosition(WebDriver driver, int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	public void navigateToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshThePage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void navigateToWebpage(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public void navigateToWP_UsingURL(WebDriver driver, String url) throws MalformedURLException {
		driver.navigate().to(new URL(url));
	}

	public void closeTheBrowser(WebDriver driver) {
		driver.close();
	}

	public void quitTheBrowser(WebDriver driver) {
		driver.quit();
	}

	public String fetchTheParentWindowId(WebDriver driver) {
		String pwid = driver.getWindowHandle();
		return pwid;
	}

	public Set<String> fetchAllWindowIds(WebDriver driver) {
		Set<String> wids = driver.getWindowHandles();
		return wids;

	}

	public void switchToWindowUsingTitle(WebDriver driver, String title) {
		Set<String> wids = driver.getWindowHandles();
		for (String s : wids) {
			driver.switchTo().window(s);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}

	}

	public void switchToWindowUsingUrl(WebDriver driver, String url) {
		Set<String> wids = driver.getWindowHandles();
		for (String s : wids) {
			driver.switchTo().window(s);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}

	}

	public void switchBackToParent(WebDriver driver, String pwid) {
		driver.switchTo().window(pwid);
	}

	public void switchToFrame_Index(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame_IdName(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	public void switchToFrame_Element(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void switchFromFrameToMWP(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToAlert_ClickOK(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlert_ClickCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String switchToAlert_fetchTheText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void switchToAlert_EnterText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);

	}

	public void waitForAnElement(WebDriver driver, String time) {
		long timeouts = Long.parseLong(time);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
	}

	public void waitUntilEle_Displayed(WebDriver driver, String time, WebElement ele) {
		long timeouts = Long.parseLong(time);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitUntilEle_Clickable(WebDriver driver, String time, WebElement ele) {
		long timeouts = Long.parseLong(time);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitUntilTitle_displayed(WebDriver driver, String time, String title) {
		long timeouts = Long.parseLong(time);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void selectDDByIndex(WebElement ddele, int index) {
		Select s = new Select(ddele);
		s.selectByIndex(index);
	}

	public void selectDDByValue(WebElement ddele, String value) {
		Select s = new Select(ddele);
		s.selectByValue(value);
	}

	public void selectDDByVisibleText(WebElement ddele, String text) {
		Select s = new Select(ddele);
		s.selectByVisibleText(text);
	}

	public void deselectDDByIndex(WebElement ddele, int index) {
		Select s = new Select(ddele);
		s.deselectByIndex(index);
	}

	public void deselectDDByValue(WebElement ddele, String value) {
		Select s = new Select(ddele);
		s.deselectByValue(value);
	}

	public void deselectDDByVisibleText(WebElement ddele, String text) {
		Select s = new Select(ddele);
		s.deselectByVisibleText(text);
	}

	public void deselectAllOptions(WebElement ddele) {
		Select s = new Select(ddele);
		s.deselectAll();
	}

	public boolean checkMultiSelectDD(WebElement ddele) {
		Select s = new Select(ddele);
		boolean res = s.isMultiple();
		return res;
	}

	public List<WebElement> fetchAllOptionsFromDD(WebElement ddele) {
		Select s = new Select(ddele);
		List<WebElement> options = s.getOptions();
		return options;
	}

	public WebElement fetchFirstSelectedFromDD(WebElement ddele) {
		Select s = new Select(ddele);
		WebElement firstselected = s.getFirstSelectedOption();
		return firstselected;
	}

	public List<WebElement> fetchAllSelectedFromDD(WebElement ddele) {
		Select s = new Select(ddele);
		List<WebElement> allselected = s.getAllSelectedOptions();
		return allselected;
	}

	public void mousehoverOnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void doubleClickOnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public void rightClickOnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public void dragAndDropTheEle(WebDriver driver, WebElement dragele, WebElement droploc) {
		Actions act = new Actions(driver);
		act.dragAndDrop(dragele, droploc).perform();
	}

	public void clickAndHoldAnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele).perform();
	}

	public void releaseAnEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.release(ele).perform();
	}

	public void scrollWebpageUsingAxis(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void scrollWebpageUsingEle(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}
}
