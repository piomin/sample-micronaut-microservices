package pl.piomin.services.employee.repository

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import pl.piomin.services.employee.model.Employee
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class EmployeeRepository(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) {

    @Transactional
    open fun add(employee: Employee): Employee {
        entityManager.persist(employee)
        return employee
    }

    @Transactional(readOnly = true)
    open fun findById(id: Long): Employee = entityManager.find(Employee::class.java, id)

    @Transactional(readOnly = true)
    open fun findAll(): List<Employee> = entityManager.createQuery("SELECT e FROM Employee e").resultList as List<Employee>

    @Transactional(readOnly = true)
    open fun findByDepartment(departmentId: Long): List<Employee> = entityManager.createQuery("SELECT e FROM Employee e WHERE e.departmentId = :depId")
            .setParameter("depId", departmentId)
            .resultList as List<Employee>

    @Transactional(readOnly = true)
    open fun findByOrganization(organizationId: Long): List<Employee> = entityManager.createQuery("SELECT e FROM Employee e WHERE e.organizationId = :orgId")
            .setParameter("orgId", organizationId)
            .resultList as List<Employee>

}
