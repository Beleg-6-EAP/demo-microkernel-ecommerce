package demo.microkernel.plugins.api


interface PaymentProcessor {
    fun processPayment(orderId: String)
}