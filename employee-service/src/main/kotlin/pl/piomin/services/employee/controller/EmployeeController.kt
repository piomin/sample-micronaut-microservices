package pl.piomin.services.employee.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.tracing.annotation.ContinueSpan
import io.micronaut.tracing.annotation.SpanTag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.piomin.services.employee.model.Employee
import pl.piomin.services.employee.repository.EmployeeRepository

import javax.inject.Inject

@Controller("/employees")
open class EmployeeController(private val logger: Logger = LoggerFactory.getLogger(EmployeeController::class.java)) {

    @Inject
    lateinit var repository: EmployeeRepository

    @Post
    fun add(@Body employee: Employee): Employee {
        logger.info("Employee add: {}", employee)
        return repository.add(employee)
    }

    @Get("/{id}")
    fun findById(id: Long): Employee? {
        logger.info("Employee find: id={}", id)
        return repository.findById(id)
    }

    @Get
    fun findAll(): List<Employee> {
        logger.info("Employees find")
        return repository.findAll()
    }

    @Get("/department/{departmentId}")
    @ContinueSpan
    open fun findByDepartment(@SpanTag("departmentId") departmentId: Long): List<Employee> {
        logger.info("Employees find: departmentId={}", departmentId)
        return repository.findByDepartment(departmentId)
    }

    @Get("/organization/{organizationId}")
    @ContinueSpan
    open fun findByOrganization(@SpanTag("organizationId") organizationId: Long): List<Employee> {
        logger.info("Employees find: organizationId={}", organizationId)
        return repository.findByOrganization(organizationId)
    }

}
