package validator;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.Basket;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static util.WorkWithDataOfElements.convertTextPriceToNumber;
import static util.WorkWithDataOfElements.getTotalPriceFromListOfWebElements;

public class ValidateBasket extends Basket {

    @Step("Проверка, что текст и цена товара должны соответствовать цене и названию товара из предыдущих шагов")
    public ArrayList<String> checkDataAboutProduct(ArrayList<String> dataAboutProduct) {
        String expectedProductName = dataAboutProduct.get(0).substring(2);
        String expectedProductBrand = dataAboutProduct.get(1);
        String expectedProductPrice = dataAboutProduct.get(2).trim();

        $(nameOfProductInBasket).shouldHave(Condition.text(expectedProductName));

        $(brandOfProductInBasket).shouldHave(Condition.text(expectedProductBrand));

        $(priceOfProductInBasket).shouldHave(Condition.text(expectedProductPrice));

        return dataAboutProduct;
    }

    @Step("“Итого” должно быть равно сумме товара")
    public ValidateBasket checkTotalSum() {
        ElementsCollection elements = $$(listOfProductsPrices);
        elements.shouldHave(CollectionCondition.size(1));
        int totalPriceFromListOfWebElements = getTotalPriceFromListOfWebElements(elements);

        String actualSum = String.valueOf(convertTextPriceToNumber($(totalSum).getText()));

        Assertions.assertEquals(String.valueOf(totalPriceFromListOfWebElements), actualSum);

        return this;
    }

    @Step("Кнопка “Заказать” должна быть активна для нажатия")
    public ValidateBasket checkButtonToOrderIsEnabled() {
        $(buttonToOrder).shouldBe(Condition.enabled);

        return this;
    }

    @Step("Проверка, что в корзине пользователя находится добавленный товар")
    public void checkProductNameInBasket(String expectedProductName) {
        $(nameOfProductInBasket).shouldHave(Condition.text(expectedProductName));
    }
}