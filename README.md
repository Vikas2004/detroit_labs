# Detroit_labs
This is TacoLoco application to enable their customers to place orders for their delicious tacos.


## Curl command to run in postman:
curl --location --request POST 'http://localhost:8080/api/orderprice' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "itemId": 1,
        "quantity": 3
    },
    {
        "itemId": 2,
        "quantity": 3
    },
    {
        "itemId": 3,
        "quantity": 3
    }
]'