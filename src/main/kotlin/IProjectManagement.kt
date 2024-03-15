package org.example

import java.util.Date
import java.util.UUID

interface IProjectManagement {
    fun createProject(name: String, description: String, dateStart: Date): Project
    fun asignTeamToProyect(team: Team<Employee>, proyect: Project)
    fun addTaskToProject(task: Task, project: Project, idEmployee: UUID)
}