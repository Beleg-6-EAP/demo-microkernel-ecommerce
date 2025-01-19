package demo.microkernel

import demo.microkernel.model.Payment
import org.pf4j.ExtensionPoint

interface PaymentProvider: ExtensionPoint {
    fun getPayments(): List<Payment>
    fun initPayment(orderId: String): Payment
}