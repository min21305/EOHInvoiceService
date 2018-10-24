# EOHInvoiceService

## To run this application execute the below commands:

1. Go to the Root directory of project in command prompt and run 
    mvn clean install 

2. Now execute mvn spring-boot:run command this will start you application 


##List of API's

## Add Invoice
POST http://localhost:8080/invoices

Header: Content-Type: application/json

  ```JSON
      {
      "client": "Ashish",
      "vatRate": 11,
      "lineItems": [
        {
          "quantity": 8,
          "description": "Widget",
          "unitPrice": 1.02
        }
      ]
    }
```

## View All invoices
GET http://localhost:8080/invoices

## View Invoice
GET http://localhost:8080/invoices/{invoiceId}
