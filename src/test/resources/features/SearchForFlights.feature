@all
@airTickets
@allure.feature:SearchAirTickets
@allure.story:SearchAirTicketsByCriteria
@allure.label.owner:PodbutskayaEvgenia

Feature: Поиск авиабилетов

  After entering data into the air ticket form, search results are displayed

  @normal
  Scenario: Поиск авиабилетов по заданным критериям
    Given пользователь на главной странице магазина

    When пользователь нажимает на “Фильтры”
    And выбирает “Путешествия” - “Авиабилеты”

    Then происходит переход на страницу с авиабилетами

    When пользователь вводит в поле “Откуда” - "Домодедово"
    And вводит в поле “Куда” - "Санкт-Петербург, Пулково, Россия"
    And вводит в поле “Дата” - указать дату - Сегодняшний день + 2 дня
    And выбирает 2 взрослых пассажиров
    And нажимает “Найти билеты”

    Then если билеты найдены: есть хотя бы один билет в списке с результатами поиска отображается сообщение о том, что билеты не найдены.