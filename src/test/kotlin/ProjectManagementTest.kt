package org.example

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.time.LocalDate

class ProjectManagementTest {

    @BeforeEach
    fun setup() {
        println("TEST 1")
    }

    @Test
    fun createProject() {

        val projectManagement = ProjectManagement()
        val name = "Test Project"
        val description = "This is a test project"
        val dateStart = java.sql.Date.valueOf(LocalDate.of(2000, 10, 5))



        val project = projectManagement.createProject(name, description, dateStart)

        assertEquals(name, project.getName())
        assertEquals(description, project.getDescription())
        assertEquals(dateStart, project.getDate())
        assertTrue(projectManagement.openProjects.contains(project))
    }

}