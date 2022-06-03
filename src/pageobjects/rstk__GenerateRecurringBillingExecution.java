package pageobjects;

import java.util.List;
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

@SalesforcePage(title = "Rstk__ Generate Recurring Billing Execution", summary = "", page = "GenerateRecurringBillingExecution", namespacePrefix = "rstk", object = "rstk__customext__c", connection = "QARSF_Admin")
public class rstk__GenerateRecurringBillingExecution {

	public WebDriver driver;

	Logger loggerTest;

	public rstk__GenerateRecurringBillingExecution(WebDriver driver) {
		this.driver = driver;
	}

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Billing Run Date']/ancestor::th/following-sibling::td[1]//input")
	public WebElement billingRunDate;

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Specify Customer Range']/ancestor::th/following-sibling::td[1]//input")
	public WebElement specifyCustomerRange;

	public void selectCustomer(String CustomerName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String listLocator = "//label[normalize-space(.)='Customer']/ancestor::th/following-sibling::td[1]//select//option";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));
		List<WebElement> customerList = driver.findElements(By.xpath(listLocator));
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getText().contains(CustomerName)) {
				customerList.get(i).click();
				break;
			}
		}
	}

	public void selectContract(String ContractName) throws InterruptedException {
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String listLocator = "//label[normalize-space(.)='Contract']/ancestor::th/following-sibling::td//option";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(listLocator)));
		List<WebElement> contractList = driver.findElements(By.xpath(listLocator));

		for (int i = 0; i < contractList.size(); i++) {
			if (contractList.get(i).getText().contains(ContractName)) {
				contractList.get(i).click();
				break;
			}
		}
	}

	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='Run for All Divisions']/ancestor::th/following-sibling::td//input")
	public WebElement runForAllDivisions;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Periodic Billing Frequency']/ancestor::th/following-sibling::td//select")
	public WebElement periodicBillingFrequency;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Contract Type']/ancestor::th/following-sibling::td//select")
	public WebElement contractType;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='From Customer']/ancestor::th/following-sibling::td[1]//select")
	public WebElement From_Customer;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='To Customer']/ancestor::th/following-sibling::td//select")
	public WebElement To_Customer;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Generate Recurring Billings")
	public WebElement generateRecurringBillings;

	public String viewBillingRunBatchHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 7200);
		String recID = null;
		try {

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[normalize-space(.)='View Billing Run Batch Header']/parent::a")));
			recID = driver.findElement(By.xpath("//*[normalize-space(.)='View Billing Run Batch Header']/parent::a"))
					.getAttribute("href");

			recID = recID.split("=")[1];
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[normalize-space(.)='View Billing Run Batch Header']/parent::a")).click();
			Thread.sleep(3000);

		} catch (Exception e) {

			loggerTest.info("Exception" + e);
		}

		return recID;

	}

}
