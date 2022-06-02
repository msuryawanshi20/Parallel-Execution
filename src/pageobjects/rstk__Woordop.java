package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Woordop"                                
               , summary=""
               , page="Woordop"
               , namespacePrefix="rstk"
               , object="rstk__woordop__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Woordop {

	@PageWaitAfter.Field(field = "description", timeoutSeconds = 10)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Operation Number']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement operationNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement description;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Process']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement process;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Work Center']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement workCenter;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Assigned To']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement assignedTo;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Concurrent Seq']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement concurrentSeq;

	@ButtonType
	@FindBy(xpath = "//*[contains(@id,'tab_Labor_Stds_lbl')]")
	public WebElement labor_Stds_tab;

	@PageWait.Field(timeoutSeconds = 10)
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Setup Type']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement setupType;

	@PageWaitAfter.Field(field = "setupStandardHours", timeoutSeconds = 10)
	@PageWait.Field(timeoutSeconds = 10)
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Setup Labor Grade']/parent::span/parent::th/following-sibling::td[1]//select")
	public WebElement setupLaborGrade;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Setup Standard Hours']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement setupStandardHours;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Run Type']/parent::span/parent::th/following-sibling::td//select")
	public WebElement runType;

	@PageWait.Field(timeoutSeconds = 10)
	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Run Labor Grade']/parent::span/parent::th/following-sibling::td//select")
	public WebElement runLaborGrade;

	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Run Standard Hours']/parent::span/parent::th/following-sibling::td//input")
	public WebElement runStandardHours;

	@ButtonType
	@FindBy(xpath = "//*[contains(@id,'tab_Machine_Stds_lbl')]")
	public WebElement machine_Stds_tab;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Machine Type']/parent::span/parent::th/following-sibling::td//select")
	public WebElement machineType;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Machine Number']/parent::span/parent::th/following-sibling::td//select")
	public WebElement machineNumber;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Standard Machine Hours']/parent::span/parent::th/following-sibling::td//input")
	public WebElement standardMachineHours;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@ButtonType
	@FindBy(xpath = "//*[contains(@id,'tab_Options_lbl')]|//*[contains(@id,'tab_Qty_Reporting_Options_lbl')]")
	public WebElement options_Tab;

	@BooleanType
	@FindBy(xpath = "//*[contains(@name,'allowaccind')]")
	public WebElement allowAcceptFlag;

	@ButtonType()
	@FindBy(xpath = "//*[contains(@id,'tab_Move_Lead_Times_lbl')]|//*[contains(@id,'tab_Subcontract_lbl')]")
	public WebElement subConMoveLeadTimeTab;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Subcontract Lead Time']/parent::span/parent::th/following-sibling::td//input")
	public WebElement subcontractLeadTime;

}
