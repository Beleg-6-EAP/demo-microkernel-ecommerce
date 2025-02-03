package demo.model

import jakarta.persistence.*

@Entity
@Table(name="orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = "",
    val userId: String = "",
    val amount: Double = 0.0,
    val status: String = "",
)