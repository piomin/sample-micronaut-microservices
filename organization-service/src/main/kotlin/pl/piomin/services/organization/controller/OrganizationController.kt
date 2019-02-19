package pl.piomin.services.organization.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.piomin.services.organization.client.DepartmentClient
import pl.piomin.services.organization.client.EmployeeClient
import pl.piomin.services.organization.model.Organization
import pl.piomin.services.organization.repository.OrganizationRepository

import javax.inject.Inject

@Controller("/organizations")
class OrganizationController(private val logger: Logger = LoggerFactory.getLogger(OrganizationController::class.java)) {

    @Inject
    lateinit var repository: OrganizationRepository
    @Inject
    lateinit var departmentClient: DepartmentClient
    @Inject
    lateinit var employeeClient: EmployeeClient

    @Post
    fun add(@Body organization: Organization): Organization {
        logger.info("Organization add: {}", organization)
        return repository.add(organization)
    }

    @Get
    fun findAll(): List<Organization> {
        logger.info("Organization find")
        return repository.findAll()
    }

    @Get("/{id}")
    fun findById(id: Long): Organization? {
        logger.info("Organization find: id={}", id)
        return repository.findById(id)
    }

    @Get("/{id}/with-departments")
    fun findByIdWithDepartments(id: Long): Organization? {
        logger.info("Organization find: id={}", id)
        val organization = repository.findById(id)
        if (organization != null)
            organization.departments = departmentClient.findByOrganization(organization.id)
        return organization
    }

    @Get("/{id}/with-departments-and-employees")
    fun findByIdWithDepartmentsAndEmployees(id: Long): Organization? {
        logger.info("Organization find: id={}", id)
        val organization = repository.findById(id)
        if (organization != null)
            organization.departments = departmentClient.findByOrganizationWithEmployees(organization.id)
        return organization
    }

    @Get("/{id}/with-employees")
    fun findByIdWithEmployees(id: Long): Organization? {
        logger.info("Organization find: id={}", id)
        val organization = repository.findById(id)
        if (organization != null)
            organization.employees = employeeClient.findByOrganization(organization.id)
        return organization
    }


}
