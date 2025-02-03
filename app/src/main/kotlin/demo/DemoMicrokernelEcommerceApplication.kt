package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class DemoMicrokernelEcommerceApplication

fun main(args: Array<String>) {
    runApplication<DemoMicrokernelEcommerceApplication>(*args)
}
