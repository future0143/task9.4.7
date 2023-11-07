package validator;

import com.codeborne.selenide.WebDriverRunner;
import config.TestProperties;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.AirTickets;

public class ValidateAirTickets extends AirTickets {

    @Step("Проверка того, что происходит переход на страницу с авиабилетами")
    public void checkUrl() {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = TestProperties.getValue("avia.url");
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}