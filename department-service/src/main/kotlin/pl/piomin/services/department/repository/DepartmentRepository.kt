package pl.piomin.services.department.repository

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import pl.piomin.services.department.model.Department
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class DepartmentRepository {

    @Inject
    @CurrentSession
    private lateinit var entityManager: EntityManager

    @Transactional
    open fun add(department: Department): Department {
        entityManager.persist(department)
        return department
    }

    fun findById(id: Long): Department = entityManager.find(Department::class.java, id)

    fun findAll(): List<Department> = entityManager.createQuery("SELECT d FROM Department d").resultList as List<Department>

    fun findByOrganization(organizationId: Long) = entityManager.createQuery("SELECT d FROM Department d WHERE d.organizationId = :orgId")
            .setParameter("orgId", organizationId)
            .resultList as List<Department>

}
