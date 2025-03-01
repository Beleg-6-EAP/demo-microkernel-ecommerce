package demo.controller

import demo.model.Payment
import demo.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @GetMapping
    fun getAllPayments(): ResponseEntity<List<Payment>> {
        val payments = try {
            paymentService.getAllPayments()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
        return ResponseEntity.ok(payments)
    }

}