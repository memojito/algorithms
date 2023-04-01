import java.util.*

fun calcFib(n: Int): Long {
    if (n == 0) return 0
    if (n == 1) return 1

    var a = 0L
    var b = 1L

    for (i in 2..n) {
        val sum = a + b
        a = b
        b = sum
    }

    return b
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a non-negative integer: ")
    val n = scanner.nextInt()

    println("The nth Fibonacci number is: ${calcFib(n)}")
}