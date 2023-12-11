package Interval

// CopmareBy has several selectors here as said
fun main(args: Array<String>) {
    var foo = listOf(2, 3, 4, 1, 1, 5, 23523, 4, 234, 2, 2334, 2)

    foo = foo.sortedWith(compareBy({
        it != 4
    },{
        it
    }))
    // Basically the sorting would not apply when it ==4
    print(foo)
}
