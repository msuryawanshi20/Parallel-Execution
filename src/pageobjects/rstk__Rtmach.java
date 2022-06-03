package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Rtmach"                                
               , summary=""
               , page="Rtmach"
               , namespacePrefix="rstk"
               , object="rstk__rtmach__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Rtmach {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Machine Number']/ancestor::span/parent::th/following-sibling::td[1]//input")
	public WebElement machineNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/ancestor::span/parent::th/following-sibling::td[1]//input")
	public WebElement description;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Work Center']/ancestor::span/parent::th/following-sibling::td[1]//select")
	public WebElement workCenter;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Responsible Planner']/ancestor::span/parent::th/following-sibling::td[1]//select")
	public WebElement responsiblePlanner;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Hourly Rate Option']/ancestor::span/parent::th/following-sibling::td//select")
	public WebElement hourlyRateOption;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Hourly Rate, Sim']/ancestor::span/parent::th/following-sibling::td//input")
	public WebElement hourlyRateSim;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Hourly Rate, Std']/ancestor::span/parent::th/following-sibling::td//input")
	public WebElement hourlyRateStd;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Sales Price per Hour']/ancestor::span/parent::th/following-sibling::td//input")
	public WebElement salesPricePerHour;

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
