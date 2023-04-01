import java.util.Scanner

fun changeMoney(n: Long): Long {
    var x = n
    var j = 0L
    while (x > 0) {
        x -= when {
            x >= 10 -> 10
            x >= 5 -> 5
            else -> 1
        }
        j++
    }
    return j
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    println(changeMoney(n))
}