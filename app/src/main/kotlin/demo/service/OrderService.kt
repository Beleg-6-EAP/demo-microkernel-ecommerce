package demo.service


import demo.internal.OrderRepository
import demo.internal.plugins.PluginRegistry
import demo.model.Order
import demo.plugins.api.PaymentPlugin
import demo.plugins.api.ShipmentPlugin
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val pluginRegistry: PluginRegistry,
    private val orderRepository: OrderRepository,
) {
    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun createOrder(order: Order): Order {
        val paymentPlugin = pluginRegistry.getAllPlugins()
            .filterIsInstance<PaymentPlugin>()
            .firstOrNull() ?: throw IllegalStateException("No payment plugin found")

        val shipmentPlugin = pluginRegistry.getAllPlugins()
            .filterIsInstance<ShipmentPlugin>()
            .firstOrNull() ?: throw IllegalStateException("No shipment plugin found")

        paymentPlugin.processPayment(order)
        shipmentPlugin.shipOrder(order)
        orderRepository.save(order)
        return order
    }
}