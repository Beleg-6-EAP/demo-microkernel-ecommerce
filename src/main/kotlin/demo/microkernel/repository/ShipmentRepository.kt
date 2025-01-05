package demo.microkernel.repository

import demo.microkernel.model.Shipment
import org.springframework.data.repository.CrudRepository

interface ShipmentRepository: CrudRepository<Shipment, String>