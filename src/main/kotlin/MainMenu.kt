package org.example


object MainMenu {
    val projectManagement = ProjectManagement()

    fun showMenu() {
        var option: String
        val projectManagement = ProjectManagement()
        val secondaryMenus = SecondaryMenus()

        do {
            Utils.showMessage("""
            1. Create new records
            2. Projects
            3. Workers
            4. Teams
            5. View progress
            6. Exit
        """.trimIndent())
            option = Utils.stringInput("Choose an option: ")

            when (option) {
                "1" -> secondaryMenus.createNewRecordsMenu()
                "2" -> secondaryMenus.projectsMenu()
                "3" -> secondaryMenus.workersMenu()
                "4" -> secondaryMenus.teamsMenu()
                "6" -> Utils.showMessage("Exiting...")
                else -> Utils.showMessage("Invalid option. Please try again.")
            }
        } while (option != "6")
    }
}