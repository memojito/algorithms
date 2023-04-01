import java.util.*

fun optimalSequence(n: Int): List<Int> {
    if (n==1) return listOf(1)
    var m = n
    val sequence = ArrayList<Int>()
    while (m >= 1) {
        sequence.add(m)
        when {
            m == 1 ->{
                m = 0
            }
            m == 2 -> {
                m = 0
                sequence.add(1)
            }
            m == 3 -> {
                m = 0
                sequence.add(1)
            }
            m % 3 == 0 -> m /= 3

            (m - 1) % 3 == 0 -> {
                sequence.add(m-1)
                m = (m-1)/3
            }

            m % 2 == 0 -> m /= 2

            (m - 1) % 2 == 0 ->{
                sequence.add(m-1)
                m = (m - 1)/2
            }

            (m - 2) % 3 == 0 ->{
                sequence.add(m-1)
                sequence.add(m-2)
                m = (m - 2)/3
            }
            else -> m -= 1
        }
    }
    return sequence.reversed()
}

// 11 (1 3 9 10 11)
// 10 (1 3 9 10)
// n mod 11
// (n - 1) mod 11

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val sequence = optimalSequence(n)
    println(sequence.size - 1)
    for (x in sequence) {
        print(x.toString() + " ")
    }
}