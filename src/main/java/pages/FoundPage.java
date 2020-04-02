package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BasePage;

import java.util.List;
import java.util.Set;

public class FoundPage {

    private static List<WebElement> list;
    private static String firstElem;

    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement advanceSearchBtn;

    @FindBy(xpath = "//span[contains(@class,'select select_size_s select_theme_normal')]")
    WebElement showCount;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-list n-snippet')]")
    WebElement listItem;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchString;

    @FindBy(xpath = "//span[text()='Найти']//..")
    WebElement searchBtn;


    public FoundPage() {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    public static String getFirstElem() {
        return firstElem;
    }

    public void clickAdvanceSearchBtn()
    {
        advanceSearchBtn.click();
    }

    //Показывать по 12
    public FoundPage selectShow12Count()
    {
        showCount.findElement(By.xpath(".//button")).click();
        BasePage.getDriver().findElement(By.xpath("//span[text()='Показывать по "+12+"']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public FoundPage checkShowCount(Integer val)
    {
        Assert.assertEquals((long)list.size(),(long)val);
        return this;
    }

    //запомнить все элементы списка и отдельно 1ый эелемент
    public FoundPage rememberFirstItem()
    {
        list = listItem.findElements(By.xpath(".//div[contains(@class,'n-snippet-card2 i-bem b-zone')]//h3//a"));
        firstElem = list.get(0).getText();
        return this;
    }

    //занести в поискову строку первый элемент
    public FoundPage fillFieldFirstItem() {
        fillField(firstElem);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    public FoundPage fillField(String val) {
        searchString.clear();
        searchString.sendKeys(val);
        return this;
    }

    public FoundPage clickSearchBtn()
    {
        new WebDriverWait(BasePage.getDriver(),1,5).until(
                ExpectedConditions.visibilityOf(searchBtn)
        ).click();
        //searchBtn.click();
        return this;
    }

    public void clickLink()
    {
        //Первоначально открытые вкладки
        Set<String> oldSetWindow = BasePage.getDriver().getWindowHandles();
        BasePage.getDriver().findElement(By.xpath("//a[@title='"+firstElem+"']")).click();
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
