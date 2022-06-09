package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.AuraBy;
import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.Page;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.TextType;

@Page(title = "wocst_LUI", summary = "", relativeUrl = "", connection = "QARSF_Admin"

)

public class wocst_LUI {

	public WebDriver driver;

	public wocst_LUI(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//label[normalize-space(.)='*Target Site']/following-sibling::div//button")
	public WebElement clearSite;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Target Site']/following-sibling::div//input")
	public WebElement site;

	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//li//lightning-formatted-text")
	public WebElement selectSite;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Item Number']/following-sibling::div//input")
	public WebElement ItemNumber;

	@TextType()
	@AuraBy(componentXPath = "//lightning:input[@value='{!v.currentRecord.rstk__wocst_ordno__c}']", qualifier = "rstk__wocst_ordno__c")
	public WebElement orderNumber;

	@TextType()
	@FindBy(xpath = "//input[@name='rstk__wocst_qtyreq__c']")
	public WebElement qtyRequired;

	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//div/span/lightning-formatted-text")
	public WebElement selectItem;

	@BooleanType()
	@FindBy(xpath = "//input[@name='rstk__wocst_reworkind__c']")
	public WebElement rework;

	@BooleanType()
	@FindBy(xpath = "//input[@name='rstk__wocst_refurbind__c']")
	public WebElement refurb;

	@TextType()
	@FindBy(xpath = "//input[@name='rstk__wocst_duedte__c']")
	public WebElement dueDate;

	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//label[normalize-space(.)='*Project']/following-sibling::div//button")
	public WebElement clearProject;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Project']/following-sibling::div//input")
	public WebElement project;

	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//li[1]/div")
	public WebElement selectProjectName;

	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//label[normalize-space(.)='*Project']/following-sibling::div//a")
	public WebElement selectedProjectName;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Project Charge Code']/following-sibling::div//input")
	public WebElement projectChargeCode;

	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//li[1]/div")
	public WebElement selectProjectChargeCode;

	@BooleanType()
	@FindBy(xpath = "//input[@name='rstk__wocst_consignind__c']")
	public WebElement consigned;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[normalize-space(.)='Save']")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='Order Number']/following-sibling::div/lightning-formatted-text")
	public WebElement orderNumber1;

	public String readOrderNumber() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String element = "//span[normalize-space(.)='Order Number']/following-sibling::div/lightning-formatted-text";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));

		return driver.findElement(By.xpath(element)).getText();

	}

	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='Status']/following-sibling::div/lightning-formatted-text")
	public WebElement status;

	@LinkType()
	@AuraBy(componentXPath = "//lightning:menuItem[@value= '{!quickAction.name}' and @label='Edit']")
	public WebElement edit;

	@TextType()
	@FindBy(xpath = "//input[@name='rstk__wocst_lotno__c']")
	public WebElement lotNumber;

	@TextType()
	@FindBy(xpath = "//input[@name='rstk__wocst_lotexpiredate__c']")
	public WebElement lotExpirationDate;

	@ButtonType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[normalize-space(.)='Save']")
	public WebElement save1;

	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[normalize-space(.)='ActionsShow menu']")
	public WebElement actions;

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Generate Serials']")
	public WebElement generateSerials;

	@ChoiceListType()
	@FindBy(xpath = "//select[@name='Serial_Entry_Options']")
	public WebElement serialEntryOptions;

	public void setSerial(String serial) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Serial_Numbers_comma_separated']")));

		driver.findElement(By.xpath("//input[@name='Serial_Numbers_comma_separated']")).sendKeys(serial);
	}

	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Next']")
	public WebElement next;

	@TextType()
	@FindBy(xpath = "//lightning-formatted-rich-text//p")
	public WebElement flowCompletionMessage;

	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Finish']")
	public WebElement finish;

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Extract Components']")
	public WebElement extractComponents;

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Extract Operations']")
	public WebElement extractOperations;

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Extract Operations & Components']")
	public WebElement extractOperationsAndComponets;

	@TextType()
	@FindBy(xpath = "//lightning-formatted-rich-text//b")
	public WebElement successMessage;

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Allocate Components']")
	public WebElement allocateComponents;

	public String readToastMessageText() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage forceActionsText']")));
		return driver.findElement(By.xpath("//span[@class='toastMessage forceActionsText']")).getText();

	}

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Generate Picklist']")
	public WebElement generatePicklist;

	@BooleanType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//label/span[1]")
	public WebElement includeBackflush_;

	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='Issue']")
	public WebElement issue;

	public void enterIssueFrom(String IssueFrom) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String locator = "//label[text()='Issue from:' or text()='Select a Location Id']/parent::div//following::input[1]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		driver.findElement(By.xpath(locator)).sendKeys(IssueFrom);
		String autoComplete = "//label[text()='Issue from:' or text()='Select a Location Id']/parent::div//following::ul[@role='listbox']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(autoComplete)));
		driver.findElement(By.xpath(autoComplete)).click();
	}

	@TextType()
	@FindBy(xpath = "//input[@name='Quantity_To_Issue']")
	public WebElement quantityToIssue;

	@TextType()
	@FindBy(xpath = "//*[normalize-space()='Component Item']//parent::p/text()")
	public WebElement componentItemName;

	@TextType()
	@FindBy(css = "#flowContainer span p")
	public WebElement flowProcessStatus;

	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='Time And Quantity Booking']")
	public WebElement timeAndQuantityBooking;

	@ButtonType()
	@FindBy(xpath = "//label[normalize-space(.)='*Employee']/parent::div//following-sibling::div//button")
	public WebElement clearEmployee;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Employee']/parent::div/following-sibling::div//input")
	public WebElement empName;

	@TextType()
	@FindBy(xpath = "//input[@name='Override_Employee_Rate']")
	public WebElement overrideEmployeeRate;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='*']/following-sibling::div//select")
	public WebElement operation;

	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Enter Hours']")
	public WebElement enterHours;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Enter Hours']/following-sibling::div//input")
	public WebElement enterHoursText;

	@TextType()
	@FindBy(xpath = "//input[@name='Quantity_Complete']")
	public WebElement quantityComplete;

	@TextType()
	@FindBy(xpath = "//input[@name='Txn_Comments']")
	public WebElement txnComments;

	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='Receive']")
	public WebElement receive;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*Inventory Location']/following-sibling::div[1]//input")
	public WebElement inventoryLocation;

	@TextType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//li[1]/div")
	public WebElement selectInventoryLocation;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Inventory Location Number']/following-sibling::div//input")
	public WebElement inventoryLocationNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Quantity']/following-sibling::div//input")
	public WebElement transactionQuantity;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Comments']/following-sibling::div//textarea")
	public WebElement transactionComments;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Location Comments']/following-sibling::div//textarea")
	public WebElement locationComments;

	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Receive']")
	public WebElement Receive;

	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='Close']")
	public WebElement close;

}
