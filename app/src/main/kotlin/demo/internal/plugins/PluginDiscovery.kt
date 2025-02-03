package demo.internal.plugins

import demo.plugins.api.PaymentPlugin
import demo.plugins.api.ShipmentPlugin
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class PluginDiscovery(
    private val pluginRegistry: PluginRegistry,
    private val applicationContext: ApplicationContext
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        // Scan for demo.plugins.api.PaymentPlugin implementations
        val paymentPlugins = applicationContext.getBeansOfType(PaymentPlugin::class.java).values
        paymentPlugins.forEach { pluginRegistry.registerPlugin(it) }

        // Scan for demo.plugins.api.ShipmentPlugin implementations
        val shipmentPlugins = applicationContext.getBeansOfType(ShipmentPlugin::class.java).values
        shipmentPlugins.forEach { pluginRegistry.registerPlugin(it) }

        println("Discovered plugins: ${pluginRegistry.getAllPlugins()}")
    }
}