package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BasePage;

import java.util.Set;

public class MainPage {

    //панель с ссылками над поисковой строкой
    @FindBy(xpath = "//div[contains(@class,'home-tabs stream-control dropdown2')]")
    WebElement linkPanel;

    public MainPage()
    {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    public void clickLink(String item)
    {
        //Первоначально открытые вкладки
        Set<String> oldSetWindow = BasePage.getDriver().getWindowHandles();
        new WebDriverWait(BasePage.getDriver(),1,10).until(
                ExpectedConditions.elementToBeClickable(
    linkPanel.findElement(By.xpath(".//a[text()='"+item+"']")))).click();
        //После нажатия на ссылку открывается новая страница. Нужно перейти на нее и закрыть старую
        String newWindow = (new WebDriverWait(BasePage.getDriver(),2,10).until(
                new ExpectedCondition<String>() {
                    @NullableDecl
                    @Override
                    public String apply(@NullableDecl WebDriver driver) {
                        Set<String> newSetWindow = driver.getWindowHandles();
                        newSetWindow.removeAll(oldSetWindow);

                        return newSetWindow.size()>0?newSetWindow.iterator().next():null;
                    }
                })
        );
        //закрытие текущей страницы
        BasePage.getDriver().close();
        //переход на новую страницу
        BasePage.getDriver().switchTo().window(newWindow);
    }
}
