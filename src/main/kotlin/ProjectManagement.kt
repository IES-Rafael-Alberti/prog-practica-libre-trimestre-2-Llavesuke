package org.example

import java.util.*

class ProjectManagement: IProjectManagement {
    val openProjects = mutableListOf<Project>()

    override fun createProject(name: String, description: String, dateStart: Date): Project {
        val project = Project(name, description, dateStart)
        openProjects.add(project)
        return project
    }

    override fun addTaskToProject(task: Task, project: Project, idEmployee: UUID) {
        if (project !in openProjects) {
            Utils.showMessage("The project is not in the system")

        } else  {
            if (project.listTeams() == null){
                Utils.showMessage("The project has no teams")
            } else {
                val employee = project.listTeams()?.flatMap { it.employees }?.find { it.getId() == idEmployee }
                if (employee != null) {
                    project.addTask(task, employee)
                    task.updateEmployee(employee)
                } else {
                    Utils.showMessage("The team is not in the project")
                }
            }
        }
    }

    override fun asignTeamToProyect(team: Team<Employee>, proyect: Project) {
        if (proyect !in openProjects) {
            Utils.showMessage("The project is not in the system")
        } else {
            proyect.assignTeam(team)
        }
    }
}