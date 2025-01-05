package demo.microkernel.plugins.impl

import demo.microkernel.plugins.api.PaymentProcessor
import org.springframework.stereotype.Service

@Service
class PaymentProcessorImpl : PaymentProcessor {
    override fun processPayment(orderId: String) {
        println("Processing payment for order $orderId")
    }
}