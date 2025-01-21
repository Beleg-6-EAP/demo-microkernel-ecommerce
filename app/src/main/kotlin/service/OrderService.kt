package service

import demo.SpringConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Service
import providers.PaymentProviders

@Service
class OrderService {

    init {
        val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(SpringConfiguration::class.java)
        val paymentProviders: PaymentProviders = applicationContext.getBean(PaymentProviders::class.java)
    }

    fun getAllOrders() {

    }
}