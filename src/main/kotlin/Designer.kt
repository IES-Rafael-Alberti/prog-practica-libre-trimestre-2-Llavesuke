package org.example

class Designer(
    name: String,
    val designTool: String
) : Employee(name, "Designer") {


    fun design() {
        Utils.showMessage("${getName()} is designing using $designTool")
    }

    override fun calculateSalary(): Double {
        return 2000.0
    }
}