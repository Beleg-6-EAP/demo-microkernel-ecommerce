package demo.controller

import demo.model.Order
import demo.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val orderService: OrderService,
) {
    @GetMapping
    fun getAllOrders(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getAllOrders())
    }


    @PostMapping
    fun createOrder(@RequestBody order: Order): ResponseEntity<Unit> {
        orderService.createOrder(order)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}