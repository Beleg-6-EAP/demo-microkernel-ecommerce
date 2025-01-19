package providers

import demo.microkernel.PaymentProvider
import org.springframework.beans.factory.annotation.Autowired

class PaymentProviders {

    @Autowired
    private lateinit var providers: List<PaymentProvider>

    fun getProvider(): PaymentProvider {
        // Custom logic to select a provider could be placed here
        return providers.first()
    }
}