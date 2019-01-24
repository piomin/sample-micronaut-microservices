package pl.piomin.services.organization.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.services.organization.client.DepartmentClient;
import pl.piomin.services.organization.client.EmployeeClient;
import pl.piomin.services.organization.model.Organization;
import pl.piomin.services.organization.repository.OrganizationRepository;

import javax.inject.Inject;
import java.util.List;

@Controller("/organizations")
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	@Inject
	OrganizationRepository repository;
	@Inject
	DepartmentClient departmentClient;
	@Inject
	EmployeeClient employeeClient;
	
	@Post
	public Organization add(@Body Organization organization) {
		LOGGER.info("Organization add: {}", organization);
		return repository.add(organization);
	}
	
	@Get
	public List<Organization> findAll() {
		LOGGER.info("Organization find");
		return repository.findAll();
	}
	
	@Get("/{id}")
	public Organization findById(Long id) {
		LOGGER.info("Organization find: id={}", id);
		return repository.findById(id);
	}

	@Get("/{id}/with-departments")
	public Organization findByIdWithDepartments(Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
		return organization;
	}
	
	@Get("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
		return organization;
	}
	
	@Get("/{id}/with-employees")
	public Organization findByIdWithEmployees(Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
		return organization;
	}
	
}
