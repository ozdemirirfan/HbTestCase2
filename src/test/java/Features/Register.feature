@TestCase2
Feature: Register Feature
  Scenario: Correct Register Test
    Given Kullanıcı Hepsiburada.com sitesini ziyaret eder
    When Kullanıcı, Kitap, Müzik, Film, Hobi kategorisine girer.
    And Uzaktan Kumandalı Arabalar münüsüne tıklar.
    And drone yedek parçalarından bir ürün seçer.
    And Ürünü sepete ekler.
    Then Ürünün sepete eklendiği görülür.