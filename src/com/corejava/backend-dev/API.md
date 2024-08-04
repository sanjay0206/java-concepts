# SOAP vs REST API Comparison

This API.md file provides a simplified comparison between SOAP and REST API in a tabular format.

| Criteria       | SOAP                                                                                                         | REST                                                                                                |
|----------------|--------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Acronym        | Simple Object Access Protocol                                                                                | Representational State Transfer                                                                     |
| Communication  | Uses XML for communication                                                                                   | Supports multiple formats like JSON, XML, HTML, etc.                                                |
| Protocol       | Rigid and follows a specific set of standards                                                                | Flexible and doesn't enforce any strict standards                                                   |
| Messaging      | Relies on XML for message format and WSDL for service description                                            | Uses JSON or XML for data interchange and doesn't require additional messaging                      |
| Statelessness  | Stateful and can manage complex transactions                                                                 | Stateless and manages simple transactions effectively                                               |
| Overhead       | Heavy and has more overhead due to extensive XML messaging                                                   | Lighter and has less overhead due to the use of simpler formats like JSON                           |
| Performance    | Comparatively slower due to XML parsing                                                                      | Faster due to lightweight messaging and simpler data formats                                        |
| Error handling | Provides detailed error handling through standardized fault elements                                         | Error handling varies and is often left to the developer's implementation                           |
| Security       | Offers built-in security features through WS-Security                                                        | Security is managed through HTTPS and is less complex compared to SOAP                              |
| Usage          | Commonly used in enterprise-level applications and in situations where security and reliability are critical | Preferred for mobile applications and in situations where scalability and performance are essential |

### Ordering Pizza with SOAP Request:

```xml
<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
        xmlns:pizza="http://www.example.com/pizzaService">
    <SOAP-ENV:Body>
        <pizza:OrderPizza>
            <pizza:pizzaCategory>non-vegetarian</pizza:pizzaCategory>
            <pizza:pizzaName>Spicy Meat Feast</pizza:pizzaName>
            <pizza:size>large</pizza:size>
            <pizza:toppings>
                <pizza:topping>pepperoni</pizza:topping>
                <pizza:topping>sausage</pizza:topping>
                <pizza:topping>ham</pizza:topping>
                <pizza:topping>bacon</pizza:topping>
            </pizza:toppings>
            <pizza:deliveryAddress>
                <pizza:street>123 Main St</pizza:street>
                <pizza:city>Anytown</pizza:city>
                <pizza:state>CA</pizza:state>
                <pizza:zip>12345</pizza:zip>
            </pizza:deliveryAddress>
        </pizza:OrderPizza>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
### Ordering Pizza with REST Request:
```xml
<OrderPizza xmlns="http://www.example.com/pizzaService">
<pizzaCategory>non-vegetarian</pizzaCategory>
<pizzaName>Spicy Meat Feast</pizzaName>
<size>large</size>
<toppings>
    <topping>pepperoni</topping>
    <topping>sausage</topping>
    <topping>ham</topping>
    <topping>bacon</topping>
</toppings>
<deliveryAddress>
    <street>123 Main St</street>
    <city>Anytown</city>
    <state>CA</state>
    <zip>12345</zip>
</deliveryAddress>
</OrderPizza>

```

### Ordering Pizza with REST Request:

```json5
POST /api/orderPizza
Host: www.example.com
Content-Type: application/json
{
  "pizzaCategory": "non-vegetarian",
  "pizzaName": "Spicy Meat Feast",
  "size": "large",
  "toppings": ["pepperoni", "sausage", "ham", "bacon"],
  "deliveryAddress": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA",
    "zip": "12345"
  }
}
