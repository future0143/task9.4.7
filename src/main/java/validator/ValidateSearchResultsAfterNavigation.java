package validator;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.SearchResultsAfterNavigation;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static elements.ListOfProducts.listProductsAfterFiltersSelector;
import static util.WorkWithDataOfElements.getListOfTextsFromListOfElements;

public class ValidateSearchResultsAfterNavigation extends SearchResultsAfterNavigation {

    @Step("Проверка того, что отображается определенный заголовок")
    public ValidateSearchResultsAfterNavigation checkTitleOfCatalog(String expectedText) {
        $(catalogTitleElement).shouldHave(Condition.text(expectedText));

        return this;
    }

    @Step("Проверка пути фильтра")
    public void checkPathOfFilters() {
        $(homeLinkPath).shouldHave(Condition.text("Главная"));
        $(appliancesLinkPath).shouldHave(Condition.text("Бытовая техника"));
        $(homeAppliancesLinkPath).shouldHave(Condition.text("Техника для дома"));
        $(vacuumCleanersLinkPath).shouldHave(Condition.text("Пылесосы и пароочистители"));
    }

    @Step("Проверка того, что в правом верхнем углу над логотипом “Корзина” появляется красная цифра, соответствующая количеству товара в корзине")
    public void checkCountOfProductsInBasket(int expectedCount) {
        $(countOfProductsInBasket).shouldHave(Condition.text(String.valueOf(expectedCount)));
    }

    @Step("Проверка того, что фильтр активировался")
    public ValidateSearchResultsAfterNavigation checkSelectedFiltersIsVisible() {
        $(listOfSelectedFilters).shouldBe(Condition.visible);

        return this;
    }

    @Step("Проверка того, что кол-во товара на страница = количеству товара на странице")
    public ValidateSearchResultsAfterNavigation checkCountOfProducts(int countOfProducts) {
        $$(listProductsAfterFiltersSelector).shouldHave(CollectionCondition.size(countOfProducts));

        return this;
    }

    @Step("Проверка того, что выбранные фильтры отображаются на странице")
    public ValidateSearchResultsAfterNavigation checkSelectedFiltersOnPage(List<String> listOfFiltersTextExpected) {
        ElementsCollection listOfFiltersActual = $$(tagNameOfFiltersList);

        List<String> listOfFiltersTextActual = getListOfTextsFromListOfElements(listOfFiltersActual);

        Assertions.assertFalse(Collections.disjoint(listOfFiltersTextActual, listOfFiltersTextExpected));

        return this;
    }

    @Step("Проверка того, что появилась кнопка “Сбросить все”")
    public ValidateSearchResultsAfterNavigation checkButtonToResetFilterIsVisible() {
        $(buttonToResetFilters).shouldBe(Condition.visible);

        return this;
    }
}