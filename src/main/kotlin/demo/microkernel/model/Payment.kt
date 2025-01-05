package demo.microkernel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,
    var orderId: String,
    var success: Boolean,
) {
        constructor() : this(null, "", false)
}
