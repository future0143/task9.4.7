package validator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.SearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ValidateSearchResultsAfterInput extends SearchResultsAfterInput {

    @Step("Проверка того, что на странице с результатами поиска присутствует текст с наименованием введенного товара")
    public ValidateSearchResultsAfterInput checkTextOnPage(String expectedText) {
        String actualText = $(pathNameOfCatalog).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    @Step("Проверка того, что первый фильтр - с наименованием введенного товара")
    public ValidateSearchResultsAfterInput checkTextOfFirstFilter(String expectedText) {
        String actualText = $(firstFilter).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    @Step("Проверка того, что применен определенный фильтр")
    public ValidateSearchResultsAfterInput checkTextOfSorterFilter(String expectedText) {
        String actualText = $(filterOfSorter).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    @Step("Проверка того, что у первого устройства из списка определенный бренд")
    public ValidateSearchResultsAfterInput checkBrandOfFirstProduct(String expectedText) {
        String actualText = findBrandOfFirstProduct();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    @Step("Пользователь видит введенный товар в результатах поиска")
    public void checkProductInSearchResults(String nameOfProduct) {
        SelenideElement element = $$(listOfGoodsInProductCardSelector)
                .filter(Condition.text(nameOfProduct))
                .first()
                .shouldBe(Condition.visible);
        element.hover();
    }
}