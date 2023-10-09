import java.io.Console
import kotlin.random.Random

    fun main() {
        try {
            print("Введите натуральное число: ")
            val n = readln()
            val sortedArrays = generateAndSortArrays(n.toInt())

            for (array in sortedArrays) {
                println(array.joinToString(", "))
            }

        }
        catch (e: Exception) {
            println("Вы ввели не число! " + e.message)
        }

    }

    fun generateAndSortArrays(n: Int): List<IntArray> {
        val arrays = mutableListOf<IntArray>()
        val random = Random.Default

        for (i in 0..< n) {
            val size = random.nextInt(1, 101)
            val array = IntArray(size) { random.nextInt(1, 1001) }
            arrays.add(array)
        }


        for (i in 0..< arrays.size) {
            if (i % 2 == 0) {
                arrays[i] = arrays[i].sorted().toIntArray()
            } else {
                arrays[i] = arrays[i].sortedDescending().toIntArray()
            }
        }

        return arrays
    }