package org.example

class Manager(
    name: String,
    private val department: String,
) : Employee(name, "Manager") {

    private val reports: MutableList<String> = mutableListOf()

    fun supervise() {
        Utils.showMessage("${getName()} is supervising the $department department")
    }

    fun createReport(report: String) {
        reports.add(report)
    }

    override fun calculateSalary(): Double {
        return 3000.0
    }
}