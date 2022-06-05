package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Socontract 2"                                
               , summary=""
               , page="Socontract2"
               , namespacePrefix="rstk"
               , object="rstk__socontract__c"
               , connection="QARSF_Admin"
     )             

public class rstk__Socontract2 {

	public WebDriver driver;

	public rstk__Socontract2(WebDriver driver) {
		this.driver = driver;
	}

	public void selectContractCustomer(String CustomerName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String elementLocator = "//input[@id='socontract_socust__c_autocomplete']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));

		WebElement ele = driver.findElement(By.xpath(elementLocator));
		ele.sendKeys(CustomerName);

		Actions actions = new Actions(driver);
		String listLocator = "//div[@class='ac_results'][1]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));

		List<WebElement> autoCompleteList = driver.findElements(By.xpath(listLocator));
		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(CustomerName)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				Thread.sleep(1000);
				
				break;
			}
		}
	}

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Master Services Agreement']/ancestor::th/following-sibling::td[1]//select")
	public WebElement socontract_socustmsa__c;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Terms Template']/ancestor::th/following-sibling::td[1]//select")
	public WebElement socontract_soctt__c;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Type']/ancestor::th/following-sibling::td//select")
	public WebElement socontract_type__c;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Term']/ancestor::th/following-sibling::td[1]//input")
	public WebElement contractTerm;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Recurring Billing Start Date']/ancestor::th/following-sibling::td//input")
	public WebElement recurringBillingStartDate;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='First Full RB Period Start Date']/ancestor::th/following-sibling::td//input")
	public WebElement firstFullRBPeriodStartDate;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Term UOM / Billing Frequency']/ancestor::th/following-sibling::td//select")
	public WebElement contractTermUOMBillingFrequency;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@PageWaitAfter.Field(field = "description", timeoutSeconds = 10)
	@PageWait.Field(timeoutSeconds = 10)
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract ID']/ancestor::th/following-sibling::td[1]//input")
	public WebElement contractID;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Description']/ancestor::th/following-sibling::td[1]//input")
	public WebElement description;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Status']/ancestor::th/following-sibling::td[1]//select")
	public WebElement contractStatus;

}
