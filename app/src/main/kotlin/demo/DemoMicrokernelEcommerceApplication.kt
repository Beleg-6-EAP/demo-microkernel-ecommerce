package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoMicrokernelEcommerceApplication

fun main(args: Array<String>) {
    runApplication<DemoMicrokernelEcommerceApplication>(*args)
}
