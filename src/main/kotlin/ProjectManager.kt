package org.example

interface ProjectManager {
    fun addTask(task: Task, employee: Employee)
    fun assignTeam(team: Team<Employee>)
    fun listTasks(): List<Task>?
    fun calculateProgress()
    fun listTeams(): List<Team<Employee>>?

    fun getName(): String
}
