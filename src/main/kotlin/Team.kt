package org.example

/**
 * This class represents a team of employees.
 *
 * @param T The type of employees in the team. It must be a subtype of Employee.
 * @property name The name of the team.
 * @property description A description of the team.
 */
class Team<T : Employee>(
    private val name: String,
    private val description: String,
) {

    /**
     * The list of employees in the team.
     */
    val employees: MutableList<T> = mutableListOf()

    companion object {
        /**
         * The list of all teams.
         */
        val teams: MutableList<Team<Employee>> = mutableListOf()

        /**
         * Creates a new team and adds it to the list of teams.
         *
         * @param name The name of the new team.
         * @param description A description of the new team.
         * @return The newly created team.
         */
        fun createTeam(name: String, description: String): Team<Employee> {
            val team = Team<Employee>(name, description)
            teams.add(team)
            return team
        }
    }

    /**
     * Adds an employee to the team.
     *
     * @param employee The employee to add.
     */
    fun addEmployee(employee: T) {
        employees.add(employee)
    }

    /**
     * Removes an employee from the team.
     *
     * @param employee The employee to remove.
     */
    fun removeEmployee(employee: T) {
        employees.remove(employee)
    }

    /**
     * Lists all employees in the team.
     *
     * @return A list of all employees in the team.
     */
    fun listEmployee(): List<T> {
        return employees.toList()
    }

    /**
     * Gets the name of the team.
     *
     * @return The name of the team.
     */
    fun getName(): String {
        return name
    }

    /**
     * Returns a string representation of the team.
     *
     * @return A string representation of the team.
     */
    override fun toString(): String {
        return "Team $name | \nDescription:$description"
    }
}