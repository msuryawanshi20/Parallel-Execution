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
import com.provar.core.testapi.annotations.VisualforceBy;

@SalesforcePage( title="Rstk__somsa"                                
               , summary=""
               , page="somsa"
               , namespacePrefix="rstk"
               , object="rstk__somsa__c"
               , connection="QARSF_Admin"
     )             
public class rstk__somsa {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Master Services Agreement']/ancestor::th/following-sibling::td//input")
	public WebElement masterServicesAgreement;

	@TextType()
	@VisualforceBy(componentXPath = "apex:inputField[@id='somsa_desc__c']")
	public WebElement mSADescription;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='MSA Responsible User']/ancestor::th/following-sibling::td//select")
	public WebElement mSAResponsibleUser;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='MSA is Active']/ancestor::th/following-sibling::td//input")
	public WebElement mSAIsActive;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@ButtonType()
	@FindByLabel(label = "Delete")
	public WebElement delete;

	@TextType()
	@FindBy(xpath = "//span[contains(text(),'MSA Description')]/ancestor::th/following::td[1]/span")
	public WebElement mSADescription1;

	@TextType()
	@FindBy(xpath = "//span[contains(text(),'MSA Responsible User')]/ancestor::th/following::td[1]//a")
	public WebElement mSAResponsibleUser1;

}
