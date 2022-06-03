package pageobjects;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.provar.core.testapi.annotations.TestLogger;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Stocklocdivsitemove"                                
               , summary=""
               , page="Stocklocdivsitemove"
               , namespacePrefix="rstk"
               , object="rstk__locadd__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Stocklocdivsitemove {
	public WebDriver driver;

	public rstk__Stocklocdivsitemove(WebDriver driver) {
		this.driver = driver;
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='From Site']/parent::span/parent::th/following-sibling::td//select")
	public WebElement FromSite;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Move Serial Items']/parent::span/parent::th/following-sibling::td//input")
	public WebElement moveSerialItems;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Search Item']/parent::span/parent::th/following-sibling::td//input")
	public WebElement SearchItem;

	@TextType()
	@FindBy(id = "li-0")
	public WebElement itemList;

	public void selectLocationIDfromPicklist(String locationID, String locationNo, String lotNumber, String project)
			throws InterruptedException {

		Thread.sleep(2000);
		if (lotNumber != null) {
			WebElement option = driver
					.findElement(By.xpath("//select[contains(@id,'fromlocation__c')]/option[contains(text(),'"
							+ locationID + " /') and contains(text(),'" + locationNo + "') and contains(text(),'(Lot: "
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
	
		
	@TestLogger
	public Logger testLogger;

	public String selectSerialNumber(Integer NumberOfSerialTobeSelected) throws InterruptedException {

		Thread.sleep(2000);
		String selectedSerial="";

		for (int i = 1; i <= NumberOfSerialTobeSelected; i++) {

			WebElement element = driver
					.findElement(By.xpath("//select[contains(@id,'available_serials__c')]/option[" + i + "]"));
			testLogger.info("Serial Number:" + element.getText());
			selectedSerial+="\n"+element.getText();
			
			element.click();

		}
		return selectedSerial;
	}

	@PageRow()
	public static class InventoryDetailsTable {

		@BooleanType
		@FindBy(xpath = ".//td[1]//input")
		public WebElement selectCheckBox;

		@ChoiceListType()
		@FindBy(xpath = ".//td[2]//select|.//td[2]//span")
		public WebElement toLocID;

		@ChoiceListType()
		@FindBy(xpath = ".//input[contains(@id,'locmove_tolocnum__c')]")
		public WebElement toLocNumTextBox;
		
		@TextType
		@FindBy(xpath = ".//td[3]//span//select")
		public WebElement toLocNumPickList;
		
		@ChoiceListType()
		@FindBy(xpath = ".//td[3]//input|.//td[3]//span//span")
		public WebElement toLocNumText;
			
		@TextType
		@FindBy(xpath = ".//td[6]//input|.//td[6]//span")
		public WebElement quantity;

		@TextType
		@FindBy(xpath = ".//td[7]//input")
		public WebElement document;

		@TextType
		@FindBy(xpath = ".//td[8]//input")
		public WebElement txnComment;
		
		@TextType
		@FindBy(xpath = ".//td[9]//input")
		public WebElement toLocComment;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@FindBy(xpath = "//table[contains(@id,'pbt_locmoveentries')]//tbody//tr")
	@PageTable(firstRowContainsHeaders = false, row = InventoryDetailsTable.class)
	public List<InventoryDetailsTable> inventoryDetailsTable;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='To Division']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement ToDivision;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='To Site']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement ToSite;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='To Project']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement ToProject;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Move Option']/ancestor::th/following-sibling::td[1]//select")
	public WebElement locmove_moveoption__c;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Display Div Move Entries")
	public WebElement displayDivMoveEntries;
	
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Display Site Move Entries")
	public WebElement displaySiteMoveEntries;
	
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Move Selected Items")
	public WebElement moveSelectedItems;
	
	@ButtonType()
	@FindByLabel(label = "Select Serials")
	public WebElement selectSerials;
	
	@TextType()
	@FindBy(xpath = "//*[normalize-space(.)='Serial Count:']//following::input[1]")
	public WebElement serialCount;
	
	@ChoiceListType()
	@FindBy(xpath = "//*[normalize-space(.)='To Loc ID']//following::td[1]//select")
	public WebElement serial_ToLocID;
	
	@FindBy(xpath = "//input[contains(@id,'locmove_tolocnum')]|//*[normalize-space(.)='To Loc No']//following::td[1]//select")
	public WebElement serial_ToLocNoText;
	
	@ChoiceListType()
	@FindBy(xpath = "//*[normalize-space(.)='To Loc No']//following::td[1]//select")
	public WebElement serial_ToLocNoPickList;
	
	
	@TextType
	@FindBy(xpath="//textarea[contains(@id,'locmove_selectedserials__c')]")
	public WebElement selectedSerialsTextarea;

	public String readSelectedSerialNumber() throws InterruptedException {

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//textarea[contains(@id,'locmove_selectedserials__c')]"));
		testLogger.info("serial Numbers"+ele.getAttribute("value"));
		
		return ele.getText();

	}
}


