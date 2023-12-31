package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import validator.ValidateHomePage;

import static com.codeborne.selenide.Selenide.$;

public class PickUpPoint {

    protected static final By infoAboutPickUpPoint = By.className("details-self");
    protected static final By addressOnInfoPoint = By.className("details-self__name-text");
    private static final By buttonChoosePoint = By.cssSelector("button[data-link*='onPooSelect']");

    @Step("Пользователь нажимает на кнопку “Выбрать”")
    public ValidateHomePage choosePoint() {
        $(buttonChoosePoint).click();

        return new ValidateHomePage();
    }
}