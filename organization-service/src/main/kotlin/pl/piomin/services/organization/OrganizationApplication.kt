package pl.piomin.services.organization;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = Info(
                title = "Organizations Management",
                version = "1.0",
                description = "Organization API",
                contact = Contact(url = "https://piotrminkowski.wordpress.com", name = "Piotr Mińkowski", email = "piotr.minkowski@gmail.com")
        )
)
class OrganizationApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Micronaut.run(OrganizationApplication::class.java)
        }
    }

}