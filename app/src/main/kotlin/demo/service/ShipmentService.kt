package demo.service

import demo.internal.plugins.PluginRegistry
import demo.model.Shipment
import demo.plugins.api.ShipmentPlugin
import org.springframework.stereotype.Service

@Service
class ShipmentService(
    private val pluginRegistry: PluginRegistry
) {
    fun getAllShipments(): List<Shipment> {
        val shipmentPlugin = pluginRegistry.getAllPlugins()
            .filterIsInstance<ShipmentPlugin>()
            .firstOrNull() ?: throw IllegalStateException("No shipment plugin found")

        return shipmentPlugin.getAllShipments()
    }
}