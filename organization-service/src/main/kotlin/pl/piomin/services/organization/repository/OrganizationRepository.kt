package pl.piomin.services.organization.repository

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import pl.piomin.services.organization.model.Organization

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
class OrganizationRepository(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) {

    @Transactional
    fun add(organization: Organization): Organization {
        entityManager.persist(organization)
        return organization
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Organization = entityManager.find(Organization::class.java, id)

    @Transactional(readOnly = true)
    fun findAll(): List<Organization> = entityManager.createQuery("SELECT o FROM Organization o").resultList as List<Organization>

}
