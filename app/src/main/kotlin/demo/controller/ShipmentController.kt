package demo.controller

import demo.model.Shipment
import demo.service.ShipmentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/shipments")
class ShipmentController(
    private val shipmentService: ShipmentService
) {

    @GetMapping
    fun getAllShipments(): ResponseEntity<List<Shipment>> {
        val shipments = shipmentService.getAllShipments()
        return ResponseEntity.ok(shipments)
    }
}