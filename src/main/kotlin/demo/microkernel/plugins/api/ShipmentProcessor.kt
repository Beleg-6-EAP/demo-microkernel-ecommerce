package demo.microkernel.plugins.api

interface ShipmentProcessor {
    fun processShipment(orderId: String)
}