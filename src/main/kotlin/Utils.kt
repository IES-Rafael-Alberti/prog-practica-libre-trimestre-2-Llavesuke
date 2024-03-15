package org.example

import java.time.LocalDate
import java.util.Date
import java.util.UUID

/**
 * Utility class that provides various helper methods.
 */
class Utils {
    companion object {
        /**
         * Prints the given message to the terminal.
         *
         * @param message The message to be printed.
         */
        fun showMessage(message: String) {
            println(message)
        }

        /**
         * Generates a random UUID.
         *
         * @return The generated UUID.
         */
        fun generateId(): UUID {
            return UUID.randomUUID()
        }

        /**
         * Prompts the user for a string input.
         *
         * @param string The prompt message.
         * @return The user's input as a string.
         */
        fun stringInput(string: String): String {
            print(string)
            val input = readln().trim()

            return input
        }

        /**
         * Prompts the user for a number input.
         *
         * @param string The prompt message.
         * @throws NumberFormatException If the user's input is not a valid integer.
         * @return The user's input as an integer.
         */
        fun numberInput(string: String = "Introduce a number follow-up -> "): Int {
            var number: Int? = null

            while (number == null) {
                try {
                    print(string)
                    val input = readln().toInt()
                    number = input
                } catch (e: NumberFormatException) {
                    showMessage("ERROR: NOT VALID FORMAT")
                }
            }
            return number
        }

        /**
         * Prompts the user for a date input.
         *
         * @return The user's input as a Date.
         */
        fun insertDate(): Date {
            var date: Date? = null

            var year: Int
            var month: Int
            var day: Int

            while (date == null) {
                year = numberInput("Introduce a year -> ")
                if (year < 1900 || year > 2025) {
                    showMessage("The year must be greater than 1900 and less than 2025")
                } else {
                    month = numberInput("Introduce a month -> ")
                    if (month < 1 || month > 12) {
                        showMessage("The month must be greater than 1 and less than 12")
                    } else {
                        day = numberInput("Introduce a day -> ")
                        if (day < 1 || day > 31) {
                            showMessage("The day must be greater than 1 and less than 31")
                        } else {
                            date = java.sql.Date.valueOf(LocalDate.of(year, month, day))
                        }
                    }
                }
            }
            return date
        }

        /**
         * Prints a progress bar to the terminal.
         *
         * @param progress The progress percentage (0.0 to 1.0).
         */
        fun printProgressBar(progress: Double) {
            val width = 50 // ancho de la barra de progreso
            val value = (progress * width).toInt() // calcula el número de caracteres de relleno

            print("[")
            repeat(value) { print("=") } // imprime los caracteres de relleno
            repeat(width - value) { print(" ") } // imprime los espacios vacíos
            print("]")

            println(" $progress%") // imprime el porcentaje de progreso
        }
    }
}