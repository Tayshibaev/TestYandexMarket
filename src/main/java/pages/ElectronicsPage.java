package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BasePage;

public class ElectronicsPage {

    @FindBy(xpath = "//div[@class='_1YdrMWBuYy']//a[text()='Аудио- и видеотехника']//..//..")
    WebElement categoryAudioAndVideo;

    @FindBy(xpath = "//div[@class='_1YdrMWBuYy']//a[text()='Портативная техника']//..//..")
    WebElement categoryPortableTech;

    public ElectronicsPage() {
        PageFactory.initElements(BasePage.getDriver(),this);
    }

    public void selectItemFromAudioAndVideoCategory(String item)
    {
        categoryAudioAndVideo.findElement(By.xpath(".//li//a[text()='"+item+"']")).click();
    }

    public void selectItemFromPortTechCategory(String item)
    {
        categoryPortableTech.findElement(By.xpath(".//li//a[contains(text(),'"+item+"')]")).click();
    }
}
