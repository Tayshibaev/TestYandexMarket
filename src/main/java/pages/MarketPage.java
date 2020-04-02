package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BasePage;

public class MarketPage {

    public MarketPage() {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='_381y5orjSo _21NjfY1k45']")
    WebElement panelItem;

    public void selectPanelItem(String item)
    {
        panelItem.findElement(By.xpath(".//div//span[text()='"+item+"']")).click();
    }
}
