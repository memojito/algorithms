import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.roundToInt

fun binarySearchDup(a: IntArray, x: Int): Int {
    var left = 0
    var right = a.size - 1
    while (right>=left){
        var mid = left + (right-left)/2
        //print("mid = $mid")
        if (mid == 0 && a[mid] == x)
            return 0

        if (a[mid] == x && a[mid - 1] != x)
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


fun main(args: Array<String>) {
    val scanner = FastScannerDup(System.`in`)
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
        print(binarySearchDup(a, b[i]).toString() + " ")
    }
}

class FastScannerDup(stream: InputStream) {
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