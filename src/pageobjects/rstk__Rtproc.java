package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Rtproc"                                
               , summary=""
               , page="Rtproc"
               , namespacePrefix="rstk"
               , object="rstk__rtproc__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Rtproc {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Process Number']/parent::span/parent::th/following-sibling::td//input")
	public WebElement processNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/parent::span/parent::th/following-sibling::td//input")
	public WebElement description;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Name']/parent::th/following-sibling::td[1]//span")
	public WebElement name;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Delete")
	public WebElement delete;
	
}
