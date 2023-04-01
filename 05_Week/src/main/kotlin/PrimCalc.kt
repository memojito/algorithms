import java.util.*

fun nextMinOps(n:Int):List<Int>{

    val sequence = Array(n) {0}

    val allParents = Array(n) {0}
    val allMinOps = Array(n) {0}

    for (k in 1 until n-1){
        var currParent = k - 1
        var currMinOps = allMinOps[currParent] + 1

        if (k % 3 == 0){
            val parent = k / 3
            val numOps = allMinOps[parent] + 1
            if (numOps < currMinOps){
                currParent = parent
                currMinOps = numOps

            }
        }

        if (k % 2 == 0){
            val parent = k / 2
            val numOps = allMinOps[parent] + 1
            if (numOps < currMinOps){
                currParent = parent
                currMinOps = numOps

            }
        }

        allParents[k] = currParent
        allMinOps[k] = currMinOps

    }

    val numbers = mutableListOf<Int>()
    var k = n -1
    var x:Int

    while (k > 0){
        x = allParents[k]
        numbers.add(x)
        k--
    }

    return numbers.reversed()
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    println(nextMinOps(n))

}