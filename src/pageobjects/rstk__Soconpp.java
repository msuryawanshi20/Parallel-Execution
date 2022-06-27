package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Soconpp"                                
               , summary=""
               , page="Soconpp"
               , namespacePrefix="rstk"
               , object="rstk__soconpp__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Soconpp {
	public WebDriver driver;

	public rstk__Soconpp(WebDriver driver) {
		this.driver = driver;
	}

	public void selectProduct(String Product) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//input[contains(@id,'soconpp_soprod__c_autocomplete')]"));
		ele.sendKeys(Product);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		Thread.sleep(500);
		List<WebElement> autoCompleteList = driver
				.findElements(By.xpath("//div[@class='ac_results'][1]/ul[@id='IDREF']/li"));
		for (int i = 0; i < autoCompleteList.size(); i++) {
			Thread.sleep(1000);
			actions.moveToElement(autoCompleteList.get(i)).build().perform();
			if (autoCompleteList.get(i).getText().startsWith(Product)) {
				actions.moveToElement(autoCompleteList.get(i)).click().build().perform();
				break;
			}
		}
	}

	


	

	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

	@TextType()
	@FindBy(xpath = "//input[@id='soconpp_soprod__c_autocomplete']")
	public WebElement product;

	@TextType()
	@FindBy(xpath = "//li[@id='li-0']")
	public WebElement productList;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Commitment Quantity']/parent::span/parent::th/following-sibling::td[1]//input")
	public WebElement commitmentQuantity;
	
	
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Unit Price']/ancestor::th/following-sibling::td[1]//input")
	public WebElement unitPrice;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Discount Pct.']/ancestor::th/following-sibling::td[1]//input")
	public WebElement discountPct;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Revenue Account']/ancestor::th/following-sibling::td//select")
	public WebElement revenueAccount;

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Activation Grace Period (Days)']/ancestor::th/following-sibling::td//input")
	public WebElement activationGracePeriodDays;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Associated Recurring Charge Product']/ancestor::th/following-sibling::td//select")
	public WebElement associatedRecurringChargeProduct;

	@ChoiceListType()
	@FindBy(xpath = "//label[normalize-space(.)='Warranty Type']/ancestor::th/following-sibling::td//select")
	public WebElement warrantyType;
	
	

}
