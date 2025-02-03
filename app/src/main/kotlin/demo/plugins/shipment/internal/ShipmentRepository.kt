package demo.plugins.shipment.internal

import demo.model.Shipment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShipmentRepository: JpaRepository<Shipment, String>