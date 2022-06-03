package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.provar.core.testapi.annotations.*;

@SalesforcePage(title = "Rstk__ Stocklocprojmove", summary = "", page = "Stocklocprojmove", namespacePrefix = "rstk", object = "rstk__locadd__c", connection = "QARSF_Admin")
public class rstk__Stocklocprojmove {
	public WebDriver driver;

	public rstk__Stocklocprojmove(WebDriver driver) {
		this.driver = driver;
	}

	public static String locID, locNum, Lot;

	@PageWaitAfter.Field(field = "list", timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//input[@id='locmove_icitem__c_autocomplete']")
	public WebElement SearchItem;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(id = "li-0")
	public WebElement list;

	@TextType()
	@FindByLabel(label = "Transaction Date")
	public WebElement transactionDate;

	@TextType()
	@FindBy(xpath = "//input[@id='locmove_fromproj__c_autocomplete']")
	public WebElement searchFromProject;

	@TextType()
	@FindBy(xpath = "//input[contains(@id,'locmove_toproj__c_autocomplete')]")
	public WebElement searchToProject;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Stock Loc ID']/ancestor::span/ancestor::th/following-sibling::td//select")
	public WebElement stockLocID;

	@ButtonType()
	@FindByLabel(label = "Display Proj Move Entries")
	public WebElement displayProjMoveEntries;

	public void setToProject(String locationID, String locationNumber, String LotNumber, String toProject)
			throws InterruptedException {

		Thread.sleep(2000);
		locID = locationID;
		locNum = locationNumber;
		Lot = LotNumber;

		testLogger.info("locid::::" + locID);
		testLogger.info("locnum::::" + locNum);
		testLogger.info("Lot::::" + Lot);
		testLogger.info("project::::" + toProject);
		String xpath = null;
		if (LotNumber != null) {
			xpath = "//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[7]//select";
			testLogger.info("Dropdownvalues::::" + xpath);
		} else {

			xpath = "//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[7]//select";
			testLogger.info("Dropdownvalues::::" + xpath);
		}

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath(xpath));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(toProject);
	}

	public void setToChargeCode(String chargeCode) throws InterruptedException {
		Thread.sleep(2000);

		WebElement ele;
		if (Lot != null) {
			ele = driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[8]//select"));
		} else {
			ele = driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[8]//select"));

		}

		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(chargeCode);

	}

	public void setQty(String qty) throws InterruptedException {

		Thread.sleep(2000);
		if (Lot != null) {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[9]/input")).sendKeys(qty);
		} else {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[9]/input")).sendKeys(qty);

		}
	}

	public void setDocument(String document) throws InterruptedException {
		Thread.sleep(2000);
		if (Lot != null) {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[10]/input")).sendKeys("" + document);

		} else {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[10]/input")).sendKeys("" + document);
		}
	}

	public void setTxnComment(String txnComment) throws InterruptedException {

		Thread.sleep(2000);
		if (Lot != null) {

			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[11]/input")).sendKeys("" + txnComment);
		} else {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[11]/input")).sendKeys("" + txnComment);
		}

	}

	public void settoLocComment(String toLocComment) throws InterruptedException {
		Thread.sleep(2000);
		if (Lot != null) {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr//td[12]/input")).sendKeys("" + toLocComment);
		} else {
			driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr//td[12]/input")).sendKeys("" + toLocComment);

		}
	}

	public void setFromChargeCode(String chargeCode) throws InterruptedException {
		Thread.sleep(2000);

		WebElement ele;
		if (Lot != null) {
			ele = driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
					+ "')]/parent::td/parent::tr/parent::tbody/parent::table/preceding-sibling::div/descendant::table[4]//td[2]//select"));

		} else {
			ele = driver.findElement(By.xpath("//*[contains(text(),'" + locID
					+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
					+ "')]/parent::td/parent::tr/parent::tbody/parent::table/preceding-sibling::div/descendant::table[4]//td[2]//select"));
		}

		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(chargeCode);

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Move Selected Items")
	public WebElement moveSelectedItems;

	@TestLogger
	public Logger testLogger;

	public String selectSerialNumber(Integer NumberOfSerialTobeSelected) throws InterruptedException {

		Thread.sleep(2000);
		String selectedSerial = "";
		WebElement element;
		for (int i = 1; i <= NumberOfSerialTobeSelected; i++) {

			if (Lot != null) {

				element = driver.findElement(By.xpath("//*[contains(text(),'" + locID
						+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
						+ "')]/parent::td/following-sibling::td/span[contains(text(),'" + Lot
						+ "')]/parent::td/parent::tr//td[9]//select/option[" + i + "]"));

				testLogger.info("Serial Number:" + element.getText());
				selectedSerial += "\n" + element.getText();
			} else {

				element = driver.findElement(By.xpath("//*[contains(text(),'" + locID
						+ "')]/parent::span/parent::td/following-sibling::td/span[contains(text(),'" + locNum
						+ "')]/parent::td/parent::tr//td[9]//select/option[" + i + "]"));

				testLogger.info("Serial Number:" + element.getText());
				selectedSerial += "\n" + element.getText();

			}
			element.click();

		}
		return selectedSerial;
	}
}
