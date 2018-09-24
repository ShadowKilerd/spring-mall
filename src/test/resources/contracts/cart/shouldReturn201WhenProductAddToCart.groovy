package cart


org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/users/1/carts'
        headers {
            header('Content-Type', 'application/json')
        }
        body("""
        [
            {
                "productId": 1,
                "quantity": 10
            },
            {
                "productId": 2,
                "quantity": 10
            }
        ]
        """)
    }
    response {
        status 201
        // TODO: the contract test would not test the structure of the response body?
        body("""
  [
    {
        "productId": 1,
        "quantity": 10
    },
    {
        "productId": 2,
        "quantity": 10
    }
]
  """)
    }
}