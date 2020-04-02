import org.junit.Test;
import pages.*;
import steps.BasePage;


public class YandexMarketTestPort extends BasePage {

    @Test
    public void test() {
        //Переход по ссылке Маркет
        new MainPage().clickLink("Маркет");

        new MarketPage().selectPanelItem("Электроника");

        new ElectronicsPage().selectItemFromPortTechCategory("Наушники");

        new FoundPage().clickAdvanceSearchBtn();

        new AdvancedSearchPages().fillFieldPrice("5000")
                .checboxProducer("Beats")
                .clickContinue();

        new FoundPage()
                //запомнить все элементы и 1ый элемент
                .rememberFirstItem()
                //проверка что элементов 12
              //  .checkShowCount(12)
                //заполнить поле 1ым элементом
                .fillFieldFirstItem()
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //нажать на кнопку найти
              //  new FoundPage()
                        .clickSearchBtn()
                //Переход по ссылке и переход на новую страницу и закрытие старой
                .clickLink();

        //Провекра, что название элемента соответствует ожидаемому
        new ItemPage().checkTitle();

    }
}
