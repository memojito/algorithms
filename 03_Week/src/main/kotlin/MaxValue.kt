import java.util.*
import kotlin.math.roundToInt


fun getOptimalValue(_capacity: Int, _values: IntArray, _weights: IntArray): Double {

    var capacity = _capacity.toDouble()
    var i = 0
    var total: Double = 0.0

    while (capacity > 0.0 && i < _values.size) {
        if (capacity > _weights[i]) {
            capacity -= _weights[i]
            total += _values[i]
            i++
        } else if (i < _values.size) {
            total += capacity * _values[i] / _weights[i]
            capacity = 0.0
            i++
        } else
            break
    }

    return (total * 1000.0).roundToInt() / 1000.0
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val capacity = scanner.nextInt()
    val values = IntArray(n)
    val weights = IntArray(n)

    for (i in 0 until n) {
        values[i] = scanner.nextInt()
        weights[i] = scanner.nextInt()
    }

    for (i in 0 until values.size) {
        for (j in i + 1 until values.size) {
            if (values[i].toDouble() / weights[i].toDouble() < values[j].toDouble() / weights[j].toDouble()) {

                val tmp = values[i]
                values[i] = values[j]
                values[j] = tmp

                val tmp2 = weights[i]
                weights[i] = weights[j]
                weights[j] = tmp2
            }
        }
    }

    println(getOptimalValue(capacity, values, weights))
}
