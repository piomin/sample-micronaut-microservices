package pl.piomin.services.department.model

import javax.persistence.*

@Entity
data class Department(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq") @SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq") var id: Long,
                      var organizationId: Long, var name: String) {

    @Transient
    var employees: MutableList<Employee> = mutableListOf()

}
