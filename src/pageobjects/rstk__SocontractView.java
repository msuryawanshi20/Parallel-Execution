package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.SalesforcePage;

@SalesforcePage( title="Rstk__ Socontract View"                                
               , summary=""
               , page="SocontractView"
               , namespacePrefix="rstk"
               , object="rstk__socontract__c"
               , connection="QARSF_Admin"
     )             
public class rstk__SocontractView {
	private WebDriver driver;

	public rstk__SocontractView(WebDriver driver) {
		this.driver = driver;
	}

	@LinkType()
	@FindBy(xpath = "//*[contains(@value,'New Contract Products for Purchase')]")
	public WebElement newContractProductsforPurchase;

	public void clickOnEditProductForPurchase(String ProductName) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//a[contains(@title,'" + ProductName + "')][1]"));
		ele.click();
	}
	
	public void clickOnDeleteProductForPurchase(String ProductName) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//a[contains(@title,'" + ProductName + "')][2]"));
		ele.click();
	}

}
