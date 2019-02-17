package pl.piomin.services.organization.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import pl.piomin.services.organization.model.Employee

@Client(id = "employee-service", path = "/employees")
interface EmployeeClient {

    @Get("/organization/{organizationId}")
    fun findByOrganization(organizationId: Long): MutableList<Employee>

}
