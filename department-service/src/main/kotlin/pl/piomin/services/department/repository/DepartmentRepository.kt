package pl.piomin.services.department.repository

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import pl.piomin.services.department.model.Department
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class DepartmentRepository(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) {

    @Transactional
    open fun add(department: Department): Department {
        entityManager.persist(department)
        return department
    }

    @Transactional(readOnly = true)
    open fun findById(id: Long): Department = entityManager.find(Department::class.java, id)

    @Transactional(readOnly = true)
    open fun findAll(): List<Department> = entityManager.createQuery("SELECT d FROM Department d").resultList as List<Department>

    @Transactional(readOnly = true)
    open fun findByOrganization(organizationId: Long) = entityManager.createQuery("SELECT d FROM Department d WHERE d.organizationId = :orgId")
            .setParameter("orgId", organizationId)
            .resultList as List<Department>

}
