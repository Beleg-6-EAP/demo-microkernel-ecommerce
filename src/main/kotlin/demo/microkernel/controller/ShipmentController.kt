package demo.microkernel.controller

import demo.microkernel.model.Shipment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/shipments")
class ShipmentController {

    @GetMapping
    fun getAllShipments(): ResponseEntity<List<Shipment>> {
        return ResponseEntity.ok(listOf())
    }
}