package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.FindByLabel;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.SalesforcePage;

@SalesforcePage( title="Rstk__ Rmaserialdetails"                                
               , summary=""
               , page="Rmaserialdetails"
               , namespacePrefix="rstk"
               , object="rstk__sorma__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Rmaserialdetails {

	public WebDriver driver;

	public rstk__Rmaserialdetails(WebDriver driver) {
		this.driver = driver;
	}

	@PageRow()
	public static class AuthorizeSerials {

		@BooleanType()
		@FindBy(xpath = ".//td[1]//input")
		public WebElement selected;
	}

	@FindBy(xpath = "//span[contains(@id,'op_rmashipsrls')]//table//tbody//tr")
	@PageTable(firstRowContainsHeaders = false, row = AuthorizeSerials.class)
	public List<AuthorizeSerials> authorizeSerials;

	@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
	@ButtonType()
	@FindByLabel(label = "Authorize Selected Serials")
	public WebElement authorizeSelectedSerials;

	public void selectSerialNumber(Integer NumberOfSerialTobeSelected) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		String elementLocator = "//select[contains(@id,'compsrls')]";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementLocator)));
		Select listbox = new Select(driver.findElement(By.xpath(elementLocator)));
		listbox.deselectAll();

		for (int i = 1; i <= NumberOfSerialTobeSelected; i++) {

			WebElement element = driver.findElement(By.xpath("//select[contains(@id,'compsrls')]/option[" + i + "]"));
			element.click();

		}

	}

}
