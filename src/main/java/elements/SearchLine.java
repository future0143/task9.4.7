package elements;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.SearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$;
import static pages.SearchResultsAfterInput.listOfGoodsInProductCardSelector;

public class SearchLine {

    private static final By searchLineSelector = By.id("searchInput");
    private static final By buttonSearchBarClear = By.cssSelector(".search-catalog__btn--clear");

    @Step("Пользователь вводит наименование товара в строку поиска и нажимает Enter")
    public SearchResultsAfterInput inputTextInSearchLine(String textForInput) {
        $(searchLineSelector).sendKeys(textForInput);
        $(searchLineSelector).sendKeys(Keys.ENTER);
        $(listOfGoodsInProductCardSelector).shouldBe(Condition.visible);

        return new SearchResultsAfterInput();
    }

    @Step("Пользователь нажимает на крестик на поисковой строке")
    public void clearSearchLine() {
        $(buttonSearchBarClear).click();
    }

    @Step("Проверка того, что поисковая строка стала пустой")
    public void checkSearchLineIsEmpty() {
        $(searchLineSelector).shouldBe(Condition.empty);
    }
}