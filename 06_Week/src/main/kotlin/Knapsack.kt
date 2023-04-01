import java.util.*

fun optimalWeight(w: Int, array: IntArray): Int {
    val n = array.size
    val allWeights = Array(n + 1) { IntArray(w + 1) }

    for (i in 1..n) {
        for (weight in 1..w) {
            allWeights[i][weight] = allWeights[i - 1][weight]
            if (array[i - 1] <= weight) {
                val value = allWeights[i - 1][weight - array[i - 1]] + array[i - 1]
                if (allWeights[i][weight] < value) {
                    allWeights[i][weight] = value
                }
            }
        }
    }

    return allWeights[n][w]
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the weight capacity and number of items: ")
    val w = scanner.nextInt()
    val n = scanner.nextInt()

    val array = IntArray(n)
    println("Enter the weight of each item:")
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }

    array.sort()
    println("The maximum weight of items that can be carried is: ${optimalWeight(w, array)}")
}