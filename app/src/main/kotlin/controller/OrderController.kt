package controller

import demo.microkernel.model.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.OrderService

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun getAllOrders(): ResponseEntity<List<Order>> {
        // TODO: Implement
        return ResponseEntity.ok(listOf())
    }


    @PostMapping
    fun createOrder(@RequestBody order: Order): ResponseEntity<Unit> {
        // TODO: Implement
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}