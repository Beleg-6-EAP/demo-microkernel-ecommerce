package plugins

import demo.model.Order
import demo.plugins.payment.DemoPaymentPlugin
import demo.model.Payment
import demo.plugins.payment.internal.PaymentRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import org.springframework.dao.DataAccessException

class DemoPaymentPluginTest {

    private val paymentRepository: PaymentRepository = mock(PaymentRepository::class.java)
    private val demoPaymentPlugin = DemoPaymentPlugin(paymentRepository)

    @Test
    fun processPayment_savesPaymentSuccessfully() {
        val order = Order("1", "item1")
        val payment = Payment(orderId = order.id)
        `when`(paymentRepository.save(any(Payment::class.java))).thenReturn(payment)

        val result = demoPaymentPlugin.processPayment(order)

        verify(paymentRepository, times(1)).save(any(Payment::class.java))
        assertEquals(payment, result)
    }

    @Test
    fun getAllPayments_returnsListOfPayments() {
        val payments = listOf(Payment("1", "23"), Payment("2", "34"))
        `when`(paymentRepository.findAll()).thenReturn(payments)

        val result = demoPaymentPlugin.getAllPayments()

        assertEquals(payments, result)
    }

    @Test
    fun getAllPayments_whenNoPayments_returnsEmptyList() {
        `when`(paymentRepository.findAll()).thenReturn(emptyList())

        val result = demoPaymentPlugin.getAllPayments()

        assertEquals(emptyList<Payment>(), result)
    }
}