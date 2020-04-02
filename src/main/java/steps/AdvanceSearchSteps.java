package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AdvancedSearchPages;

public class AdvanceSearchSteps {
    AdvancedSearchPages pages = new AdvancedSearchPages();

    @When("Заполнение минимальной цены \"(.*)\"")
    public void fillFieldPrice(String val)
    {
        pages.fillFieldPrice(val);
    }

    @When("Выбор производителя \"(.*)\"")
    public void checboxProducer(String checkbox)
    {
        pages.checboxProducer(checkbox);
    }

    @Then("Нажатие на кнопку продолжить")
    public void clickContinue()
    {
        pages.clickContinue();
    }
}
