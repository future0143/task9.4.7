@all
@city
@allure.feature("ChangeCity")
@allure.story("ChangeCityAndSelectDeliveryPointAddress")
@allure.label.owner:PodbutskayaEvgenia

Feature: Смена города

  After changing the city, the new city is displayed on the main page

  @normal
  Scenario: Смена города и выбор адреса пункта выдачи
    Given пользователь на главной странице магазина

    When пользователь кликает на кнопку “Смена города”
    And вводит в поисковую строку название города - "Санкт-Петербург"
    And выбирает 1-й адрес из списка адресов с городом "Санкт-Петербург"

    Then открывается информация о центре выдачи
    And адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов

    When пользователь нажимает на кнопку “Выбрать”
    Then происходит переход на главную страницу WB
    And отображается адрес пункта выдачи из предыдущего шага