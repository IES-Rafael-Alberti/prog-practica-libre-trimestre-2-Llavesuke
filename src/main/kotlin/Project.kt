package org.example

import jdk.jshell.execution.Util
import java.util.Date

class Project(
    private val name: String,
    private val description: String,
    private val startDate: Date,
    private val tasks: MutableList<Task> = mutableListOf(),
    private val state: ProjectState = ProjectState.ACTIVE,
    private val teams: MutableList<Team<Employee>> = mutableListOf()): ProjectManager{

    override fun addTask(task: Task,employee: Employee) {
        if (employee in teams.flatMap { it.employees }) {
             tasks.add(task)
             employee.changeAssignedTasks(task)
        } else {
            Utils.showMessage("The employee is not part of the proyect")
        }

    }

    override fun assignTeam(team: Team<Employee>) {
        if (team !in teams) {
            teams.add(team)
        } else {
            Utils.showMessage("The employee is already part of the proyect")
        }
    }

    override fun listTasks(): List<Task>? {
        if (tasks.isEmpty()) {
            Utils.showMessage("There are no tasks in the proyect")
            return null
        } else {
            return tasks.toList()
        }
    }

    override fun listTeams(): List<Team<Employee>>? {
        return teams.toList() ?: null
    }

    override fun calculateProgress() {
        val tareasCompletadas = tasks.count { it.getState() == TaskState.COMPLETED }
        val totalTareas = tasks.size
        if (totalTareas > 0) {
            val progress= (tareasCompletadas.toDouble() / totalTareas.toDouble()) * 100
            Utils.printProgressBar(progress)
        } else {
            Utils.showMessage("There are no tasks in the proyect")
        }
    }

    override fun getName(): String {
        return name
    }
}