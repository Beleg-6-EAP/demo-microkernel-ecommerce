package demo.model

import jakarta.persistence.*

@Entity
@Table(name="shipments")
data class Shipment(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = "",
    val orderId: String = "",
    val trackingId: String = "",
)
