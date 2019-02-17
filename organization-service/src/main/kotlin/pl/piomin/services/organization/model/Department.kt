package pl.piomin.services.organization.model;

data class Department(var id: Long, var name: String, var employees: MutableList<Employee> = mutableListOf())