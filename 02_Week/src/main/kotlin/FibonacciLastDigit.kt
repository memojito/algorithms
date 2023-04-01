import java.util.*

fun digFib(n: Int): Long {
    var a = 0L
    var b = 1L
    var sum: Long

    if (n == 0) return 0
    if (n == 1) return 1

    for (i in 2..n) {
        sum = a + b
        a = b
        b = sum % 10
    }

    return b
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a non-negative integer: ")
    val n = scanner.nextInt()

    println("The last digit of the nth Fibonacci number is: ${digFib(n)}")
}