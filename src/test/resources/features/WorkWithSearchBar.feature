@all
@searchLine
@Feature("WorkWithSearchBar")
@Story("SearchProductByName")
@allure.label.owner=PodbutskayaEvgenia

Feature: Работа с поисковой строкой

  The search results page displays information in accordance with the Entered Product.

  @blocker
  Scenario: Поиск товара
    Given пользователь на главной странице магазина

    When пользователь вводит "Iphone 13" в строку поиска и нажимает Enter

    Then на странице с результатами поиска присутствует текст "Iphone 13"
    And первый фильтр - "Iphone 13"
    And применен фильтр "По популярности"
    And у первого устройства из списка бренд - "Apple"

    When пользователь нажимает на крестик на поисковой строке
    Then поисковая строка стала пустой