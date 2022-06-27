package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.SalesforcePage;

@SalesforcePage( title="Rstk__soconchg Related List"                                
               , summary=""
               , page="soconchgRelatedList"
               , namespacePrefix="rstk"
               , object="rstk__socontract__c"
               , connection="QARSF_Admin"
     )             
public class rstk__soconchgRelatedList {

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='New Contract Miscellaneous charge']")
	public WebElement newContractMiscellaneousCharge;
	
}
