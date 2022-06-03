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
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__laborqtybookingreversal", summary = "", page = "LaborQtyBookingReversal", namespacePrefix = "rstk", object = "rstk__icclocktxn__c", connection = "QARSF_Admin")
public class rstk__laborqtybookingreversal {

	public WebDriver driver;

	public rstk__laborqtybookingreversal(WebDriver driver) {
		this.driver = driver;
	}

	public void selectworWorkOrder(String WorkOrder) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = driver.findElement(By.xpath("//input[@id='icclockdtl_wocst__c_autocomplete']"));
		ele.sendKeys(WorkOrder);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='listbox']/li")));
		List<WebElement> autoCompleteList = driver.findElements(By.xpath("//ul[@class='listbox']/li"));
		for (int i = 0; i < autoCompleteList.size(); i++) {
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(WorkOrder)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Reverse Selected Entries']")
	public WebElement reverseSelectedEntries;

	@PageRow()
	public static class TimeAndQtyBookingRevDetailsTable {

		@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
		@PageWait.BackgroundActivity(timeoutSeconds = 60)
		@BooleanType()
		@FindBy(xpath = ".//td[1]/input")
		public WebElement selected;

		@TextType()
		@FindBy(xpath = ".//td[8]//span")
		public WebElement operation;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@FindBy(xpath = "//*[@value='Reverse Selected Entries']//parent::span//following::table[1]/tbody//tr")
	@PageTable(firstRowContainsHeaders = true, row = TimeAndQtyBookingRevDetailsTable.class)
	public List<TimeAndQtyBookingRevDetailsTable> timeAndQtyBookingRevDetailsTable;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Employee']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement employee;

}
