package org.example

/**
 * This interface represents a manager for a project.
 */
interface ProjectManager {
    /**
     * Adds a task to the project and assigns it to an employee.
     *
     * @param task The task to add.
     * @param employee The employee to assign to the task.
     */
    fun addTask(task: Task, employee: Employee)

    /**
     * Assigns a team to the project.
     *
     * @param team The team to assign.
     */
    fun assignTeam(team: Team<Employee>)

    /**
     * Lists all tasks in the project.
     *
     * @return A list of all tasks in the project, or null if there are no tasks.
     */
    fun listTasks(): List<Task>?

    /**
     * Lists all teams assigned to the project.
     *
     * @return A list of all teams assigned to the project, or null if there are no teams.
     */
    fun listTeams(): List<Team<Employee>>?

    /**
     * Gets the name of the project.
     *
     * @return The name of the project.
     */
    fun getName(): String

}