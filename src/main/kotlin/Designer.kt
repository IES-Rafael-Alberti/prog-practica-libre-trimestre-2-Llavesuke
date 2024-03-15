package org.example

/**
 * This class represents a designer, which is a type of employee.
 *
 * @property name The name of the designer.
 * @property designTool The design tool that the designer uses.
 */
class Designer(
    name: String,
    val designTool: String
) : Employee(name, "Designer") {


    /**
     * Calculates the salary of the designer.
     *
     * @return The salary of the designer.
     */
    override fun calculateSalary(): Double {
        return 2000.0
    }
}