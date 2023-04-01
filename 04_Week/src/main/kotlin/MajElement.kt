import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun getMajorityElement(a: IntArray, left: Int, right: Int): Int {
    if (left == right) return -1
    if (left + 1 == right) return a[left]

    a.sort() // 0 0 1 1
    var i = 0
    var count = 1

    while (i in 0 until right-1){
        if (a[i] == a[i+1])
            count++

        //println(count)
        if (count>a.size/2)
            return 2
        else if (a[i] != a[i+1])
            count = 1
        i++
    }

    return -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner3(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    if (getMajorityElement(a, 0, a.size) != -1) {
        println(1)
    } else {
        println(0)
    }
}

class FastScanner3(stream: InputStream) {
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