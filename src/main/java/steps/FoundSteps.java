package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FoundPage;


public class FoundSteps {

    FoundPage pages = new FoundPage();

    @When("Выбрать расширенный поиск")
    public void clickAdvanceSearchBtn()
    {
        pages.clickAdvanceSearchBtn();
    }

    @When("Выбрать показывать по 12 элементов")
    public void selectShow12Count()
    {
        pages.selectShow12Count();
    }

    @Then("Проверка, что на странице \"(.*)\" элементов")
    public void checkShowCount(Integer val)
    {
        pages.checkShowCount(val);
    }

    @When("Из всех доступных элементов запомнить первый")
    public void rememberFirstItem()
    {
        pages.rememberFirstItem();
    }

    @Then("Первый элемент вбить в поисковую строку")
    public void fillFieldFirstItem() {
        pages.fillFieldFirstItem();
    }

    @Then("Нажать на кнопку Найти")
    public void clickSearchBtn()
    {
        pages.clickSearchBtn();
    }

    @Then("Перейти по ссылке найденного элемента")
    public void clickLink()
    {
        pages.clickLink();
    }
}
