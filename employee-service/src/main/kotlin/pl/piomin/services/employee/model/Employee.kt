package pl.piomin.services.employee.model;

data class Employee(var id: Long, var organizationId: Long, var departmentId: Long, var name: String, var age: Int, var position: String)