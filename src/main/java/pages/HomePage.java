package pages;

import config.ConfigSetup;
import elements.SearchLine;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage implements ConfigSetup {

    public static final By buttonFiltersCssSelector = By.cssSelector(".j-menu-burger-btn");
    public static final By mainContent = By.cssSelector(".main-page__content-wrapper");
    private static final By cssSelectorForCity = By.cssSelector(".j-geocity-wrap");
    private final SearchLine searchLine;

    public HomePage() {
        this.searchLine = new SearchLine();
    }

    @Step("Пользователь нажимает на “Фильтры”")
    public SiteNavigation clickButtonFilter() {
        $(buttonFiltersCssSelector).click();

        return new SiteNavigation();
    }

    @Step("Пользователь нажимает на кнопку “Смена города”")
    public City clickChangeCity() {
        $(cssSelectorForCity).click();

        return new City();
    }

    public String getCity() {
        return $(cssSelectorForCity).getText();
    }
}