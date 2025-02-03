package demo.model

import jakarta.persistence.*

@Entity
@Table(name="payments")
data class Payment(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = "",
    val orderId: String = "",
    val success: Boolean = true,
)