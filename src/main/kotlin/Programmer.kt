package org.example

/**
 * This class represents a programmer, which is a type of employee.
 *
 * @property name The name of the programmer.
 * @property programmingLanguage The programming language that the programmer uses.
 * @property level The level of the programmer (Junior, Mid, Senior).
 */
class Programmer(
    name: String,
    val programmingLanguage: String,
    val level: String
) : Employee(name, "Programmer") {

    /**
     * Calculates the salary of the programmer based on their level.
     *
     * @return The salary of the programmer.
     */
    override fun calculateSalary(): Double {
        return when (level) {
            "Junior" -> 1000.0
            "Mid" -> 2000.0
            "Senior" -> 3000.0
            else -> 0.0
        }
    }
}