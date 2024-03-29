import org.junit.Test;
import pages.*;
import steps.BasePage;


public class YandexMarketTest extends BasePage {

    @Test
    public void test() {
        //Переход по ссылке Маркет
        new MainPage().clickLink("Маркет");

        new MarketPage().selectPanelItem("Электроника");

        new ElectronicsPage().selectItemFromAudioAndVideoCategory("Телевизоры");

        new FoundPage().clickAdvanceSearchBtn();

        new AdvancedSearchPages().fillFieldPrice("20000")
                .checboxProducer("LG")
                .checboxProducer("Samsung")
                .clickContinue();

        //Показывать по 12
        new FoundPage().selectShow12Count()
                //запомнить все элементы и 1ый элемент
                .rememberFirstItem()
                //проверка что элементов 12
                .checkShowCount(12)
                //заполнить поле 1ым элементом
                .fillFieldFirstItem()
                //нажать на кнопку найти
                .clickSearchBtn()
                //Переход по ссылке и переход на новую страницу и закрытие старой
                .clickLink();

        //Провекра, что название элемента соответствует ожидаемому
        new ItemPage().checkTitle();

    }
}
