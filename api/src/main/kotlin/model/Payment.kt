package demo.microkernel.model

data class Payment (
    private val id: String,
    private val orderId: String,
    private val success: Boolean,
)

