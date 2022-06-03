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
import com.provar.core.testapi.annotations.DateType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__dwocst", summary = "", page = "DWocst", namespacePrefix = "rstk", object = "rstk__wocst__c", connection = "QARSF_Admin")
public class rstk__dwocst {
	public WebDriver driver;

	public rstk__dwocst(WebDriver driver) {
		this.driver = driver;
	}

	@TextType()
	@FindBy(xpath = "//*[contains(@id,'wocst_ordno__c')]//input")
	public WebElement orderNumber;

	@TextType()
	@FindBy(xpath = "//input[@id='wocst_item__c_autocomplete']")
	public WebElement DisassemblyItemText;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(id = "li-0")
	public WebElement DisassemblyItemLookup;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Disassembly Item Quantity']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement disassemblyItemQuantity;

	@DateType
	@FindBy(xpath = "//input[contains(@id,'wocst_duedte__c')]")
	public WebElement dueDate;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Project']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement project;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Project Charge Code']/ancestor::th/following-sibling::td//select")
	public WebElement projectChargeCode;

	public void selectProject(String ProjectName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String elementLocator = "//input[@name='wocst_proj__c_autocomplete']";
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

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//*[contains(@id,'tab_ConsumableComponents_lbl')]")
	public WebElement tab_ConsumableComponents_lbl;

	@ButtonType()
	@FindBy(xpath = "//input[@value='Add Component']")
	public WebElement addComponent;

	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//*[contains(text(),' Status')]//following::td//span[contains(@id,'wocst_ordsts_pl__c')]")
	public WebElement status;

	@TextType()
	@FindBy(xpath = "//*[contains(@id,'wocst_ordno__c')]//span//span")
	public WebElement opOrderNumber;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Issue Disassembly Item")
	public WebElement issueDisassemblyItem;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//*[@value='Generate Picklist']")
	public WebElement generatePicklist;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//*[@value='Allocate']")
	public WebElement allocate;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//*[contains(@value,'Deallocate')]")
	public WebElement deallocate;

	@LinkType()
	@FindBy(linkText = "Rootstock Site Map")
	public WebElement rootstockSiteMap;

	@TextType()
	@FindBy(xpath = "//*[contains(@id,'tab_DerivedComponents_lbl')]")
	public WebElement tab_DerivedComponents_lbl;

	@ButtonType()
	@FindByLabel(label = "All")
	public WebElement all;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@PageTable(firstRowContainsHeaders = false, row = DerivedComponents.class)
	@FindBy(xpath = "//table[contains(@id,'pbs_DerivedComponents')]//tbody//tr")
	public List<DerivedComponents> derivedComponents;

	@PageRow(byColumn = true)
	public static class DerivedComponents {

		@LinkType
		@FindBy(xpath = ".//td[1]//a[text()='Edit']")
		public WebElement edit;

		@TextType()
		@FindBy(xpath = ".//td[3]")
		public WebElement derivedComponent;

		@TextType()
		@FindBy(xpath = ".//td[5]//input")
		public WebElement expected;

		@TextType()
		@FindBy(xpath = ".//td[7]//input")
		public WebElement actualYield;

		@ChoiceListType
		@FindBy(xpath = ".//td[11]/select//option")
		public WebElement locationID;

		@BooleanType
		@FindBy(xpath = ".//td[2]//input[@type='checkbox']")
		public WebElement select;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Accept Updated Values']")
	public WebElement acceptUpdatedValues;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Receive Derived Components']")
	public WebElement receiveDerivedComponents;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Close Work Order")
	public WebElement closeWorkOrder;

	@ButtonType()
	@FindBy(xpath = "//input[@value='Add Derived Component']")
	public WebElement addDerivedComponent;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Component Issue']")
	public WebElement componentIssue;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Complete Disassembly Order']")
	public WebElement completeDisassemblyOrder;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Reverse Derived Components']")
	public WebElement reverseDerivedComponents;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Reverse WO Close")
	public WebElement reverseWOClose;

}
