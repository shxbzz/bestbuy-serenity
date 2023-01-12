Feature: Testing different request on the product information

  Scenario: Check if the product information can be accessed by users
    When User sends a Get request to product endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new product & verify if the product is added
    When I create a new product by providing information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacture "<manufacture>" model "<model>" url"<url>" image "<image>"
    Then I verify that the product with "<productID>" is created
    Examples:
      | name                              | type     | price | shipping | upc          | description                                                                                     | manufacture | model     | url                                                                                                      | image                                                                 |
      | Duracell - AAA Batteries (4-Pack) | HardGood | 5.49  | 0        | 041333424019 | Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack | Duracell    | MN2400B4Z | http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg |

