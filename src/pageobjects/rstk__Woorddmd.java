package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Woorddmd"                                
               , summary=""
               , page="Woorddmd"
               , namespacePrefix="rstk"
               , object="rstk__woorddmd__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Woorddmd {

	@PageWaitAfter.Field(field = "Component_ItemLookup", timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//input[@id='woorddmd_compitem__c_autocomplete']")
	public WebElement Component_Item;

	@TextType()
	@FindBy(id = "li-0")
	public WebElement Component_ItemLookup;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Qty Per']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement qtyPer;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Enter Qty Per']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement enterQtyPer;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Enter Component Qty']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement enterComponentQty;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Fixed Component Qty']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement fixedComponentQty;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Scrap Factor']/parent::span/parent::th/following-sibling::td//input")
	public WebElement scrapFactor;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Setup Qty']/parent::span/parent::th/following-sibling::td//input")
	public WebElement setupQty;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Comments']/parent::span/parent::th/following-sibling::td//input")
	public WebElement comments;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Component Qty']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement componentQty;

}
