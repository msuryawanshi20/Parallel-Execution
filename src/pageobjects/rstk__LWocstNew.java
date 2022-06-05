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
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__ L Wocst New", summary = "", page = "LWocstNew", namespacePrefix = "rstk", object = "rstk__lwocst__c", connection = "QARSF_Admin")
public class rstk__LWocstNew {

	public WebDriver driver;

	public rstk__LWocstNew(WebDriver driver) {
		this.driver = driver;
	}

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Order Number']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement orderNumber;

	@PageWaitAfter.Field(field = "list", timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//input[@id='lwocst_item__c_autocomplete']")
	public WebElement itemNumber;

	@TextType()
	@FindBy(xpath = "//li[@id='li-0']")
	public WebElement list;

	public void selectInventoryItem(String InventoryItemName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String elementLocator = "//input[@name='lwocst_item__c_autocomplete']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));

		WebElement ele = driver.findElement(By.xpath(elementLocator));
		ele.sendKeys(InventoryItemName);

		Actions actions = new Actions(driver);

		String listLocator = "//div[@class='ac_results'][1]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));

		List<WebElement> autoCompleteList = driver.findElements(By.xpath(listLocator));
		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(InventoryItemName)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	public void selectProject(String ProjectName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String elementLocator = "//input[@name='lwocst_proj__c_autocomplete']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));

		WebElement ele = driver.findElement(By.xpath(elementLocator));

		ele.clear();
		ele.sendKeys(ProjectName);

		Actions actions = new Actions(driver);

		String listLocator = "//div[@class='ac_results'][2]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));

		List<WebElement> autoCompleteList = driver.findElements(By.xpath(listLocator));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(500);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().equalsIgnoreCase(ProjectName)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Project Charge Code']/ancestor::th/following-sibling::td//select")
	public WebElement ProjectChargeCode;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Quantity']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement quantity;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Due Date']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement dueDate;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Extract Routing']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement extractRouting;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Order Number']/ancestor::span/ancestor::th/following-sibling::td[1]//span")
	public WebElement orderNumber1;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//span[contains(@id,'lwocst_ordsts')]")
	public WebElement status;

	@PageWaitAfter.Field(field = "addOperation", timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//*[contains(@id,'tab_Operations_lbl')]")
	public WebElement tab_Operations_lbl;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Add Operation")
	public WebElement addOperation;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Add Concurrent Operation")
	public WebElement addConcurrentOperation;

	@ButtonType()
	@FindByLabel(label = "Release")
	public WebElement release;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Complete")
	public WebElement complete;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Close Work Order")
	public WebElement closeWorkOrder;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Reverse WO Close")
	public WebElement reverseWOClose;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Reverse Complete")
	public WebElement reverseComplete;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Recall")
	public WebElement recall;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Delete Routing")
	public WebElement deleteRouting;

}
