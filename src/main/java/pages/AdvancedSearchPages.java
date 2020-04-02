package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BasePage;

public class AdvancedSearchPages {

    public AdvancedSearchPages() {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    @FindBy(name = "glf-pricefrom-var")
    WebElement fieldPriceMin;

    @FindBy(xpath = "//span[text()='Производитель']//..//..//..")
    WebElement producer;

    @FindBy(xpath = "//span[text()='Показать подходящие']//..")
    WebElement showSelected;

    public AdvancedSearchPages fillField(WebElement by,String string)
    {
        by.clear();
        by.sendKeys(string);
        return this;
    }

    public AdvancedSearchPages fillFieldPrice(String val)
    {
        fillField(fieldPriceMin,val);
        return this;
    }

    public AdvancedSearchPages checboxProducer(String checkbox)
    {
        producer.findElement(By.xpath(".//label[text()='"+checkbox+"']")).click();
        return this;
    }

    public AdvancedSearchPages clickContinue()
    {
        showSelected.click();
        return this;
    }
}
