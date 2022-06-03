package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="Rstk__ Sormh"                                
               , summary=""
               , page="Sormh"
               , namespacePrefix="rstk"
               , object="rstk__sormh__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Sormh {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='RMA Number']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement rMANumber;
	@TextType()
	@FindBy(xpath = "//input[@id='sormh_custno__c_autocomplete']")
	public WebElement Customer;
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@TextType()
	@FindBy(xpath = "//li[@id='li-0']")
	public WebElement list;
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Action']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement sormh_action__c;
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Customer Bill-To Address']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement customerBillToAddress;
	@LinkType()
	@FindBy(xpath = "//label[normalize-space(.)='Date Issued']/parent::span/parent::th/following-sibling::td//a")
	public WebElement dateIssued;
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Advance Replacement']/parent::span/parent::th/following-sibling::td//input")
	public WebElement advanceReplacement;
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;
	
}
