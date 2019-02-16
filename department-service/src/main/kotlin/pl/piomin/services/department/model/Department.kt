package pl.piomin.services.department.model;

data class Department(var id: Long, var organizationId: Long, var name: String) {

    var employees: MutableList<Employee> = mutableListOf()

}
