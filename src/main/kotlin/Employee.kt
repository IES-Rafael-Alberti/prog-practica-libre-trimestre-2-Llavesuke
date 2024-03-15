package org.example

import java.util.*

/**
 * This abstract class represents an employee.
 *
 * @property name The name of the employee.
 * @property position The position of the employee.
 * @property skills The skills of the employee.
 */
abstract class Employee (
    private val name: String,
    private val position: String,
    private val skills: MutableList<String> = mutableListOf()
) {
    companion object{
        /**
         * The list of all employees.
         */
        val employees: MutableList<Employee> = mutableListOf()
    }
    private val id = Utils.generateId()
    private val asignedTasks: MutableList<Task> = mutableListOf()

    /**
     * Adds a skill to the employee if it's not already in their skill list.
     *
     * @param skill The skill to add.
     */
    fun addSkills(skill: String) {
        if (skill.lowercase() !in skills.map { it.lowercase() }) {
            skills.add(skill)
        } else {
            Utils.showMessage("The skill is already added")
        }
    }

    /**
     * Gets the skills of the employee.
     *
     * @return The skills of the employee.
     */
    fun getSkills(): List<String> {
        return skills
    }

    /**
     * Gets the name of the employee.
     *
     * @return The name of the employee.
     */
    fun getName(): String {
        return name
    }

    /**
     * Adds a task to the list of tasks assigned to the employee.
     *
     * @param task The task to add.
     */
    fun changeAssignedTasks(task: Task) {
        asignedTasks.add(task)
    }

    /**
     * Gets the id of the employee.
     *
     * @return The id of the employee.
     */
    fun getId(): UUID {
        return id
    }

    /**
     * Calculates the salary of the employee.
     *
     * @return The salary of the employee.
     */
    abstract fun calculateSalary(): Double

    /**
     * Returns a string representation of the employee.
     *
     * @return A string representation of the employee.
     */
    override fun toString(): String {
        return "Employee $name | \nPosition:$position | ID: $id | Skills: $skills | Salary: ${calculateSalary()}"
    }
}