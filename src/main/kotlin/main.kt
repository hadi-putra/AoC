fun main(args: Array<String>) {
    val solution: BaseSolution = Solution1(args[0])
    println("Result: ${solution.solve(if (args[1].toInt() == 1) Part.TWO else Part.ONE)}!")
}