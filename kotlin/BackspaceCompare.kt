// walk left from i, skipping chars erased by '#', and return the next kept index (or -1)
fun nextValidIndex(s: String, start: Int): Int {
    var i = start
    var skip = 0
    while (i >= 0) {
        if (s[i] == '#') {
            skip++
        } else if (skip > 0) {
            skip--
        } else {
            break
        }
        i--
    }
    return i
}

fun backspaceCompare(s: String, t: String): Boolean {
    var i = s.length - 1
    var j = t.length - 1

    while (true) {
        i = nextValidIndex(s, i)
        j = nextValidIndex(t, j)

        if (i < 0 && j < 0) return true
        if (i < 0 || j < 0 || s[i] != t[j]) return false
        i--
        j--
    }
}

fun main() {
    println(backspaceCompare("ab#c", "ad#c")) // true
    println(backspaceCompare("ab##", "c#d#")) // true
    println(backspaceCompare("a#c", "b"))     // false
}
