package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__sorma View"                                
               , summary=""
               , page="sormaView"
               , namespacePrefix="rstk"
               , object="rstk__sorma__c"
               , connection="QARSF_Admin"
     )             
public class rstk__sormaView {

	@ButtonType()
	@FindByLabel(label = "Serial Details")
	public WebElement serialDetails;

	@ButtonType()
	@FindByLabel(label = "Process Receipt")
	public WebElement processReceipt;

	@ButtonType()
	@FindByLabel(label = "Create Replacement Sales Order")
	public WebElement createReplacementSalesOrder;

	@TextType()
	@FindBy(xpath = "//div[@class='messageText']")
	public WebElement successMessage;

	@ButtonType()
	@FindByLabel(label = "Edit")
	public WebElement edit;
	
	
	@ButtonType()
	@FindByLabel(label = "Receipt Disposition and Reversal")
	public WebElement receiptDispositionandReversal;
	

}
