package org.example

import java.util.Date

/**
 * This class represents a project in the project management system.
 *
 * @property name The name of the project.
 * @property description A description of the project.
 * @property startDate The start date of the project.
 * @property tasks The list of tasks in the project.
 * @property state The current state of the project. It is initially set to ACTIVE.
 * @property teams The list of teams assigned to the project.
 */
class Project(
    private val name: String,
    private val description: String,
    private val startDate: Date,
    private val tasks: MutableList<Task> = mutableListOf(),
    private val teams: MutableList<Team<Employee>> = mutableListOf()): ProjectManager{

    /**
     * Adds a task to the project and assigns it to an employee.
     *
     * @param task The task to add.
     * @param employee The employee to assign to the task.
     */
    override fun addTask(task: Task,employee: Employee) {
        if (employee in Employee.employees) {
            tasks.add(task)
            employee.changeAssignedTasks(task)
        } else {
            Utils.showMessage("The employee is not part of the project")
        }
    }

    /**
     * Assigns a team to the project.
     *
     * @param team The team to assign.
     */
    override fun assignTeam(team: Team<Employee>) {
        if (team !in teams) {
            teams.add(team)
        } else {
            Utils.showMessage("The team is already part of the project")
        }
    }

    /**
     * Lists all tasks in the project.
     *
     * @return A list of all tasks in the project, or null if there are no tasks.
     */
    override fun listTasks(): List<Task>? {
        if (tasks.isEmpty()) {
            Utils.showMessage("There are no tasks in the project")
            return null
        } else {
            return tasks.toList()
        }
    }

    /**
     * Lists all teams assigned to the project.
     *
     * @return A list of all teams assigned to the project, or null if there are no teams.
     */
    override fun listTeams(): List<Team<Employee>> {
        return teams.toList()
    }

    /**
     * Gets the name of the project.
     *
     * @return The name of the project.
     */
    override fun getName(): String {
        return name
    }

    override fun getDescription(): String{
        return description
    }

    override fun getDate(): Date {
        return startDate
    }

    override fun toString(): String {
        return "Project $name \nDescription:$description | Start Date:$startDate"
    }
}