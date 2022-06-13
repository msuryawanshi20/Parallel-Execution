package pageobjects;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TestLogger;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__laborclockinout", summary = "", page = "LaborClockInOut", namespacePrefix = "rstk", object = "rstk__icclocktxn__c", connection = "QARSF_Admin")

public class rstk__laborclockinout {

	public WebDriver driver;

	public rstk__laborclockinout(WebDriver driver) {
		this.driver = driver;
	}

	@ButtonType()
	@FindByLabel(label = "Override Employee Rate")
	public WebElement overrideEmployeeRate;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Override Employee Rate']/following-sibling::input")
	public WebElement overrideEmployeeRate1;

	@ButtonType()
	@FindBy(xpath = "//input[@id='setbutton']")
	public WebElement oK;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Show Only Operations with Qty Available']/parent::span/parent::th/following-sibling::td//input")
	public WebElement showOnlyOperationswithQtyAvailable;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Search Work Orders']/parent::span/parent::th/following-sibling::td//input")
	public WebElement searchWorkOrders;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//li[@id='li-0']")
	public WebElement list;

	@ButtonType()
	@FindByLabel(label = "Load Entry Grid")
	public WebElement loadEntryGrid;

	@PageRow()
	public static class TimeAndQtyBookingDetailsTable {

		@ChoiceListType()
		@FindBy(xpath = ".//tr/td[2]/select")
		public WebElement bookingType;

		@TextType()
		@FindBy(xpath = ".//tr/td[3]//input")
		public WebElement transactionDate;

		@TextType()
		@FindBy(xpath = ".//tr/td[6]//input")
		public WebElement hours;

		@ChoiceListType()
		@FindBy(xpath = ".//tr/td[7]//select")
		public WebElement workOrder;

		@ChoiceListType()
		@FindBy(xpath = ".//tr/td[8]//select")
		public WebElement operation;

		@BooleanType()
		@FindBy(xpath = ".//tr/td[9]//input")
		public WebElement setupLabor;

		@BooleanType()
		@FindBy(xpath = ".//tr/td[10]//input")
		public WebElement complete;

		@BooleanType()
		@FindBy(xpath = ".//tr/td[11]//input")
		public WebElement moveOnly;

		@BooleanType()
		@FindBy(xpath = ".//tr/td[12]//input")
		public WebElement ship;

		@TextType()
		@FindBy(xpath = ".//tr/td[13]//input")
		public WebElement quantity;

		@ChoiceListType()
		@FindBy(xpath = ".//tr/td[15]//select")
		public WebElement laborPayType;

		@TextType()
		@FindBy(xpath = ".//tr/td[16]//input")
		public WebElement oPComments;

		@TextType()
		@FindBy(xpath = ".//tr/td[17]//input")
		public WebElement txnComments;

	}

	@FindBy(id = "pg:fm:pb_bookings:j_id224:0:j_id226:j_id227:j_id228:tb")
	@PageTable(firstRowContainsHeaders = false, row = TimeAndQtyBookingDetailsTable.class)
	public List<TimeAndQtyBookingDetailsTable> timeAndQtyBookingDetailsTable;

	@ButtonType()
	@FindByLabel(label = "Submit Bookings")
	public WebElement submitBookings;

	@TestLogger
	public Logger testLogger;

	public void searchAndSelectWorkOrder(String workOrderNumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String xpath = "//input[@id='labbooking_wocst__c_autocomplete']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		WebElement ele = driver.findElement(By.xpath(xpath));

		ele.sendKeys(workOrderNumber);
		Actions actions = new Actions(driver);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac_results'][3]/ul[@id='IDREF']/li")));

		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][3]/ul[@id='IDREF']/li"));

		testLogger.info("Size" + autoCompleteList.size());

		while (autoCompleteList.size() > 10) {
			ele.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			autoCompleteList = driver.findElements(By.xpath("//div[@class='ac_results'][3]/ul[@id='IDREF']/li"));

		}

		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(500);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			testLogger.info("CurrentWorkOrderName" + autoCompleteList.get(i).getText());

			if (autoCompleteList.get(i).getText().startsWith(workOrderNumber)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}

	}
}
