package org.example

import java.util.*

abstract class Employee (
    private val name: String,
    private val position: String,
    private val skills: MutableList<String> = mutableListOf()
) {
    companion object{
        val employees: MutableList<Employee> = mutableListOf()
    }
    private val id = Utils.generateId()
    private val asignedTasks: MutableList<Task> = mutableListOf()

    fun addSkills(skill: String) {
        if (skill.lowercase() !in skills.map { it.lowercase() }) {
            skills.add(skill)
        } else {
            Utils.showMessage("The skill is already added")
        }
    }

    fun getSkills(): List<String> {
        return skills
    }

    fun listAsignedTasks() {
        Utils.showMessage("$name has the following tasks:")
        for (task in asignedTasks) {
            Utils.showMessage("- ${task}")
        }
    }

    fun getName(): String {
        return name
    }


    fun changeAssignedTasks(task: Task) {
        asignedTasks.add(task)
    }

    fun getId(): UUID {
        return id
    }

    abstract fun calculateSalary(): Double


    override fun toString(): String {
        return "Employee\nName:$name | \nPosition:$position"
    }
}