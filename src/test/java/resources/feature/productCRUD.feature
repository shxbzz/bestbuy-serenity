Feature: Product Information

  As a user I want to test product Information

  Scenario Outline: CRUD Test
    Given Product Information is running
    When I create a new product by providing information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacture "<manufacture>" model "<model>" url"<url>" image "<image>"
    Then I verify that the product with "<productID>" is created
    And I update the product with information productID "<productID>"  name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacture "<manufacture>" model "<model>" url"<url>" image "<image>"
    And The product with productID "<productID>" is updated successfully
    And I delete the product that created with productID "<productID>"
    Then The product deleted successfully from the product information
    Examples:
      | name                              | type     | price | shipping | upc          | description                                                                                     | manufacture | model     | url                                                                                                      | image                                                                 | productID |
      | Duracell - AAA Batteries (4-Pack) | HardGood | 5.49  | 0        | 041333424019 | Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack | Duracell    | MN2400B4Z | http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg | 9999692   |
