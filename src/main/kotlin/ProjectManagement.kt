package org.example

import java.util.*

/**
 * This class represents the project management system.
 * It implements the IProjectManagement interface.
 *
 * @property openProjects The list of open projects in the system.
 */
class ProjectManagement: IProjectManagement {
    val openProjects = mutableListOf<Project>()

    /**
     * Creates a new project and adds it to the list of open projects.
     *
     * @param name The name of the new project.
     * @param description A description of the new project.
     * @param dateStart The start date of the new project.
     * @return The newly created project.
     */
    override fun createProject(name: String, description: String, dateStart: Date): Project {
        val project = Project(name, description, dateStart)
        openProjects.add(project)
        return project
    }

    /**
     * Adds a task to a project.
     *
     * @param task The task to add.
     * @param project The project to which the task will be added.
     * @param idEmployee The ID of the employee who will be assigned to the task.
     */
    override fun addTaskToProject(task: Task, project: Project, idEmployee: UUID) {
        if (project !in openProjects) {
            Utils.showMessage("The project is not in the system")
        } else  {
            if (project.listTeams().isEmpty()){
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

    /**
     * Assigns a team to a project.
     *
     * @param team The team to assign.
     * @param proyect The project to which the team will be assigned.
     */
    override fun asignTeamToProyect(team: Team<Employee>, proyect: Project) {
        if (proyect !in openProjects) {
            Utils.showMessage("The project is not in the system")
        } else {
            proyect.assignTeam(team)
        }
    }
}