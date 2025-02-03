![Static Badge](https://img.shields.io/badge/Kotin-1.9.25-orange)
![Static Badge](https://img.shields.io/badge/Maven-4.0.0-red)
[![Maven Build & Tests](https://github.com/Beleg-6-EAP/demo-microkernel-ecommerce/actions/workflows/maven-build-test.yml/badge.svg)](https://github.com/Beleg-6-EAP/demo-microkernel-ecommerce/actions/workflows/maven-build-test.yml)

# Microkernel E-Commerce Demo

This repository provides a minimal example showcasing the Microkernel-Architecture in an E-Commerce setting.
This setting includes orders, payment and shipping.

This demo is part of an article on Enterprise Architecture-Patterns.
The article, including the complete explanation of the E-Commerce-Example, can be found [here](https://github.com/Beleg-6-EAP/Belegarbeit).

## Get running

Either run the docker image via plain docker:
```bash
bash> sudo docker build -t demo-microkernel-ecommerce .
bash> sudo docker run -p 8080:8080 demo-microkernel-ecommerce  
```
or with the given `docker-compose`:
```bash
bash> sudo docker-compose up
```

Either will start a web-server running on `http://localhost:8080` with the following endpoints:

- CreateOrder: `POST /api/orders`
- AllOrders: `GET /api/orders`
- AllPayments: `GET /api/payments`
- AllShipments: `GET /api/shipments`

We start with en empty database.
To create an order `POST` below request to `http://localhost:8080/api/orders`:

```json
{
    "userId": "1234-5678-8765-4321",
    "amount": 42.0,
    "status": "New"
}
```

This will initiate payment as well as shipment.

It's success can be checked by requesting the other endpoints via `GET`.

## Troubleshooting

If there is any trouble or if you have any questions, feel free to open an issue!
