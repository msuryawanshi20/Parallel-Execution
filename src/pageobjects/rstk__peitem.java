package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__peitem"                                
               , summary=""
               , page="Peitem"
               , namespacePrefix="rstk"
               , object="rstk__peitem__c"
               , connection="QARSFAdmin"
     )             

public class rstk__peitem {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Quantity On-Hand']/parent::span/parent::th/following-sibling::td[1]//span")
	public WebElement quantityOnHand;

	@TextType()
	@FindBy(id = "pg:fm:pb:tab_Inventory_lbl")
	public WebElement tab_Inventory_lbl;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Item Number']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement itemNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Item Description']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement itemDescription;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Inventory Division']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement inventoryDivision;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Commodity Code']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement commodityCode;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Eng UOM']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement engUOM;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Inventory Source']/parent::span/parent::th/following-sibling::td//select")
	public WebElement inventorySource;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Status']/parent::span/parent::th/following-sibling::td//select")
	public WebElement Status;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Inactive Status']/parent::span/parent::th/following-sibling::td//input")
	public WebElement inactiveStatus;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Eng Type']/parent::span/parent::th/following-sibling::td//select")
	public WebElement engType;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Item Type']/parent::span/parent::th/following-sibling::td//select")
	public WebElement itemType;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Responsible Engineer']/parent::span/parent::th/following-sibling::td//input")
	public WebElement overrideResponsibleEngineer;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Add Product Master(s)']/parent::th/following-sibling::td[1]//input")
	public WebElement addProductMasterFlag;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Add Inventory Item in Multiple Divisions']/parent::th/following-sibling::td//input")
	public WebElement addInventoryItemInMultipleDivisions;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Responsible Engineer']/parent::span/parent::th/following-sibling::td//select")
	public WebElement Responsible_EngineerPicklist;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Lot Tracking']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement lotTracking;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Serial Tracking']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement serialTracking;
	
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='FIFO Cost Method Indicator']/parent::th/following-sibling::td//input")
	public WebElement fifoCostMethodIndicator;
	

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Disassembly Item']/ancestor::th/following-sibling::td//input")
	public WebElement disassemblyItem;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Item Number']/parent::span/parent::th/following-sibling::td[1]")
	public WebElement itemNumber1;

	@TextType()
	@FindBy(xpath = "//td/table//table/tbody/tr/td/table/tbody/tr/td[normalize-space(.)='Approved Manufacturers']")
	public WebElement tab_ApprovedMfrs_lbl;

}