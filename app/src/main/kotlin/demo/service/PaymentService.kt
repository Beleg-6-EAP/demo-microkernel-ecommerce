package demo.service

import demo.internal.plugins.PluginRegistry
import demo.model.Payment
import demo.plugins.api.PaymentPlugin
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val pluginRegistry: PluginRegistry
) {
    fun getAllPayments(): List<Payment> {
        val paymentPlugin = pluginRegistry.getAllPlugins()
            .filterIsInstance<PaymentPlugin>()
            .firstOrNull() ?: throw IllegalStateException("No payment plugin found")

        return paymentPlugin.getAllPayments()
    }
}