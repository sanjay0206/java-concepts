# SOAP vs REST API Comparison

This API.md file provides a simplified comparison between SOAP and REST API in a tabular format.

| Criteria     | SOAP                                   | REST                                  |
|--------------|----------------------------------------|--------------------------------------|
| Acronym      | Simple Object Access Protocol           | Representational State Transfer      |
| Communication| Uses XML for communication              | Supports multiple formats like JSON, XML, HTML, etc. |
| Protocol     | Rigid and follows a specific set of standards | Flexible and doesn't enforce any strict standards |
| Messaging    | Relies on XML for message format and WSDL for service description | Uses JSON or XML for data interchange and doesn't require additional messaging |
| Statelessness| Stateful and can manage complex transactions | Stateless and manages simple transactions effectively |
| Overhead     | Heavy and has more overhead due to extensive XML messaging | Lighter and has less overhead due to the use of simpler formats like JSON |
| Performance  | Comparatively slower due to XML parsing | Faster due to lightweight messaging and simpler data formats |
| Error handling | Provides detailed error handling through standardized fault elements | Error handling varies and is often left to the developer's implementation |
| Security     | Offers built-in security features through WS-Security | Security is managed through HTTPS and is less complex compared to SOAP |
| Usage        | Commonly used in enterprise-level applications and in situations where security and reliability are critical | Preferred for mobile applications and in situations where scalability and performance are essential |

### Ordering Pizza with SOAP Request:

```xml
<SOAP-ENV:Envelope
  xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:ns1="http://www.example.com/pizzaService">
  <SOAP-ENV:Body>
    <ns1:OrderPizza>
      <size>large</size>
      <toppings>
        <topping>pepperoni</topping>
        <topping>mushrooms</topping>
      </toppings>
      <deliveryAddress>
        <street>123 Main St</street>
        <city>Anytown</city>
        <state>CA</state>
        <zip>12345</zip>
      </deliveryAddress>
    </ns1:OrderPizza>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope> 
```

### Ordering Pizza with SOAP Request:
```json5
POST /api/orderPizza
Host: www.example.com
Content-Type: application/json

{
  "size": "large",
  "toppings": ["pepperoni", "mushrooms"],
  "deliveryAddress": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA",
    "zip": "12345"
  }
}
