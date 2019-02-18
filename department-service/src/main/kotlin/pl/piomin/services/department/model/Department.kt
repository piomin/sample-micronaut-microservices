package pl.piomin.services.department.model;

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Department(@Id var id: Long, var organizationId: Long, var name: String) {

    @Transient
    var employees: MutableList<Employee> = mutableListOf()

}
