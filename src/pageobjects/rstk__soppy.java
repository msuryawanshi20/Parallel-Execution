package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__soppy"                                
               , summary=""
               , page="soppy"
               , namespacePrefix="rstk"
               , object="rstk__soppy__c"
               , connection="QARSF_Admin"
     )             
public class rstk__soppy {

	@TextType()
	@FindBy(xpath = "//input[@id='soppy_custno__c_autocomplete']")
	public WebElement Customer_Number;
	
	@TextType()
	@FindBy(xpath = "//input[contains(@id,'soppy_order')]")
	public WebElement SalesOrderNumber;
	
	@TextType()
	@FindBy(id = "li-0")
	public WebElement SalesOrderNumber_Select;
	
	@TextType()
	@FindBy(id = "li-0")
	public WebElement Customer_Select;
	
	@TextType()
	@FindBy(xpath = "//input[contains(@id,'soppy_amount')]")
	public WebElement Amount;
	
	@ChoiceListType()
	@FindBy(xpath = "//select[contains(@id,'soppy_type')]")
	public WebElement ApplicationAvailability;
	
	@ChoiceListType()
	@FindBy(xpath = "//select[contains(@id,'soppy_appmethod')]")
	public WebElement ApplicationMethod;
	
	@ChoiceListType()
	@FindBy(xpath = "//select[contains(@name,'soppy_addrseq')]")
	public WebElement CustomerBillToAddressSeq;
	
	@ChoiceListType()
	@FindBy(xpath = "//select[contains(@name,'soppy_ppyacct')]")
	public WebElement PrepaymentAccount;
	
	@ButtonType()
	@FindBy(xpath = "//input[@value='Save']")
	public WebElement Save;
	
	@ButtonType()
	@FindBy(xpath = "//input[@value='Release PPY (Create Invoice)']")
	public WebElement ReleasePPY;
	
	@ButtonType()
	@FindBy(xpath = "//input[@value='Recall Released Prepayment']")
	public WebElement RecallReleasedPrepayment;
	
	@BooleanType()
	@FindBy(xpath = "//span[contains(@id,'soppy_released__c')]//img")
	public WebElement Released;
	
	@BooleanType()
	@FindBy(xpath = "//span[contains(@id,'soppy_completed__c')]//img")
	public WebElement FullyApplied;
	
	@TextType()
	@FindBy(xpath = "//label[contains(text(),'Prepayment Number')]/following::td//span//span[1]")
	public WebElement PrepaymentNumber;
	
	@TextType()
	@FindBy(xpath = "//span[contains(@id,'soppy_invoice__c')]//a")
	public WebElement InvoiceNumber;
}
