package org.example

import java.util.Date

class Task (
    private val name: String,
    private val description: String,
    private var assignTo: Employee? = null,
    private val startDate: Date,
    private var state: TaskState = TaskState.PENDING) {

    fun start() {
        state = TaskState.IN_PROGRESS
    }

    fun complete() {
        state = TaskState.COMPLETED
    }

    fun getState(): TaskState{
        return state
    }

    fun updateEmployee(employee: Employee) {
        assignTo = employee
    }
    override fun toString(): String {
        return "Task\nName:$name | \nDescription:$description | \nState:$state | \nAssigned to:${assignTo!!.getName()} | \nStart date:$startDate"
    }
}