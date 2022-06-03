package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__inspord", summary = "", page = "inspord", namespacePrefix = "rstk", object = "rstk__inspord__c", connection = "QARSF_Admin")
public class rstk__inspord {

	@ButtonType()
	@FindByLabel(label = "Set Serial Disposition")
	public WebElement setSerialDisposition;

	@ButtonType()
	@FindBy(xpath = "//input[@value='Edit']")
	public WebElement edit;

	@ButtonType
	@FindBy(xpath = "//td/table//table/tbody/tr/td/table/tbody/tr/td[normalize-space(.)='Inspection Order Serials']")
	public WebElement tab_ioserial_lbl;

	@ButtonType()
	@FindByLabel(label = "All OK")
	public WebElement allOK;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindBy(xpath = "//span[2]//input[@id='editableInsOrderSerials_savebtn']")
	public WebElement save;

	@ButtonType()
	@FindBy(xpath = "//div[@id='insOrderSerialPopup']//input[@name='popupCancelButton']")
	public WebElement close;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Order Status']/ancestor::th/following-sibling::td//select")
	public WebElement orderStatus;

	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save1;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Quantity OK']/ancestor::th/following-sibling::td[1]//input")
	public WebElement quantityOK;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Quantity to be Scrapped']/ancestor::th/following-sibling::td[1]//input")
	public WebElement quantityToBeScrapped;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Quantity in Other Disposition']/ancestor::th/following-sibling::td[1]//input")
	public WebElement quantityInOtherDisposition;

}
