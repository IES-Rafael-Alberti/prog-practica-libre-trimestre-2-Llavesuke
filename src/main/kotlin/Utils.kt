package org.example

import java.time.LocalDate
import java.util.Date
import java.util.UUID
import java.io.IOException

class Utils {
    companion object {
        /**
         * Print the message in the terminal
         *
         * @param message The message to be printed
         */
        fun showMessage(message: String) {
            println(message)
        }

        fun generateId(): UUID {
            return UUID.randomUUID()
        }

        /**
         * Ask the user a string
         *
         * @return The user input
         */
        fun stringInput(string: String): String {
            print(string)
            val input = readln().trim()

            return input
        }

        /**
         * Ask a number to the user
         *
         * @throws NumberFormatException If the user write something different from an Int
         * @return The number introduced by the user
         */
        fun numberInput(string: String = "Introduce a number follow-up -> "): Int {
            var number: Int? = null

            while (number == null) {
                try {
                    print("-> ")
                    val input = readln().toInt()
                    number = input
                } catch (e: NumberFormatException) {
                    showMessage("ERROR: NOT VALID FORMAT")
                }
            }
            return number
        }

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

        fun clearScreen() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
                } else {
                    ProcessBuilder("clear").inheritIO().start().waitFor()
                }
            } catch (e: IOException) {
                println("Error al limpiar la pantalla: ${e.message}")
            } catch (e: InterruptedException) {
                println("Error al limpiar la pantalla: ${e.message}")
            }
        }

        fun main() {
            clearScreen()
            println("¡La pantalla ha sido limpiada!")
        }


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