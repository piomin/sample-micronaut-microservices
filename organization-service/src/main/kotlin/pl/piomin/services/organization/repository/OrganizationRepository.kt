package pl.piomin.services.organization.repository

import pl.piomin.services.organization.model.Organization

import javax.inject.Singleton

@Singleton
class OrganizationRepository(private val organizations: MutableList<Organization> = mutableListOf()) {


    fun add(organization: Organization): Organization {
        organization.id = (organizations.size + 1).toLong()
        organizations.add(organization)
        return organization
    }

    fun findById(id: Long): Organization? = organizations.firstOrNull { it.id == id }

    fun findAll(): List<Organization> = organizations

}
