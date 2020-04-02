package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FoundPage {

    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement advanceSearchBtn;

    @FindBy(xpath = "//span[contains(@class,'select select_size_s select_theme_normal')]")
    WebElement showCount;

   @FindBy(xpath = "//div[contains(@class,'n-snippet-list n-snippet')]")
    WebElement listItem;

    public FoundPage() {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    public void clickAdvanceSearchBtn()
    {
        advanceSearchBtn.click();
    }

    public void selectShowCount()
    {
        //showCount.findElement(By.xpath(".//button")).click();
        new Select(showCount.findElement(By.xpath(".//select"))).selectByVisibleText("Показывать по 12");
       // showCount.findElement(By.xpath(".//button")).click();
    }

    public void showItem()
    {
        //List<WebElement> list = BasePage.getDriver().findElements(By.xpath("//div[contains(@class,'n-snippet-list n-snippet')]"));
        List<WebElement> list = listItem.findElements(By.xpath(".//div[contains(@class,'n-snippet-card2 i-bem b-zone')]//h3//a"));
        System.out.println(list.size());
        System.out.println(list.get(0).getText());
        list.stream().forEach(System.out::println);
    }
}
