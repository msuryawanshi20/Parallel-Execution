package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.DateType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage(title = "Rstk__soconchg", summary = "", page = "soconchg", namespacePrefix = "rstk", object = "rstk__soconchg__c", connection = "QARSF_Admin")
public class rstk__soconchg {

	private WebDriver driver;

	public rstk__soconchg(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMiscellaneousChargeProduct(String MiscellaneousChargeProduct) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = driver.findElement(By.xpath("//input[@id='soconchg_soprod__c_autocomplete']"));
		ele.sendKeys(MiscellaneousChargeProduct);
		Thread.sleep(1000);

		Actions actions = new Actions(driver);
		String elementLocator = "//div[@class='ac_results'][1]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(elementLocator));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			System.out.println("inside Loop+++" + autoCompleteList.get(i).getText());
			if (autoCompleteList.get(i).getText().startsWith(MiscellaneousChargeProduct)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract General Misc Charge']/ancestor::th/following-sibling::td[1]//input")
	public WebElement contractGeneralMiscCharge;

	public void selectCoveredSerializedDevice(String CoveredSerializedDevice) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = driver.findElement(By.xpath("//input[@id='soconchg_socondev__c_autocomplete']"));
		ele.sendKeys(CoveredSerializedDevice);
		Thread.sleep(500);

		Actions actions = new Actions(driver);
		String elementLocatorList = "//div[@class='ac_results'][2]/ul[@id='IDREF']/li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocatorList)));
		List<WebElement> autoCompleteList = driver.findElements(By.xpath(elementLocatorList));

		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(CoveredSerializedDevice)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Charge Amount']/ancestor::th/following-sibling::td[1]//input")
	public WebElement chargeAmount;

	@DateType
	@FindBy(xpath = "//*[normalize-space(.)='Billable After This Date']/ancestor::th/following-sibling::td[1]//input")
	public WebElement billableAfterThisDate;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Charge Released for Billing']/ancestor::th/following-sibling::td//input")
	public WebElement chargeReleasedForBilling;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Revenue Account']/ancestor::th/following-sibling::td//select")
	public WebElement soconchg_salesacct__c;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Taxable']/ancestor::th/following-sibling::td//input")
	public WebElement taxable;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Tax Rate']/ancestor::th/following-sibling::td//input")
	public WebElement taxRate;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Master']/ancestor::th/following-sibling::td[1]//select")
	public WebElement Contract_Master;

}
