package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pages.ElectronicsPage;

public class ElectronicSteps {

    @When("Выбор из категории Аудио и Видео техники элемента \"(.*)\"")
    public void selectItemFromAudioAndVideoCategory(String val)
    {
        new ElectronicsPage().selectItemFromAudioAndVideoCategory(val);
    }

    @When("Выбор из категории Портативная техники элемента \"(.*)\"")
    public void selectItemFromPortTechCategory(String val)
    {
        new ElectronicsPage().selectItemFromPortTechCategory(val);
    }


}
