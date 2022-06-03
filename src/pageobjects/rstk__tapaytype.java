package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__tapaytype"                                
               , summary=""
               , page="tapaytype"
               , namespacePrefix="rstk"
               , object="rstk__tapaytype__c"
               , connection="QARSF_Admin"
     )             
public class rstk__tapaytype {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Labor Pay Type']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement laborPayType;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/ancestor::span/ancestor::th/following-sibling::td//input")
	public WebElement description;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Hourly Add Amount']/ancestor::span/parent::th/following-sibling::td//input")
	public WebElement hourlyAddAmount;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Rate Factor']/ancestor::span/parent::th/following-sibling::td//input")
	public WebElement rateFactor;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Name']/parent::th/following-sibling::td[1]")
	public WebElement name;

	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@ButtonType()
	@FindByLabel(label = "Delete")
	public WebElement delete;

}
