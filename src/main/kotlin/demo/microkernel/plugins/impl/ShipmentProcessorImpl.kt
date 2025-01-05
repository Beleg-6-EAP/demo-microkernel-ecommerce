package demo.microkernel.plugins.impl

import demo.microkernel.plugins.api.ShipmentProcessor
import org.springframework.stereotype.Service

@Service
class ShipmentProcessorImpl : ShipmentProcessor {
    override fun processShipment(orderId: String) {
//        TODO("Not yet implemented")
    }
}