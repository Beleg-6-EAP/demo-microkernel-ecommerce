package demo.microkernel.repository

import demo.microkernel.model.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository: CrudRepository<Payment, String>