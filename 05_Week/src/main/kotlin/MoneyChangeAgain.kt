import java.util.*

fun getChange(m: Int): Int {
    var left = m

    var count = 0

    while (left != 0){
        if (left == 9)
            return count + 3
        if (left == 6)
            return count + 2
        if (left >= 4){
            count++
            left -= 4
        }
        else if (left >= 3){
            left -= 3
            count++
        }
        else
            return count + left
    }

    return count
}

// 1 3 4
// 6 = 3 + 3 (2)
// 9 = 6 + 3 (3)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(getChange(m))
}