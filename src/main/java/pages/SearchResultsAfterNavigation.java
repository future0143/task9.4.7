package pages;

import cucumber.TestContext;
import elements.ListOfProducts;
import elements.SearchLine;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import validator.ValidateBasket;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static util.WorkWithDataOfElements.convertTextPriceToNumber;

public class SearchResultsAfterNavigation {

    public static final By catalogTitleElement = By.cssSelector("h1.catalog-title");
    public static By listOfGoodsInProductCardSelector = By.className("product-card");
    public static By homeLinkPath = By.xpath("//a[@href='/']/span[@itemprop='name']");
    public static By appliancesLinkPath = By.xpath("//a[@href='/catalog/bytovaya-tehnika']/span[@itemprop='name']");
    public static By homeAppliancesLinkPath = By.xpath("//a[@href='/catalog/elektronika/tehnika-dlya-doma']/span[@itemprop='name']");
    public static By vacuumCleanersLinkPath = By.xpath("//span[@itemprop='name'][text()='Пылесосы и пароочистители']");
    public static String countOfProductsInBasket = "span.navbar-pc__notify";
    public static By buttonAllFiltersSelector = By.cssSelector(".dropdown-filter__btn--all");
    public static By listOfSelectedFilters = By.cssSelector(".your-choice__list");
    public static By countOfProductsElementName = By.className("goods-count");
    public static By tagNameOfFiltersList = By.tagName("li");
    public static By buttonToResetFilters = By.xpath("//button[text()='Сбросить все']");


    private final SearchLine searchLine;
    private final ListOfProducts listOfProducts;
    private TestContext testContext;

    public SearchResultsAfterNavigation() {
        this.searchLine = new SearchLine();
        this.listOfProducts = new ListOfProducts();
    }

    public static int getCountOfProducts() {
        return convertTextPriceToNumber($(countOfProductsElementName).getText());
    }


    public SearchResultsAfterNavigation hoverOnProductsFromList(int indexOfProduct) {
        $$(listOfGoodsInProductCardSelector).get(indexOfProduct).hover();

        return this;
    }

    public SearchResultsAfterNavigation addToBasket() {
        listOfProducts.addToBasket();

        return this;
    }

    @Step("Пользователь нажимает на “Корзина”")
    public ValidateBasket goToBasket() {
        listOfProducts.goToBasket();

        return new ValidateBasket();
    }

    @Step("Пользователь нажимает на “Все фильтры”")
    public Filters clickAllFilters() {
        $(buttonAllFiltersSelector).click();

        return new Filters();
    }

    @Step("Получить данные об n-ном товаре")
    public ArrayList<String> getDataAboutProductByIndex(int index) {
        hoverOnProductsFromList(index - 1);
        ArrayList<String> data = listOfProducts.getDataAboutProduct();

        return data;
    }
}