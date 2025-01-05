package demo.microkernel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "`order`")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,
    var userId: String,
    var amount: Double,
    var status: String,
) {
    constructor() : this(null, "", 0.toDouble(), "")
}
