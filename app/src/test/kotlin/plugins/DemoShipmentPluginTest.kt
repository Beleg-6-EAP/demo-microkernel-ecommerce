package plugins

import demo.model.Order
import demo.model.Shipment
import demo.plugins.shipment.DemoShipmentPlugin
import demo.plugins.shipment.internal.ShipmentRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class DemoShipmentPluginTest {

    private val shipmentRepository: ShipmentRepository = mock(ShipmentRepository::class.java)
    private val demoShipmentPlugin = DemoShipmentPlugin(shipmentRepository)

    @Test
    fun shipOrder_savesShipmentSuccessfully() {
        val order = Order("1", "item1")
        val shipment = Shipment(orderId = order.id)
        `when`(shipmentRepository.save(any(Shipment::class.java))).thenReturn(shipment)

        val result = demoShipmentPlugin.shipOrder(order)

        verify(shipmentRepository, times(1)).save(any(Shipment::class.java))
        assertEquals(shipment, result)
    }


    @Test
    fun getAllShipments_returnsListOfShipments() {
        val shipments = listOf(Shipment("1", "23"), Shipment("2", "34"))
        `when`(shipmentRepository.findAll()).thenReturn(shipments)

        val result = demoShipmentPlugin.getAllShipments()

        assertEquals(shipments, result)
    }

    @Test
    fun getAllShipments_whenNoShipments_returnsEmptyList() {
        `when`(shipmentRepository.findAll()).thenReturn(emptyList())

        val result = demoShipmentPlugin.getAllShipments()

        assertEquals(emptyList<Shipment>(), result)
    }
}