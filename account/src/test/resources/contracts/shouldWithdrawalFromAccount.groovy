package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "Should withdrawal given amount from account."
    request{
        method POST()
        urlPath("/accounts/accountNumber/transactions")
        body '''\
            {
                "type": "WITHDRAWAL", 
                "amount": {
                    "amount": 50, 
                    "currency": "SGD"
                  }
            }
        '''
        headers {
            header 'foo': 'bar'
            contentType(applicationJson())
        }
    }
    response {
        body('''
        {
            "accountNumber": {
                "value": "accountNumber"
             }, 
             "balance": {
                    "amount": -50, 
                    "currency": "SGD"
                  }
        }
        ''')
        status 201
    }
}