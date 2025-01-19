package demo.microkernel.model

data class Order(
    var id: String,
    var userId: String,
    var amount: Double,
    var status: String,
)
