package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage(title = "Rstk__ Stocklocadd", summary = "", page = "Stocklocadd", namespacePrefix = "rstk", object = "rstk__locadd__c", connection = "QARSF_Admin")
public class rstk__Stocklocadd {
	public WebDriver driver;

	public rstk__Stocklocadd(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	@TextType()
	@FindBy(xpath = "//input[@id='locmove_icitem__c_autocomplete']")
	public WebElement search_item;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(id = "li-0")
	public WebElement itemList;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Display Loc Add Entries")
	public WebElement displayLocAddEntries;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Add Items to Inventory']")
	public WebElement addItemsToInventory;

	@PageRow()
	public static class InvLocTable {

		@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
		@PageWait.BackgroundActivity(timeoutSeconds = 60)
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//*[contains(@id,'tab_Details_lbl')]")
		public WebElement LocAddDetailsTab;

		@FindBy(xpath = ".//table[contains(@id,'theTabPanel')]//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr")
		public WebElement LocAddDetailsRow;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[2]")
		public WebElement ItemName;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[3]//input")
		public WebElement ProjectName;

		@TextType()
		@FindBy(id = "li-0")
		public WebElement itemList;

		@ChoiceListType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[4]//select")
		public WebElement StockLocId;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[5]//input")
		public WebElement StockLocNumber;

		@ChoiceListType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[5]//select")
		public WebElement StockLocNumberPicklist;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[6]//input")
		public WebElement QuantityToAdd;


		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[6]//textarea")
		public WebElement QuantityToAdd_Serials;
		
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']//input[contains(@id,'srlcount')]")
		public WebElement SerialCount;

		@DateType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[7]//input")
		public WebElement TransactionDate;

		@ChoiceListType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[8]//select")
		public WebElement AdjustmentAccount;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[9]/input")
		public WebElement Documents;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[10]/input")
		public WebElement Comments;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[11]/input")
		public WebElement LotNo;

		@FindBy(xpath = "//td[contains(@id,'tab_Details')]//table[@class='list']/tbody/tr//td[12]//input")
		public WebElement LotExpirationDate;

		@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
		@PageWait.BackgroundActivity(timeoutSeconds = 60)
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//*[contains(@id,'tab_Costs_lbl')]")
		public WebElement CostsTab;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[1]/input")
		public WebElement UnitCostMaterial;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[2]/input")
		public WebElement UnitCostLabor;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[3]/input")
		public WebElement UnitCostMtlOhd;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[4]/input")
		public WebElement UnitCostLaborOhd;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[5]/input")
		public WebElement UnitCostFringeOhd;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[6]/input")
		public WebElement UnitCostMachOhd;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[7]/input")
		public WebElement UnitCostSubMtl;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[8]/input")
		public WebElement UnitCostSubLab;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[9]/input")
		public WebElement UnitCostFreight;

		@TextType
		@FindBy(xpath = ".//td[contains(@id,'tab_Costs')]//table[@class='list']/tbody/tr/td[10]/input")
		public WebElement UnitCostLanding;

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@FindBy(xpath = "//table[contains(@id,'theTabPanel')]")
	@PageTable(firstRowContainsHeaders = false, row = InvLocTable.class)
	public List<InvLocTable> InventoryLocationtableList;

	public String getCharFromString(String str) {
		return str.substring(0, 15);
	}

	@TextType()
	@FindBy(xpath = "//*[@class='messageText']//text()")
	public WebElement futureDateValidation;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Site']/parent::span/parent::th/following-sibling::td//select")
	public WebElement Site;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Division']/parent::span/parent::th/following-sibling::td")
	public WebElement division;

	@PageRow()
	public static class Table {
	}

	@FindBy(id = "pg:fm:j_id168:j_id170:j_id171:0:j_id172:tb")
	@PageTable(firstRowContainsHeaders = false, row = Table.class)
	public List<Table> table;

}
