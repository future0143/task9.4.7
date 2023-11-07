package stepDefinitions;

import config.ConfigSetup;
import cucumber.TestContext;
import elements.ListOfProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsAfterInput;
import validator.ValidateSearchResultsAfterInput;

public class StepDefSearchResultsAfterInput extends SearchResultsAfterInput implements ConfigSetup {

    private final ListOfProducts listOfProducts = new ListOfProducts();
    private final ValidateSearchResultsAfterInput validate = new ValidateSearchResultsAfterInput();
    private TestContext testContext;

    public StepDefSearchResultsAfterInput() {
    }

    @Then("пользователь видит товар {string} в результатах поиска")
    public void checkProductInSearchResults(String nameOfProduct) {
        validate.checkProductInSearchResults(nameOfProduct);
    }

    @When("пользователь добавляет товар в корзину")
    public void addProductToBasket() {
        listOfProducts.addToBasket();
    }

    @Then("на странице с результатами поиска присутствует текст {string}")
    public void textOnPageShouldHaveNameOfProduct(String product) {
        validate.checkTextOnPage(product);
    }

    @And("первый фильтр - {string}")
    public void checkFirstFilter(String filter) {
        validate.checkTextOfFirstFilter(filter);
    }

    @And("применен фильтр {string}")
    public void checkSorterFilter(String sorter) {
        validate.checkTextOfSorterFilter(sorter);
    }

    @And("у первого устройства из списка бренд - {string}")
    public void checkBrand(String brand) {
        validate.checkBrandOfFirstProduct(brand);
    }
}