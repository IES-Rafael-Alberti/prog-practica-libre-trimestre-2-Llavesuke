package org.example

class Programmer(
    name: String,
    val programmingLanguage: String,
    val level: String
) : Employee(name, "Programmer") {

    fun writeCode() {
        Utils.showMessage("${getName()} is writing code in $programmingLanguage")
    }

    override fun calculateSalary(): Double {
        return when (level) {
            "Junior" -> 1000.0
            "Mid" -> 2000.0
            "Senior" -> 3000.0
            else -> 0.0
        }
    }
}