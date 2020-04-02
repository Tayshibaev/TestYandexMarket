package steps;

import cucumber.api.java.en.When;
import pages.MainPage;
import sun.applet.Main;

public class MainSteps {

    MainPage page = new MainPage();
    @When("Переход по ссылке \"(.*)\"")
    public void clickMarket(String val){
        page.clickLink(val);
    }
}
