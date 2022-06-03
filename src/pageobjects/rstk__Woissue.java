package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;

@SalesforcePage(title = "Rstk__ Woissue", summary = "", page = "Woissue", namespacePrefix = "rstk", object = "rstk__woiss__c", connection = "QARSF_Admin")
public class rstk__Woissue {

	public WebDriver driver;

	public rstk__Woissue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@ButtonType()
	@FindBy(xpath = "//*[@value='Issue Selected Components']")
	public WebElement issueSelectedComponents;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ChoiceListType()
	@FindBy(name = "pg:fm:pb_search:pbs_search:j_id88:j_id106:j_id107:woiss_hdrordno__c:j_id109:j_id115")
	public WebElement Work_Order;

	public void selectWOrkOrderfromPicklist(String workOrderNumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='hdrordno__c_autocomplete']")));

		WebElement ele = driver.findElement(By.xpath("//input[@id='hdrordno__c_autocomplete']"));

		ele.sendKeys(workOrderNumber);
		Actions actions = new Actions(driver);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li")));

		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li"));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(500);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(workOrderNumber)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Display Components")
	public WebElement displayComponents;

	@LinkType()
	@FindBy(linkText = "Rootstock Site Map")
	public WebElement rootstockSiteMap;

	@BooleanType
	@FindBy(xpath = "//label[normalize-space(.)='Select All']/parent::span/input")
	public WebElement selectAllCheckBox;
}
