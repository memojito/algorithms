import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.roundToInt

fun binarySearch(a: IntArray, x: Int): Int {
    var left = 0
    var right = a.size - 1
    while (right>=left){
        var mid = left + (right-left)/2
        //print("mid = $mid")

        if (a[mid] == x)
            return mid
        else if (a[mid] < x){
            mid += 1
            left = mid
        }
        else {
            mid -= 1
            right = mid
        }
    }

    return -1
}

fun linearSearch(a: IntArray, x: Int): Int {
    for (i in a.indices) {
        if (a[i] == x) return i
    }
    return -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        //replace with the call to binarySearch when implemented
        print(binarySearch(a, b[i]).toString() + " ")
    }
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