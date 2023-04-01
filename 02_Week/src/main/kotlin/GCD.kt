import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter two integers: ")
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println("The greatest common divisor of $a and $b is: ${gcd(a, b)}")
}

fun gcd(x: Int, y: Int): Int {
    var _x = x
    var _y = y

    while (_x != 0 && _y != 0) {
        if (_x > _y)
            _x %= _y
        else
            _y %= _x
    }

    return _x + _y
}