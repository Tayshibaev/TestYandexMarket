package steps;

import cucumber.api.java.en.When;
import pages.MarketPage;

public class MarketSteps {

    @When("Выбран раздел \"(.*)\"")
    public void clickItem(String val)
    {
        new MarketPage().selectPanelItem(val);
    }
}
