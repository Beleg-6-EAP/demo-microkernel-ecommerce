package demo.microkernel.service

import demo.microkernel.plugins.api.PaymentProcessor
import demo.microkernel.plugins.api.ShipmentProcessor
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val paymentProcessor: PaymentProcessor,
    private val shipmentProcessor: ShipmentProcessor,
) {

}