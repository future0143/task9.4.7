@all
@filters
@allure.label.feature:WorkWithFilters
@allure.label.story:SetupFilters
@allure.label.owner:PodbutskayaEvgenia

Feature: Работа с фильтрами

  Filters Applied To Search Appear On Search Results Page

  @normal
  Scenario: Настроить фильтры для поиска товаров
    Given пользователь на главной странице магазина

    When пользователь нажимает на “Фильтры”
    And выбирает “Электроника” - “Ноутбуки и компьютеры” - “Ноутбуки”

    Then открывается страница с ноутбуками - "Ноутбуки и ультрабуки"

    When Применяются фильтры:
    And Цена: От 100000 до 149000
    And Срок доставки: до 3 дней
    And Бренд: Apple
    And Диагональ экрана: 13.3”
    And пользователь нажимает на кнопку “Показать”

    Then фильтр активируется
    And кол-во товара на страница = количеству товара на странице
    And выбранные фильтры отображаются на странице
    And появилась кнопка “Сбросить все”