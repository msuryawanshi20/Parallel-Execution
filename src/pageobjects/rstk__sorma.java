package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="Rstk__sorma"                                
               , summary=""
               , page="sorma"
               , namespacePrefix="rstk"
               , object="rstk__sorma__c"
               , connection="QARSF_Admin"
     )             
public class rstk__sorma {

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Credit Authorized']/ancestor::th/following-sibling::td//input")
	public WebElement creditAuthorized;
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;
	
}
