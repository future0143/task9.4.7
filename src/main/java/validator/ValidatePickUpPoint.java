package validator;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.PickUpPoint;

import static com.codeborne.selenide.Selenide.$;

public class ValidatePickUpPoint extends PickUpPoint {

    @Step("Проверка того, что открывается информация о центре выдачи")
    public ValidatePickUpPoint checkInfoAboutPickUpPointIsVisible() {
        $(infoAboutPickUpPoint).shouldBe(Condition.visible);

        return new ValidatePickUpPoint();
    }

    @Step("Проверка того, что адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов")
    public PickUpPoint checkAddress(String expectedText) {
        $(addressOnInfoPoint).shouldHave(Condition.text(expectedText));

        return new PickUpPoint();
    }
}