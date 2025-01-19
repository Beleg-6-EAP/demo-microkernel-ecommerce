package demo.microkernel

import demo.microkernel.model.Shipment
import org.pf4j.ExtensionPoint

interface ShipmentProvider : ExtensionPoint {
    fun getAllShipments(): List<Shipment>
    fun createShipment(orderId: String): Shipment
}