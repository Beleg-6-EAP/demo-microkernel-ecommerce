package controller

import demo.controller.PaymentController
import demo.model.Payment
import demo.service.PaymentService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class PaymentControllerTest {

    private val paymentService: PaymentService = mock(PaymentService::class.java)
    private val paymentController = PaymentController(paymentService)

    @Test
    fun getAllPayments_returnsListOfPayments() {
        val payments = listOf(Payment("1", "12"), Payment("2", "34"))
        `when`(paymentService.getAllPayments()).thenReturn(payments)

        val response: ResponseEntity<List<Payment>> = paymentController.getAllPayments()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(payments, response.body)
    }

    @Test
    fun getAllPayments_whenNoPayments_returnsEmptyList() {
        `when`(paymentService.getAllPayments()).thenReturn(emptyList())

        val response: ResponseEntity<List<Payment>> = paymentController.getAllPayments()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(emptyList<Payment>(), response.body)
    }

    @Test
    fun getAllPayments_whenServiceThrowsException_returnsInternalServerError() {
        `when`(paymentService.getAllPayments()).thenThrow(IllegalStateException::class.java)

        val response: ResponseEntity<List<Payment>> = paymentController.getAllPayments()

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
    }
}