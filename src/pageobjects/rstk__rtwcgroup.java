package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;
import java.util.List;

@SalesforcePage( title="Rstk__rtwcgroup"                                
               , summary=""
               , page="rtwcgroup"
               , namespacePrefix="rstk"
               , object="rstk__rtwcgroup__c"
               , connection="QARSF_Admin"
     )             
public class rstk__rtwcgroup {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Group ID']/parent::span/parent::th/following-sibling::td//input")
	public WebElement groupID;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/parent::span/parent::th/following-sibling::td//input")
	public WebElement description;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Comments']/parent::span/parent::th/following-sibling::td//textarea")
	public WebElement comments;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//*[contains(text(),'Group ID')]/parent::th//following-sibling::td//span")
	public WebElement groupID1;

	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;

	@ButtonType()
	@FindByLabel(label = "Delete")
	public WebElement delete;

	@ButtonType()
	@FindByLabel(label = "Group Detail Maintenance")
	public WebElement groupDetailMaintenance;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Add")
	public WebElement add;

	@PageRow()
	public static class WorkCenterGroupDetails {

		@ChoiceListType()
		@FindBy(xpath = ".//select")
		public WebElement workCenter;
	}

	@FindBy(xpath = "//div[normalize-space()='Work Center']//parent::th/parent::tr/parent::thead/following-sibling::tbody//tr")
	@PageTable(firstRowContainsHeaders = false, row = WorkCenterGroupDetails.class)
	public List<WorkCenterGroupDetails> workCenterGroupDetails;

}
