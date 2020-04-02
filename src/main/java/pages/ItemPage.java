package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BasePage;

public class ItemPage {

    @FindBy(xpath = "//div[@class='n-product-headnote__headline']//div[@class='n-title__text']//h1")
    WebElement title;

    public ItemPage()
    {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    public void checkTitle()
    {
        String s = FoundPage.getFirstElem();
        String s1 = title.getText();
        Assert.assertEquals(s,s1);
    }
}
