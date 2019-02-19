package pl.piomin.services.organization.model;

import javax.persistence.*

@Entity
data class Organization(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq") @SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq") var id: Long,
                        var name: String, var address: String) {

    @Transient
    var departments: MutableList<Department> = mutableListOf()
    @Transient
    var employees: MutableList<Employee> = mutableListOf()

}