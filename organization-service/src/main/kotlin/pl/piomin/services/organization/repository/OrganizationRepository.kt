package pl.piomin.services.organization.repository

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import pl.piomin.services.organization.model.Organization

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class OrganizationRepository(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) {

    @Transactional
    open fun add(organization: Organization): Organization {
        entityManager.persist(organization)
        return organization
    }

    @Transactional(readOnly = true)
    open fun findById(id: Long): Organization = entityManager.find(Organization::class.java, id)

    @Transactional(readOnly = true)
    open fun findAll(): List<Organization> = entityManager.createQuery("SELECT o FROM Organization o").resultList as List<Organization>

}
