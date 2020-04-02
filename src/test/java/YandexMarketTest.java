import org.junit.Test;
import pages.*;


public class YandexMarketTest extends BasePage {

    @Test
    public void test()
    {
        new MainPage().clickLink("Маркет");

        new MarketPage().selectPanelItem("Электроника");

        new ElectronicsPage().selectItemFromAudioAndVideoCategory("Телевизоры");

        new FoundPage().clickAdvanceSearchBtn();

        new AdvancedSearchPages().fillFieldPrice("20000")
                .checboxProducer("LG")
                .checboxProducer("Samsung")
                .clickContinue();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // new FoundPage().selectShowCount();

        new FoundPage().showItem();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
