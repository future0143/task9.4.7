package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import validator.ValidateSearchResultsAfterNavigation;

import static com.codeborne.selenide.Selenide.$;
import static pages.HomePage.buttonFiltersCssSelector;

public class SiteNavigation {

    public static By filterTripsSelector = By.linkText("Путешествия");
    public static By filterFlightsSelector = By.linkText("Авиабилеты");
    protected static By filterAppliances = By.linkText("Бытовая техника");
    protected static By homeAppliances = By.xpath("//span[contains(text(), 'Техника для дома')]");
    protected static By vacuumAndSteamCleaners = By.linkText("Пылесосы и пароочистители");
    protected static By filterElectronicsSelector = By.linkText("Электроника");
    protected static By filterLaptopsAndPC = By.xpath("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    protected static By filterLaptops = By.linkText("Ноутбуки");

    @Step("Пользователь наводит курсор на “Бытовая техника“")
    public SiteNavigation hoverOnAppliances() {
        $(filterAppliances).hover();

        return this;
    }

    @Step("Пользователь наводит курсор на “Техника для дома“")
    public SiteNavigation hoverAndClickOnHomeAppliances() {
        $(homeAppliances).hover().click();

        return this;
    }

    @Step("Пользователь нажимает на “Пылесосы и пароочистители“")
    public ValidateSearchResultsAfterNavigation clickOnVacuumAndSteamCleaners() {
        $(vacuumAndSteamCleaners).click();

        return new ValidateSearchResultsAfterNavigation();
    }

    @Step("Пользователь наводит курсор на “Путешествия”")
    public SiteNavigation hoverOnTrips() {
        $(filterTripsSelector).scrollIntoView(true).hover();

        return this;
    }

    @Step("Пользователь нажимает на “Авиабилеты”")
    public AirTickets clickOnAirTickets() {
        $(filterFlightsSelector).click();

        return new AirTickets();
    }

    @Step("Пользователь наводит курсор на “Электроника”")
    public SiteNavigation hoverOnElectronic() {
        $(filterElectronicsSelector).scrollIntoView(true).hover();

        return this;
    }

    @Step("Пользователь наводит курсор на “Ноутбуки и компьютеры”")
    public SiteNavigation hoverAndClickOnLaptopAndPC() {
        $(filterLaptopsAndPC).hover().click();

        return this;
    }

    @Step("Пользователь нажимает на “Ноутбуки”")
    public ValidateSearchResultsAfterNavigation clickOnLaptops() {
        $(filterLaptops).click();

        return new ValidateSearchResultsAfterNavigation();
    }

    @Step("Пользователь переходит в определенную категорию")
    public SearchResultsAfterNavigation goToCategory(String category) {
        $(buttonFiltersCssSelector).click();
        $(By.linkText(category)).click();

        return new SearchResultsAfterNavigation();
    }
}