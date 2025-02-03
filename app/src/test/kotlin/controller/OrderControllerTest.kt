package controller

import demo.controller.OrderController
import demo.model.Order
import demo.service.OrderService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class OrderControllerTest {

    private val orderService: OrderService = mock(OrderService::class.java)
    private val orderController = OrderController(orderService)

    @Test
    fun getAllOrders_returnsListOfOrders() {
        val orders = listOf(Order("1", "item1"), Order("2", "item2"))
        `when`(orderService.getAllOrders()).thenReturn(orders)

        val response: ResponseEntity<List<Order>> = orderController.getAllOrders()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(orders, response.body)
    }

    @Test
    fun createOrder_createsOrderSuccessfully() {
        val order = Order("1", "item1")

        val response: ResponseEntity<Unit> = orderController.createOrder(order)

        verify(orderService, times(1)).createOrder(order)
        assertEquals(HttpStatus.CREATED, response.statusCode)
    }

    @Test
    fun createOrder_withInvalidOrder_returnsBadRequest() {
        val invalidOrder = Order("0", "")

        doThrow(IllegalStateException::class.java).`when`(orderService).createOrder(invalidOrder)

        val response: ResponseEntity<Unit> = orderController.createOrder(invalidOrder)

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
    }
}