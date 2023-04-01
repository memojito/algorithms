import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun getMaxPairwiseProduct(numbers: LongArray): Long {
    var max = Long.MIN_VALUE
    var premax = Long.MIN_VALUE
    var maxIndex = -1
    for (i in numbers.indices) {
        if (numbers[i] > max) {
            max = numbers[i]
            maxIndex = i
        }
    }
    for (i in numbers.indices) {
        if (i != maxIndex && numbers[i] > premax) {
            premax = numbers[i]
        }
    }
    return max * premax
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val numbers = LongArray(n)
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt().toLong()
    }
    println(getMaxPairwiseProduct(numbers))
}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}