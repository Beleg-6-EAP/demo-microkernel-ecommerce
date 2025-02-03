package demo.plugins.shipment

import demo.model.Order
import demo.model.Shipment
import demo.plugins.api.ShipmentPlugin
import demo.plugins.shipment.internal.ShipmentRepository
import org.springframework.stereotype.Service

@Service
class DemoShipmentPlugin(
    private val shipmentRepository: ShipmentRepository,
) : ShipmentPlugin {

    override fun getName(): String = "DemoShipmentPlugin"

    override fun shipOrder(order: Order): Shipment {
        val shipment = Shipment(orderId = order.id)
        shipmentRepository.save(shipment)
        return shipment
    }

    override fun getAllShipments(): List<Shipment> {
        return shipmentRepository.findAll()
    }
}