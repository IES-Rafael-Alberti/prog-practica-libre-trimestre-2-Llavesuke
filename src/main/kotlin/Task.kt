package org.example

import java.util.Date

/**
 * This class represents a task in the project management system.
 *
 * @property name The name of the task.
 * @property description A description of the task.
 * @property assignTo The employee assigned to the task. It can be null if no employee is assigned.
 * @property startDate The date when the task starts.
 * @property state The current state of the task. It is initially set to PENDING.
 */
class Task (
    private val name: String,
    private val description: String,
    private var assignTo: Employee? = null,
    private val startDate: Date,
    private var state: TaskState = TaskState.PENDING) {

    /**
     * Starts the task by setting its state to IN_PROGRESS.
     */
    fun start() {
        state = TaskState.IN_PROGRESS
    }

    /**
     * Completes the task by setting its state to COMPLETED.
     */
    fun complete() {
        state = TaskState.COMPLETED
    }

    /**
     * Gets the current state of the task.
     *
     * @return The current state of the task.
     */
    fun getState(): TaskState{
        return state
    }

    /**
     * Updates the employee assigned to the task.
     *
     * @param employee The new employee to assign to the task.
     */
    fun updateEmployee(employee: Employee) {
        assignTo = employee
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string representation of the task.
     */
    override fun toString(): String {
        return "Task\nName:$name | \nDescription:$description | \nState:$state | \nAssigned to:${assignTo!!.getName()} | \nStart date:$startDate"
    }
}