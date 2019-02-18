package pl.piomin.services.department

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = Info(
                title = "Departments Management",
                version = "1.0",
                description = "Department API",
                contact = Contact(url = "https://piotrminkowski.wordpress.com", name = "Piotr Mińkowski", email = "piotr.minkowski@gmail.com")
        )
)
open class DepartmentApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Micronaut.run(DepartmentApplication::class.java)
        }
    }
}

//fun main(args: Array<String>) {
//    Micronaut.run(DepartmentApplication::class.java)
//}
