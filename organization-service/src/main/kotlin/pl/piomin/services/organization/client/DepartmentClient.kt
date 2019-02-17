package pl.piomin.services.organization.client

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import pl.piomin.services.organization.model.Department

@Client(id = "department-service", path = "/departments")
interface DepartmentClient {

    @Get("/organization/{organizationId}")
    fun findByOrganization(organizationId: Long): MutableList<Department>

    @Get("/organization/{organizationId}/with-employees")
    fun findByOrganizationWithEmployees(organizationId: Long): MutableList<Department>

}
