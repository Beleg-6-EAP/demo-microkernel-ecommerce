package demo.microkernel.repository

import demo.microkernel.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository: CrudRepository<Order, String>