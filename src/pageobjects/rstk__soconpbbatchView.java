package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;
@SalesforcePage( title="Rstk__soconpbbatch View"                                
               , summary=""
               , page="soconpbbatchView"
               , namespacePrefix="rstk"
               , object="rstk__soconpbbatch__c"
               , connection="QARSF_Admin"
     )  
                
public class rstk__soconpbbatchView {
	public WebDriver driver;

	Logger loggerTest;

	public rstk__soconpbbatchView(WebDriver driver) {
		this.driver = driver;
	}

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Select All']/preceding-sibling::input")
	public WebElement selectAll;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Billing Status']/following-sibling::select")
	public WebElement billingStatus;

	@ButtonType()
	@FindByLabel(label = "Mass Update Billing Status")
	public WebElement massUpdateBillingStatus;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Create Sales Invoices")
	public WebElement createSalesInvoices;

	public void waitTillSalesInvoiceBatchVisible() {
		WebDriverWait wait = new WebDriverWait(driver, 7200);
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//*[contains(text(),'Sales Invoice Batch')]//parent::span/parent::td/following::td[1]//a")));
		} catch (Exception e) {

			loggerTest.info("Exception" + e);

		}
	}

	public void waitTillDeleteSalesInvoice() {
		WebDriverWait wait = new WebDriverWait(driver, 7200);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"//*[contains(text(),'Sales Invoice Batch')]//parent::span/parent::td/following::td[1]//a")));

		} catch (Exception e) {

			loggerTest.info("Exception" + e);

		}

	}

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 600)
	@ButtonType()
	@FindByLabel(label = "Delete Sales Invoices")
	public WebElement deleteSalesInvoices;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 600)
	@ButtonType()
	@FindBy(xpath = "//input[@value='Remove Selected Billings From Batch']")
	public WebElement removeSelectedBillingsFromBatch;
	
	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 600)
	@ButtonType()
	@FindByLabel(label = "Change Invoice Date")
	public WebElement changeInvoiceDate;

	@ButtonType()
	@FindBy(xpath = "//div[@id='changeInvoiceDatePopup']//input[@name='popupCancelButton']")
	public WebElement close;
	
	
	@FindBy(xpath = "//*[contains(text(),'Invoice Date')]//parent::span//following::td[1]")
	public WebElement invoiceDate;
	
}
