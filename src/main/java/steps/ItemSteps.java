package steps;

import cucumber.api.java.en.Then;
import pages.ItemPage;

public class ItemSteps {

    @Then("Проверка, что найденный элемент соответствует 1ому элементу из списка поиска")
    public void checkTitle()
    {
        new ItemPage().checkTitle();
    }
}
