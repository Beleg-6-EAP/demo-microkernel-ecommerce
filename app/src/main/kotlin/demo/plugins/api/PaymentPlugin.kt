package demo.plugins.api

import demo.model.Order
import demo.model.Payment

interface PaymentPlugin : Plugin {
    fun processPayment(order: Order): Payment
    fun getAllPayments(): List<Payment>
}
