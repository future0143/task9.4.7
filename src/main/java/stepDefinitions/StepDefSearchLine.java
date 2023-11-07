package stepDefinitions;

import elements.SearchLine;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefSearchLine extends SearchLine {


    @When("пользователь нажимает на крестик на поисковой строке")
    public void clickClearSearchLine() {
        clearSearchLine();
    }

    @Then("поисковая строка стала пустой")
    public void checkSearchBarIsEmpty() {
        checkSearchLineIsEmpty();
    }

    @When("пользователь вводит {string} в строку поиска и нажимает Enter")
    public void inputProductInSearchLine(String text) {
        inputTextInSearchLine(text);
    }
}