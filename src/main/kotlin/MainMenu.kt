package org.example

import com.github.ajalt.mordant.rendering.TextColors.*

/**
 * This object represents the main menu of the application.
 * It contains a reference to a ProjectManagement instance and a method to display the main menu.
 */
object MainMenu {
    /**
     * An instance of ProjectManagement.
     */
    val projectManagement = ProjectManagement()

    /**
     * Displays the main menu and handles user input.
     * The menu will keep displaying until the user chooses to exit.
     */
    fun showMenu() {
        var option: String
        val secondaryMenus = SecondaryMenus()
        do {
            val menuOptions = """
            ${green("1. Create new records")}
            ${red("2. Projects")}
            ${blue("3. Workers")}
            ${yellow("4. Teams")}
            ${magenta("5. View progress")}
            ${green("6. Exit")}
        """.trimIndent()

            Utils.showMessage(menuOptions)
            option = Utils.stringInput(red("Choose an option: "))

            /**
             * Handles the user's menu choice.
             * Calls the appropriate method based on the user's input.
             */
            when (option) {
                "1" -> secondaryMenus.createNewRecordsMenu()
                "2" -> secondaryMenus.projectsMenu()
                "3" -> secondaryMenus.workersMenu()
                "4" -> secondaryMenus.teamsMenu()
                "5" -> secondaryMenus.viewProgress()
                "6" -> Utils.showMessage("Exiting...")
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "6")
    }
}