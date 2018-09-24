package order


org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/users/1/orders'
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 201
        // TODO: the contract test would not test the structure of the response body?
        body("""
  {
    "id": 1
  }
  """)
    }
}