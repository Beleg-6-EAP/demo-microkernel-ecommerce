package demo.plugins.payment

import demo.model.Order
import demo.model.Payment
import demo.plugins.api.PaymentPlugin
import demo.plugins.payment.internal.PaymentRepository
import org.springframework.stereotype.Service

@Service
class DemoPaymentPlugin(private val paymentRepository: PaymentRepository) : PaymentPlugin {
    override fun getName() = "DemoPaymentPlugin"

    override fun processPayment(order: Order): Payment {
        println("Processing payment via DemoPaymentPlugin for order: ${order.id}")
        val payment = Payment(orderId = order.id)
        paymentRepository.save(payment)
        return payment
    }

    override fun getAllPayments(): List<Payment> {
        return paymentRepository.findAll()
    }
}