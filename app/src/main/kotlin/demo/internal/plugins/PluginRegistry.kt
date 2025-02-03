package demo.internal.plugins

import demo.plugins.api.Plugin
import org.springframework.stereotype.Component

@Component
class PluginRegistry {
    private val plugins = mutableMapOf<String, Plugin>()

    fun registerPlugin(plugin: Plugin) {
        plugins[plugin.getName()] = plugin
    }

    fun getPlugin(name: String): Plugin? {
        return plugins[name]
    }

    fun getAllPlugins(): List<Plugin> {
        return plugins.values.toList()
    }
}