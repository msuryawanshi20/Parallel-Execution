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
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__ Wocst", summary = "", page = "Wocst", namespacePrefix = "rstk", object = "rstk__wocst__c", connection = "QARSF_Admin")

public class rstk__Wocst {

	public WebDriver driver;

	public rstk__Wocst(WebDriver driver) {
		this.driver = driver;
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Site']/ancestor::span/ancestor::th/following-sibling::td[1]//select")
	public WebElement Site;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Order Number']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement orderNumber;

	public void selectInventoryItem(String InventoryItemName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='wocst_item__c_autocomplete']")));

		WebElement ele = driver.findElement(By.xpath("//input[@name='wocst_item__c_autocomplete']"));

		ele.sendKeys(InventoryItemName);
		Actions actions = new Actions(driver);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li")));

		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li"));

		for (int i = 0; i < autoCompleteList.size(); i++) {
		Thread.sleep(500);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(InventoryItemName)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	public void selectProject(String ProjectName) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement ele = driver.findElement(By.xpath("//input[@name='wocst_proj__c_autocomplete']"));
		ele.clear();
		ele.sendKeys(ProjectName);

		Actions actions = new Actions(driver);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac_results'][2]/ul[@id='IDREF']/li")));
		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][2]/ul[@id='IDREF']/li"));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().equalsIgnoreCase(ProjectName)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Qty Required']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement qtyRequired;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Qty Required']/ancestor::span/ancestor::th/following-sibling::td[1]//span")
	public WebElement readQtyRequired;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Due Date']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement dueDate;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Order Number']/ancestor::span/ancestor::th/following-sibling::td[1]//span")
	public WebElement orderNumber1;

	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Status']/ancestor::span/ancestor::th/following-sibling::td//span")
	public WebElement status;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Project Charge Code']/ancestor::th/following-sibling::td//select")
	public WebElement projectChargeCode;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Project']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement project;

	@TextType()
	@FindBy(xpath = "//input[@id='wocst_item__c_autocomplete']")
	public WebElement itemName;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='extractOperationsAndComponents']")
	public WebElement extractOperationsAndComponents;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='extractCompOpt']")
	public WebElement extractOperationsAndComponents1;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='allocateDemandsBtn']")
	public WebElement allocate;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//*[contains(@value,'Deallocate')]")
	public WebElement deallocate;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@ButtonType()
	@FindBy(xpath = "//input[@id='generatePickListRecords']")
	public WebElement generatePickList;

	@BooleanType()
	@FindBy(xpath = "//input[@id='incBackflush2']")
	public WebElement includeBackflushComponentsinPicklist;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@ButtonType()
	@FindBy(xpath = "//div[@id='generatePicklist']/p[2]/input[1]")
	public WebElement generatePicklist;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@FindBy(xpath = "//td[contains(@id,'Lot_lbl')]/parent::tr")
	public WebElement lot;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Lot Number']/ancestor::span/ancestor::th/following-sibling::td[1]//input")
	public WebElement lotNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Lot Expiration Date']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement lotExpirationDate;

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
	@FindBy(xpath = "//input[@id='deleteOperations']")
	public WebElement deleteOperations;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='deleteComponents']")
	public WebElement deleteComponents;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//img[@name='Related Lists']")
	public WebElement relatedLists;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Add Component']")
	public WebElement addComponent;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@ButtonType()
	@FindByLabel(label = "Generate Serials")
	public WebElement generateSerials;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//*[contains(@id,'tab_SerialNumbers_lbl')]")
	public WebElement tab_SerialNumbers_lbl;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//img[@name='Serial Number Fast Entry']")
	public WebElement pbs_SNFastEntry;

	@ButtonType
	@FindBy(xpath = "//input[@value='Assign']")
	public WebElement assignSerialBtn;

	public void setSerial(String serial) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='srlnums']")));

		driver.findElement(By.xpath("//textarea[@id='srlnums']")).sendKeys(serial + "\n");
	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//*[contains(@id,'tab_Operations_lbl')]")
	public WebElement tab_Operations_lbl;

	@ButtonType()
	@FindBy(xpath = "//input[contains(@value,'Add Standard Operation')]")
	public WebElement addStandardOperation;

	@ButtonType()
	@FindBy(xpath = "//input[contains(@value,'Add Subcontract Operation')]")
	public WebElement addSubcontractOperation;

	@ButtonType()
	@FindBy(xpath = "//input[contains(@value,'Add Concurrent Operation')]")
	public WebElement addConcurrentOperation;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Rework']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement rework;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Refurb']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement refurb;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Consigned']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement consigned;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='extractOperations']")
	public WebElement extractOperations;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Extract Operations']")
	public WebElement extractOperations1;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@id='extractComponents']")
	public WebElement extractComponets;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Extract Components']")
	public WebElement extractComponets1;

	public void selectComponent(String Component) {

		driver.findElement(By.xpath("//div[@id='selectRefurb']//table[@class='list']//tbody//tr/td[contains(text(),'"
				+ Component + "')]/parent::tr//td[1]/input[1]")).click();
	}

	@ButtonType()
	@FindBy(xpath = "//div[@id='selectRefurb']/div[@id='issueBtns']/p/input")
	public WebElement oK;

	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//*[contains(@id,'tab_Totalcost_lbl')]")
	public WebElement tab_Totalcost_lbl;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Material']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_Material;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Labor']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_Labor;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Material Overhead']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_MaterialOverhead;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Labor Overhead']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_LaborOverhead;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Fringe Overhead']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_FringeOverhead;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Machine Overhead']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_MachineOverhead;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Subcontract Material']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_SubcontractMaterial;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Subcontract Labor']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_SubcontractLabor;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Freight']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_Freight;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Other Indirect']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_OtherIndirect;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Total Charges']/ancestor::td/following-sibling::td[1]//span")
	public WebElement charges_TotalCharges;

}
