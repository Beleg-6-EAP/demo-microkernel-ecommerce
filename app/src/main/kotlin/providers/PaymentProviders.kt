package providers

import demo.microkernel.PaymentProvider

class PaymentProviders(
    private val providers: List<PaymentProvider>
) {

    fun getProvider(): PaymentProvider {
        // Custom logic to select a provider could be placed here
        return providers.first()
    }
}