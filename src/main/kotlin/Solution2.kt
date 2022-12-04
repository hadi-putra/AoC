class Solution2(fileInput: String): BaseSolution(fileInput) {
    override fun part1(lines: List<String>): Int {
        val meScore = mapOf("X" to 1, "Y" to 2, "Z" to 3)
        val roundScore = mapOf("A X" to 3, "A Y" to 6, "A Z" to 0,
                               "B X" to 0, "B Y" to 3, "B Z" to 6,
                               "C X" to 6, "C Y" to 0, "C Z" to 3)

        return lines.sumOf { roundScore.getOrDefault(it, 0) +
                meScore.getOrDefault(it.split(" ")[1], 0) }
    }

    override fun part2(lines: List<String>): Int {
        val endScore = mapOf("X" to 0, "Y" to 3, "Z" to 6)
        val roundScore = mapOf("A X" to 3, "A Y" to 1, "A Z" to 2,
                            "B X" to 1, "B Y" to 2, "B Z" to 3,
                            "C X" to 2, "C Y" to 3, "C Z" to 1)

        return lines.sumOf { roundScore.getOrDefault(it, 0) +
                endScore.getOrDefault(it.split(" ")[1], 0)}
    }
}