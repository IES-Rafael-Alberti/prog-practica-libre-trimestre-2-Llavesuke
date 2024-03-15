package org.example

/**
 * This class represents a manager, which is a type of employee.
 *
 * @property name The name of the manager.
 * @property department The department that the manager supervises.
 */
class Manager(
    name: String,
    private val department: String,
) : Employee(name, "Manager") {

    /**
     * The list of reports created by the manager.
     */
    private val reports: MutableList<String> = mutableListOf()

    /**
     * Simulates the manager supervising their department.
     */
    fun supervise() {
        Utils.showMessage("${getName()} is supervising the $department department")
    }

    /**
     * Creates a report and adds it to the list of reports.
     *
     * @param report The report to add.
     */
    fun createReport(report: String) {
        reports.add(report)
    }

    /**
     * Calculates the salary of the manager.
     *
     * @return The salary of the manager.
     */
    override fun calculateSalary(): Double {
        return 3000.0
    }
}