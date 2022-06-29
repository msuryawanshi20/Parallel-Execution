package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__quickcreatesorma"                                
               , summary=""
               , page="Quickcreatesorma"
               , namespacePrefix="rstk"
               , object="rstk__sormh__c"
               , connection="QARSF_Admin"
     )             
public class rstk__quickcreatesorma {
	public WebDriver driver;

	public rstk__quickcreatesorma(WebDriver driver) {
		this.driver = driver;
	}

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Use Product Defaults for Inventory Locs']/ancestor::th/following-sibling::td[1]//input")
	public WebElement useProductDefaultsForInventoryLocs;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Individual Lines for Kit Components']/ancestor::th/following-sibling::td[1]//input")
	public WebElement individualLinesForKitComponents;

	@ChoiceListType()
	@FindBy(xpath = "//span[contains(@id,'soinvlineid')]//select")
	public WebElement SOInvoiceLine;

	public void selectInvoiceNumber(String InvoiceNumber) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//input[@name='soinvid__c_autocomplete']"));
		ele.sendKeys(InvoiceNumber);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		Thread.sleep(500);
		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li"));
				
		while (autoCompleteList.size() > 100) {
			ele.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(3000);
			autoCompleteList = driver.findElements(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li"));

		}
				
		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(InvoiceNumber)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	public void selectShipperNumber(String ShipperNumber) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//input[@name='soshipid__c_autocomplete']"));
		ele.sendKeys(ShipperNumber);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		Thread.sleep(500);
		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][2]/ul[@id='IDREF']/li"));
		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(ShipperNumber)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@ButtonType()
	@FindByLabel(label = "Create RMA Details")
	public WebElement createRMADetails;

	@PageRow()
	public static class InventoryDetailsTable {

		@BooleanType
		@FindBy(xpath = ".//td[1]//input")
		public WebElement selectRow;

		@TextType
		@FindBy(xpath = ".//td[2]//input")
		public WebElement returnQty;

		@TextType
		@FindBy(xpath = ".//td[6]//text()")
		public WebElement product;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@FindBy(xpath = "//table[contains(@id,'pb_details')]/tbody//tr")
	@PageTable(firstRowContainsHeaders = false, row = InventoryDetailsTable.class)
	public List<InventoryDetailsTable> rmaDetailsTable;

}
