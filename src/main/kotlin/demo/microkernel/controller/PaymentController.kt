package demo.microkernel.controller

import demo.microkernel.model.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController {

    @GetMapping
    fun getAllPayments(): ResponseEntity<List<Payment>> {
        // TODO: Implement
        return ResponseEntity.ok(listOf())
    }
}