package pageobjects;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.DateType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TestLogger;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__ Stocklocmove", summary = "", page = "Stocklocmove", namespacePrefix = "rstk", object = "rstk__locadd__c", connection = "QARSF_Admin")
public class rstk__Stocklocmove {

	public WebDriver driver;

	public rstk__Stocklocmove(WebDriver driver) {
		this.driver = driver;
	}

	@PageWaitAfter.Field(field = "Search_Item1", timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//input[contains(@id,'locmove_icitem__c_autocomplete')]")
	public WebElement Search_Item;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(id = "li-0")
	public WebElement Search_Item1;

	public void selectLocationIDfromPicklist(String locationID, String locationNo, String lotNumber, String project)
			throws InterruptedException {

		Thread.sleep(2000);
		if (lotNumber != null) {
			WebElement option = driver
					.findElement(By.xpath("//select[contains(@id,'fromlocation__c')]/option[contains(text(),'"
							+ locationID + " /') and contains(text(),'" + locationNo + "') and contains(text(),'(Lot:"
							+ lotNumber + ")') and contains(text(),'" + project + "')]"));
			System.out.println("Test:" + option);

			option.click();

		} else {
			WebElement option = driver
					.findElement(By.xpath("//select[contains(@id,'fromlocation__c')]/option[contains(text(),'"
							+ locationID + " /') and contains(text(),'" + locationNo + "') and contains(text(),'"
							+ project + "')]"));
			System.out.println("Test:" + option);

			option.click();

		}

	}

	/*
	 * public void selectSerialNumber(String serialNumber) throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(2000); WebElement option = driver.findElement(By.xpath(
	 * "//select[contains(@id,'available_serials__c')]/option[contains(text(),'" +
	 * serialNumber + "')]")); option.click();
	 * 
	 * }
	 */

	@TestLogger
	public Logger testLogger;

	public void selectSerialNumber(Integer NumberOfSerialTobeSelected) throws InterruptedException {

		Thread.sleep(2000);

		for (int i = 1; i <= NumberOfSerialTobeSelected; i++) {

			WebElement element = driver
					.findElement(By.xpath("//select[contains(@id,'available_serials__c')]/option[" + i + "]"));
			testLogger.info("Xpath:" + element);
			testLogger.info("Serial Number:" + element.getText());

			element.click();

		}
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Move Option']/ancestor::th/following-sibling::td//select")
	public WebElement MoveOption;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Display Loc Move Entries")
	public WebElement displayLocMoveEntries;

	@PageRow()
	public static class InventoryDetailsTable {

		@BooleanType
		@FindBy(xpath = ".//td[1]//input")
		public WebElement selectCheckBox;

		@ChoiceListType()
		@FindBy(xpath = ".//td[2]//select|.//td[2]//span")
		public WebElement toLocID;

		@ChoiceListType()
		@FindBy(xpath = ".//td[3]//span")
		public WebElement toLocNum;

		@TextType
		@FindBy(xpath = ".//td[3]//input")
		public WebElement toLocNumTextBox;

		@TextType
		@FindBy(xpath = ".//td[4]//input|.//td[4]//span")
		public WebElement quantity;

		@TextType
		@FindBy(xpath = ".//td[6]//input")
		public WebElement txnComment;

		@TextType
		@FindBy(xpath = ".//td[7]//input")
		public WebElement toLocComment;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@FindBy(xpath = "//table[contains(@id,'pbt_locmoveentries')]//tbody//tr")
	@PageTable(firstRowContainsHeaders = false, row = InventoryDetailsTable.class)
	public List<InventoryDetailsTable> inventoryDetailsTable;

	@ButtonType()
	@FindByLabel(label = "Move Selected Items")
	public WebElement moveSelectedItems;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Move Serial Items']/parent::span/parent::th/following-sibling::td//input")
	public WebElement moveSerialItems;

	@ButtonType()
	@FindByLabel(label = "Select Serials")
	public WebElement selectSerials;

	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='Serial Count:']/input[2]")
	public WebElement serialCount;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='From Site']/parent::span/parent::th/following-sibling::td//select")
	public WebElement FromSite;

	@TextType()
	@FindBy(xpath = "//span[contains(@id,'locmoveentries')]//textarea")
	public WebElement selectedSerialNumber;

	public String readSelectedSerialNumber() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String elementLocator = "//textarea[contains(@name,'pbs_locmoveentries')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath(elementLocator));
		testLogger.info("serial Numbers" + ele.getAttribute("value"));

		return ele.getText();

	}

	public String locationId, locationNum;

	public void setLocationDetails(String locId, String locNum) throws InterruptedException {
		locationId = locId;
		locationNum = locNum;

		testLogger.info("LocationID::::" + locationId);

		testLogger.info("LocationNum::::" + locationNum);

	}

	public void setcheckbox() {
		WebElement selectCheckBox11 = driver.findElement(By.xpath("//*[contains(text(),'" + locationId
				+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locationNum
				+ "')]/parent::td/parent::tr//td[1]//input"));

		selectCheckBox11.click();
	}

	public void selectToLocID(String toLocID) {
		WebElement toLocID11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[2]//select|//*[a[contains(text(),'" + locationId
						+ "')]/parent::span/parent::td | span[normalize-space()='" + locationNum
						+ "']/parent::td]/parent::tr//td[2]//span"));

		Select dropdown = new Select(toLocID11);
		dropdown.selectByValue(toLocID);
	}

	public void selectToLocNumbe(String toLocNumber) {

		WebElement toLocNum11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[3]//span"));
		Select dropdown = new Select(toLocNum11);
		dropdown.selectByValue(toLocNumber);

	}

	public void setToLocNumbTxt(String toLocNum) {
		WebElement toLocNumTextBox11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[3]//input"));
		toLocNumTextBox11.sendKeys(toLocNum);
	}

	public void setQty(String Qty) {
		WebElement quantity11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[4]//input|//*[a[contains(text(),'" + locationId
						+ "')]/parent::span/parent::td | span[normalize-space()='" + locationNum
						+ "']/parent::td]/parent::tr//td[4]//span"));
		;
		quantity11.sendKeys(Qty);
	}

	public void setTxnComments(String Comments) {
		WebElement txnComment11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[6]//input"));
		txnComment11.sendKeys(Comments);
	}

	public void setToLocCommnet(String toLocComments) {
		WebElement toLocComment11 = driver.findElement(By
				.xpath("//*[a[contains(text(),'" + locationId + "')]/parent::span/parent::td | span[normalize-space()='"
						+ locationNum + "']/parent::td]/parent::tr//td[7]//input"));
		toLocComment11.sendKeys(toLocComments);
	}

	@DateType
	@FindBy(xpath = "//label[normalize-space(.)='Transaction Date']/parent::span/parent::th/following-sibling::td//input")
	public WebElement transactionDate;

}
