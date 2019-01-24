package pl.piomin.services.organization.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import pl.piomin.services.organization.model.Employee;

import java.util.List;

@Client(id = "employee-service", path = "/employees")
public interface EmployeeClient {

	@Get("/organization/{organizationId}")
	List<Employee> findByOrganization(Long organizationId);
	
}
