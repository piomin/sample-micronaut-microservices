package pl.piomin.services.employee

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = Info(
                title = "Employees Management",
                version = "1.0",
                description = "Employee API",
                contact = Contact(url = "https://piotrminkowski.wordpress.com", name = "Piotr Mińkowski", email = "piotr.minkowski@gmail.com")
        )
)
class EmployeeApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Micronaut.run(EmployeeApplication::class.java)
        }
    }

}