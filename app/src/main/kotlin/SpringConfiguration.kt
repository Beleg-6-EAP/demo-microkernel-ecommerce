
import org.pf4j.spring.SpringPluginManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import providers.PaymentProviders

@Configuration
class SpringConfiguration {
    @Bean
    fun pluginManager(): SpringPluginManager {
        return SpringPluginManager()
    }

    @Bean
    @DependsOn("pluginManager")
    fun paymentProviders(): PaymentProviders {
        return PaymentProviders()
    }
}