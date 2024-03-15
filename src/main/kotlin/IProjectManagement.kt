package org.example

import java.util.Date
import java.util.UUID

/**
 * This interface represents the project management operations.
 */
interface IProjectManagement {
    /**
     * Creates a new project.
     *
     * @param name The name of the project.
     * @param description The description of the project.
     * @param dateStart The start date of the project.
     * @return The created project.
     */
    fun createProject(name: String, description: String, dateStart: Date): Project

    /**
     * Assigns a team to a project.
     *
     * @param team The team to assign.
     * @param project The project to which the team is assigned.
     */
    fun asignTeamToProyect(team: Team<Employee>, project: Project)

    /**
     * Adds a task to a project and assigns it to an employee.
     *
     * @param task The task to add.
     * @param project The project to which the task is added.
     * @param idEmployee The id of the employee to whom the task is assigned.
     */
    fun addTaskToProject(task: Task, project: Project, idEmployee: UUID)
}