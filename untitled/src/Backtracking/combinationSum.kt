//package Backtracking
//
//fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
//}
//
//private fun combine(i: Int, n: Int, numElem: Int, comb: MutableList<Int>, result: MutableList<List<Int>>) {
//    if (numElem == 0) {
//        result.add(ArrayList(comb))
//        return
//    }
//    for (x in i..n) {
//        comb.add(x)
//        combine(x + 1, n, numElem - 1, comb, result)
//        comb.removeAt(comb.size - 1)
//    }
//}