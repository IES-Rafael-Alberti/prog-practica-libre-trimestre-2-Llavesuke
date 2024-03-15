package org.example

import com.sun.tools.javac.Main
import java.util.*

class SecondaryMenus {
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

    fun projectsMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. Add task to project
            2. Assign team to project
            3. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
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
                            val task = Task(name = taskName, description = taskDescription, startDate = taskStartDate)
                            MainMenu.projectManagement.addTaskToProject(task, project, idEmployee)
                            Utils.showMessage("Task added successfully.")
                        } else {
                            Utils.showMessage("Project not found.")
                        }
                    }
                }
                "2" -> {
                    if (Team.teams.isEmpty()) {
                        println("There are no teams created.")
                    } else {
                        val projectName = Utils.stringInput("Enter project name: ")
                        val teamName = Utils.stringInput("Enter team name: ")
                        val teamDescription = Utils.stringInput("Enter team description: ")
                        val project = MainMenu.projectManagement.openProjects.find { it.getName().lowercase() == projectName }
                        if (project != null && Team.teams.find { it.getName().lowercase() == teamName.lowercase() } != null) {
                            val team = Team<Employee>(teamName, teamDescription)
                            MainMenu.projectManagement.asignTeamToProyect(team, project)
                            Utils.showMessage("Team assigned successfully.")
                        } else {
                            Utils.showMessage("Project not found or Team doesn't exist.")
                        }
                    }
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
        } while (option != "3")
    }

    fun workersMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. Add employee
            2. Remove employee
            3. View employee skills
            4. Add skills to employee
            5. List all employees
            6. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    var employeeType = Utils.stringInput("Enter employee type (Manager, Programmer, Designer): ")
                    while (employeeType != "Manager" && employeeType != "Programmer" && employeeType != "Designer") {
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
                            val programmingLanguage = Utils.stringInput("Enter employee position: ")
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
                }
                "3" -> {
                    val id = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                    val employee = Employee.employees.find { it.getId() == id }
                    if (employee != null) {
                        Utils.showMessage("Skills of ${employee.getName()}: ${employee.getSkills()}")
                    } else {
                        Utils.showMessage("Employee not found.")
                    }
                }
                "4" -> {
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
                "5" -> {
                    if (Employee.employees.isEmpty()) {
                        println("No employees found.")
                    } else {
                        Employee.employees.forEach { println(it) }
                    }
                }
                "6" -> {
                    Utils.showMessage("Returning to main menu...")
                    repeat(100){
                        Utils.showMessage("\n")
                    }
                    MainMenu.showMenu()
                }
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "6")
    }

    fun teamsMenu() {
        var option: String
        do {
            Utils.showMessage("""
            1. View all teams
            2. Add employee to team
            3. Back to main menu
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> {
                    if (Team.teams.isEmpty()) {
                        println("No teams found.")
                    } else {
                        Team.teams.forEach { println(it) }
                    }
                }
                "2" -> {
                    if (Employee.employees.isEmpty() || Team.teams.isEmpty()) {
                        println("There are no teams or employees created.")
                    } else {
                        val teamName = Utils.stringInput("Enter team name: ")
                        val employeeId = UUID.fromString(Utils.stringInput("Enter employee id: ").trim())
                        val team = Team.teams.find { it.getName() == teamName }
                        val employee = Employee.employees.find { it.getId() == employeeId }
                        if (team != null && employee != null) {
                            team.addEmployee(employee)
                            Utils.showMessage("Employee added to team successfully.")
                        } else {
                            Utils.showMessage("Team or Employee not found.")
                        }
                    }
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
        } while (option != "3")
    }
}