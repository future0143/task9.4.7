package validator;

import com.codeborne.selenide.WebDriverRunner;
import config.TestProperties;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class ValidateHomePage extends HomePage {

    @Step("Проверка того, что отображается адрес пункта выдачи из предыдущего шага")
    public void checkCity(String expectedCity) {
        Assertions.assertEquals(expectedCity, getCity());
    }

    @Step("Проверка того, что происходит переход на главную страницу WB")
    public ValidateHomePage checkUrl() {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = TestProperties.getValue("test.url");
        Assertions.assertEquals(expectedUrl, actualUrl);

        return this;
    }
}