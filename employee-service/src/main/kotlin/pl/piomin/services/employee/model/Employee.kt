package pl.piomin.services.employee.model;

import javax.persistence.*

@Entity
data class Employee(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq") @SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq") var id: Long,
                    var organizationId: Long, var departmentId: Long, var name: String, var age: Int, var position: String)