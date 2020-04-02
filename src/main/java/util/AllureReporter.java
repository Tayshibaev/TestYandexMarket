package util;

import gherkin.formatter.model.Result;
import steps.BasePage;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {
    @Override
    public void result(Result result) {
        if(result.getStatus().equals("failed"))
            BasePage.takeScreenshot();
        super.result(result);
    }
}
