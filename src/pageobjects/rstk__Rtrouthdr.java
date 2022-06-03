package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__ Rtrouthdr", summary = "", page = "Rtrouthdr", namespacePrefix = "rstk", object = "rstk__rtrouthdr__c", connection = "QARSF_Admin")
public class rstk__Rtrouthdr {
	public WebDriver driver;

	public rstk__Rtrouthdr(WebDriver driver) {
		this.driver = driver;
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Site']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement site;

	public void selectItemNumber(String ItemNumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String elementLocator = "//input[@name='rtrouthdr_item__c_autocomplete']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));
		WebElement ele = driver.findElement(By.xpath(elementLocator));
		ele.sendKeys(ItemNumber);

		Actions actions = new Actions(driver);
		String listLocator = "//div[@class='ac_results'][1]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(listLocator));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(ItemNumber)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Name']/parent::th/following-sibling::td[1]/span/span")
	public WebElement name;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Responsible Engineer']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement responsibleEngineer;

	@FindBy(xpath = "//label[normalize-space(.)='Responsible Engineer']/parent::span/parent::th/following-sibling::td[1]//a")
	public WebElement responsibleEngineerText;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Responsible Planner']/parent::span/parent::th/following-sibling::td//select")
	public WebElement responsiblePlanner;

	@FindBy(xpath = "//label[normalize-space(.)='Responsible Planner']/parent::span/parent::th/following-sibling::td[1]//a")
	public WebElement responsiblePlannerText;

	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Delete")
	public WebElement delete;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Clone")
	public WebElement clone;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Source Add Revision']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement selectedSourceRevision;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Target Add Revision']/parent::span/parent::th/following-sibling::td//select")
	public WebElement targetRevision;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//a[contains(text(),'Add Standard Operation')]")
	public WebElement addStandardOperation;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//a[contains(text(),'Add Subcontract Operation')]")
	public WebElement addSubcontractOperation;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//a[contains(text(),'Add Concurrent Operation')]")
	public WebElement addConcurrentOperation;

}
