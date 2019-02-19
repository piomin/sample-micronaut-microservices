package pl.piomin.services.department.controller;

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.tracing.annotation.ContinueSpan
import io.micronaut.tracing.annotation.SpanTag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.piomin.services.department.client.EmployeeClient
import pl.piomin.services.department.model.Department
import pl.piomin.services.department.repository.DepartmentRepository

import javax.inject.Inject

@Controller("/departments")
open class DepartmentController(private val logger: Logger = LoggerFactory.getLogger(DepartmentController::class.java)) {

    @Inject
    lateinit var repository: DepartmentRepository
    @Inject
    lateinit var employeeClient: EmployeeClient

    @Post
    fun add(@Body department: Department): Department {
        logger.info("Department add: {}", department)
        return repository.add(department)
    }

    @Get("/{id}")
    fun findById(id: Long): Department? {
        logger.info("Department find: id={}", id)
        return repository.findById(id)
    }

    @Get
    fun findAll(): List<Department> {
        logger.info("Department find")
        return repository.findAll()
    }

    @Get("/organization/{organizationId}")
    @ContinueSpan
    open fun findByOrganization(@SpanTag("organizationId") organizationId: Long): List<Department> {
        logger.info("Department find: organizationId={}", organizationId)
        return repository.findByOrganization(organizationId)
    }

    @Get("/organization/{organizationId}/with-employees")
    @ContinueSpan
    open fun findByOrganizationWithEmployees(@SpanTag("organizationId") organizationId: Long): List<Department> {
        logger.info("Department find: organizationId={}", organizationId)
        val departments = repository.findByOrganization(organizationId)
        departments.forEach { it.employees = employeeClient.findByDepartment(it.id) }
        return departments
    }

}
