package demo.microkernel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Shipment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,
    var orderId: String,
    var trackingId: String,
) {
    constructor() : this(null, "", "")
}
