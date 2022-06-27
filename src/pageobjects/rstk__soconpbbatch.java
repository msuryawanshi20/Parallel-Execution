package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.DateType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__soconpbbatch"                                
               , summary=""
               , page="soconpbbatch"
               , namespacePrefix="rstk"
               , object="rstk__soconpbbatch__c"
               , connection="QARSF_Admin"
     )             
public class rstk__soconpbbatch {

	@PageWait.Field(timeoutSeconds = 10)
	@PageWaitAfter.Field(timeoutSeconds = 10)
	@DateType
	@FindBy(xpath = "//label[normalize-space(.)='Invoice Date']/parent::th/following-sibling::td//input")
	public WebElement NewinvoiceDate;
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;
	@TextType()
	@FindBy(xpath = "//td/div")
	public WebElement SuccessMessage;
	
}
