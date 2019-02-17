package pl.piomin.services.organization.model;

data class Organization(var id: Long, var name: String, var address: String,
                        var departments: MutableList<Department> = mutableListOf(),
                        var employees: MutableList<Employee> = mutableListOf())