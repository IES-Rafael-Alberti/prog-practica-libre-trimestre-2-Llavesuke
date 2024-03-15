package org.example

import java.util.*

/**
 * This class represents the secondary menus of the application.
 * It contains methods to handle the logic for each secondary menu.
 */
class SecondaryMenus {

    /**
     * Displays the "Create New Records" menu and handles user input.
     */
    fun createNewRecordsMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. Create new project
            2. Create new team
            3. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    val name = Utils.stringInput("Enter project name: ")
                    val description = Utils.stringInput("Enter project description: ")
                    val dateStart = Utils.insertDate()
                    MainMenu.projectManagement.createProject(name, description, dateStart)
                    Utils.showMessage("Project created successfully.")
                }
                "2" -> {
                    val teamName = Utils.stringInput("Enter team name: ")
                    val teamDescription = Utils.stringInput("Enter team description: ")
                    Team.createTeam(teamName, teamDescription)
                    Utils.showMessage("Team created successfully.")
                }
                "3" -> {
                    Utils.showMessage("Returning to main menu...")
                    repeat(100){
                        Utils.showMessage("\n")
                    }
                    MainMenu.showMenu()
                }
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "5")
    }

    /**
     * Displays the "Projects" menu and handles user input.
     */
    fun projectsMenu() {
        var option: String
        do {
            Utils.showMessage(
                """
            1. Add task to project
            2. Assign team to project
            3. List all projects
            4. Change task state
            4. Back to main menu
        """.trimIndent()
            )
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    try {
                        if (MainMenu.projectManagement.openProjects.isEmpty()) {
                            Utils.showMessage("There are no projects created.")
                        } else {
                            val projectName = Utils.stringInput("Enter project name: ")
                            val taskName = Utils.stringInput("Enter task name: ")
                            val taskDescription = Utils.stringInput("Enter task description: ")
                            val taskStartDate = Utils.insertDate()
                            val idEmployee = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val project = MainMenu.projectManagement.openProjects.find { it.getName() == projectName }
                            if (project != null) {
                                val task =
                                    Task(name = taskName, description = taskDescription, startDate = taskStartDate)
                                MainMenu.projectManagement.addTaskToProject(task, project, idEmployee)
                                Utils.showMessage("Task added successfully.")
                            } else {
                                Utils.showMessage("Project not found.")
                            }
                        }
                    } catch (e: IllegalArgumentException) {
                        Utils.showMessage("Invalid id format.")
                    }
                }
                "2" -> {
                    if (Team.teams.isEmpty()) {
                        println("There are no teams created.")
                    } else {
                        val projectName = Utils.stringInput("Enter project name: ")
                        val teamName = Utils.stringInput("Enter team name: ")
                        val project = MainMenu.projectManagement.openProjects.find { it.getName().equals(projectName, ignoreCase = true) }
                        val team = Team.teams.find { it.getName().equals(teamName, ignoreCase = true) }
                        if (project != null && team != null) {
                            project.assignTeam(team)
                            Utils.showMessage("Team assigned successfully.")
                        } else {
                            Utils.showMessage("Project or Team not found.")
                        }
                    }
                }
                "3" -> {
                    if (MainMenu.projectManagement.openProjects.isEmpty()) {
                        Utils.showMessage("No projects found.")
                    } else {
                        MainMenu.projectManagement.openProjects.forEach { project ->
                            Utils.showMessage(project.toString())
                        }
                    }
                }
                "4" -> {
                    Utils.showMessage("Returning to main menu...")
                    repeat(100){
                        Utils.showMessage("\n")
                    }
                    MainMenu.showMenu()
                }
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "4")
    }

    /**
     * Displays the "Workers" menu and handles user input.
     */
    fun workersMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. Add employee
            2. Remove employee
            3. View employee skills
            4. Add skills to employee
            5. List all skills from an employee
            6. List all employees
            7. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    var employeeType = Utils.stringInput("Enter employee type (Manager, Programmer, Designer): ")
                    while (employeeType.lowercase() != "manager" && employeeType.lowercase() != "programmer" && employeeType.lowercase() != "designer") {
                        Utils.showMessage("Invalid employee type. Please try again.")
                        employeeType = Utils.stringInput("Enter employee type (Manager, Programmer, Designer): ")
                    }
                    val employeeName = Utils.stringInput("Enter employee name: ")
                    val employee = when (employeeType.lowercase()) {
                        "manager" -> {
                            val departament = Utils.stringInput("Enter the department is in charge of: ")
                            Manager(employeeName, departament)
                        }
                        "programmer" -> {
                            val programmingLanguage = Utils.stringInput("Enter programming language: ")
                            var level = Utils.stringInput("Enter employee level (Junior, Mid, Senior): ")
                            while (level.lowercase() !in listOf("junior", "mid", "senior")) {
                                Utils.showMessage("Invalid level. Please try again.")
                                level = Utils.stringInput("Enter employee level (Junior, Mid, Senior): ")
                            }
                            Programmer(employeeName, programmingLanguage, level)
                        }
                        "designer" -> {
                            val designTool = Utils.stringInput("Enter the design tool: ")
                            Designer(employeeName, designTool)
                        }
                        else -> null
                    }
                    if (employee != null) {
                        Employee.employees.add(employee)
                        Utils.showMessage("Employee added successfully.")
                    }
                }
                "2" -> {
                    try {
                        if (Employee.employees.isEmpty()) {
                            Utils.showMessage("There are no employees created.")
                        } else {
                            val id = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val employee = Employee.employees.find { it.getId() == id }
                            if (employee != null) {
                                Employee.employees.remove(employee)
                                Team.teams.find { it.employees.contains(employee) }?.let { it.removeEmployee(employee) }
                                Utils.showMessage("Employee removed successfully.")
                            } else {
                                Utils.showMessage("Employee not found.")
                            }
                        }
                    } catch (e: IllegalArgumentException) {
                        Utils.showMessage("Invalid id format.")
                    }
                }
                "3" -> {
                    try {
                        if (Employee.employees.isEmpty()) {
                            Utils.showMessage("There are no employees created.")
                        } else {
                            val id = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val employee = Employee.employees.find { it.getId() == id }
                            if (employee != null) {
                                Utils.showMessage("Skills of ${employee.getName()}: ${employee.getSkills()}")
                            } else {
                                Utils.showMessage("Employee not found.")
                            }
                        }
                    } catch (e: IllegalArgumentException) {
                        Utils.showMessage("Invalid id format.")
                    }
                }
                "4" -> {
                    try{
                        if (Employee.employees.isEmpty()) {
                            Utils.showMessage("There are no employees created.")
                        } else {
                            val id = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val skill = Utils.stringInput("Enter skill to add: ")
                            val employee = Employee.employees.find { it.getId() == id }
                            if (employee != null) {
                                employee.addSkills(skill)
                                Utils.showMessage("Skill added successfully.")
                            } else {
                                Utils.showMessage("Employee not found.")
                            }
                        }
                    } catch (e: IllegalArgumentException) {
                        Utils.showMessage("Invalid id format.")
                    }
                    }
                "5" -> {
                    if (Employee.employees.isEmpty()) {
                        Utils.showMessage("There are no employees created.")
                    } else {
                        try {
                            val id = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val employee = Employee.employees.find { it.getId() == id }
                            if (employee != null) {
                                Utils.showMessage("Skills of ${employee.getName()}: ${employee.getSkills()}")
                            } else {
                                Utils.showMessage("Employee not found.")
                            }
                        } catch (e: IllegalArgumentException) {
                            Utils.showMessage("Invalid id format.")
                        }
                    }
                }
                "6" -> {
                    if (Employee.employees.isEmpty()) {
                        println("No employees found.")
                    } else {
                        Employee.employees.forEach { println(it) }
                    }
                }
                "7" -> {
                    Utils.showMessage("Returning to main menu...")
                    repeat(100){
                        Utils.showMessage("\n")
                    }
                    MainMenu.showMenu()
                }
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "7")
    }

    /**
     * Displays the "Teams" menu and handles user input.
     */
    fun teamsMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. View all teams
            2. Add employee to team
            3. List all employees in a team
            4. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    if (Team.teams.isEmpty()) {
                        Utils.showMessage("No teams found.")
                    } else {
                        Team.teams.forEach { println(it) }
                    }
                }
                "2" -> {
                    if (Employee.employees.isEmpty() || Team.teams.isEmpty()) {
                        Utils.showMessage("There are no teams or employees created.")
                    } else {
                        val teamName = Utils.stringInput("Enter team name: ")
                        try {
                            val employeeId = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                            val team = Team.teams.find { it.getName() == teamName }
                            val employee = Employee.employees.find { it.getId() == employeeId }
                            if (team != null && employee != null) {
                                team.addEmployee(employee)
                                Utils.showMessage("Employee added to team successfully.")
                            } else {
                                Utils.showMessage("Team or Employee not found.")
                            }
                        } catch (e: IllegalArgumentException) {
                            Utils.showMessage("Invalid id format.")
                        }

                    }
                }
                "3" -> {
                    if (Team.teams.isEmpty()) {
                        println("No teams found.")
                    } else {
                        val teamName = Utils.stringInput("Enter team name: ")
                        val team = Team.teams.find { it.getName() == teamName }
                        if (team != null) {
                            team.listEmployee().forEach { println(it) }
                        } else {
                            Utils.showMessage("Team not found.")
                        }
                    }
                }
                "4" -> {
                    Utils.showMessage("Returning to main menu...")
                    repeat(100){
                        Utils.showMessage("\n")
                    }
                    MainMenu.showMenu()
                }
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "3")
    }
}