package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;

import static util.DataForAllureResult.getCurrentBrowser;
import static util.DataForAllureResult.getCurrentTimestamp;

public class Hooks {

    @Before
    public static void setup() {
        Configuration.timeout = 25000;
        Configuration.browser = "chrome";

        Allure.addAttachment("Время запуска", getCurrentTimestamp());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @After
    public static void tearDown() {
        Allure.addAttachment("Браузер", getCurrentBrowser());
    }
}