package pl.piomin.services.employee.repository

import pl.piomin.services.employee.model.Employee
import javax.inject.Singleton

@Singleton
class EmployeeRepository(val employees: MutableList<Employee> = mutableListOf()) {

    fun add(employee: Employee): Employee {
        employee.id = (employees.size + 1).toLong()
        employees.add(employee)
        return employee
    }

    fun findById(id: Long): Employee? = employees.firstOrNull { it.id == id }

    fun findAll(): List<Employee> = employees

    fun findByDepartment(departmentId: Long): List<Employee> = employees.filter { it.departmentId == departmentId }

    fun findByOrganization(organizationId: Long): List<Employee> = employees.filter { it.organizationId == organizationId }

}
