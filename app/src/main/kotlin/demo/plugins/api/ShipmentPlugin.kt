package demo.plugins.api

import demo.model.Order
import demo.model.Shipment

interface ShipmentPlugin : Plugin {
    fun shipOrder(order: Order): Shipment
    fun getAllShipments(): List<Shipment>
}