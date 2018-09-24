package product

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/api/products'
    }
    response {
        status 200
        // TODO: the contract test would not test the structure of the response body?
        body("""
  [
    {
        "id": 1,
        "name": "可乐",
        "price": 450,
        "unit": "瓶",
        "imgUrl": "api/img/1",
        "totalAmount": 10
    },
    {
        "id": 2,
        "name": "雪碧",
        "price": 450,
        "unit": "瓶",
        "imgUrl": "api/img/2",
        "totalAmount": 5
    }
  ]
  """)
    }
}