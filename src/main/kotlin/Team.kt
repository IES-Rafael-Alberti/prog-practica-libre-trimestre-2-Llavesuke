package org.example

class Team<T : Employee>(
    private val name: String,
    private val description: String,
) {

    val employees: MutableList<T> = mutableListOf()

    companion object {
        val teams: MutableList<Team<Employee>> = mutableListOf()

        fun createTeam(name: String, description: String): Team<Employee> {
            val team = Team<Employee>(name, description)
            teams.add(team)
            return team
        }
    }
    fun addEmployee(employee: T) {
        employees.add(employee)
    }

    fun removeEmployee(employee: T) {
        employees.remove(employee)
    }

    fun listarEmpleados(): List<T> {
        return employees.toList()
    }

    fun getName(): String {
        return name
    }

    override fun toString(): String {
        return "Team $name | \nDescription:$description"
    }
}
