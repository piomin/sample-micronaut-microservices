package pl.piomin.services.department.client;

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import pl.piomin.services.department.model.Employee

@Client(id = "employee-service", path = "/employees")
interface EmployeeClient {

	@Get("/department/{departmentId}")
	fun findByDepartment(departmentId: Long): MutableList<Employee>
	
}
