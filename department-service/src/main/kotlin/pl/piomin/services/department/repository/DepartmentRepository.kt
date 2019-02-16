package pl.piomin.services.department.repository

import pl.piomin.services.department.model.Department

import javax.inject.Singleton

@Singleton
class DepartmentRepository(private val departments: MutableList<Department> = mutableListOf()) {

    fun add(department: Department): Department {
        department.id = (departments.size + 1).toLong()
        departments.add(department)
        return department
    }

    fun findById(id: Long) = departments.firstOrNull { it.id == id }

    fun findAll(): List<Department> = departments

    fun findByOrganization(organizationId: Long) = departments.filter { it.organizationId == organizationId }

}
