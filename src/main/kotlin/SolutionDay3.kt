class SolutionDay3(fileInput: String): BaseSolution(fileInput) {
    override fun part1(lines: List<String>): Int {
        return lines.sumOf { line ->
            val parts = line.chunked(line.length / 2)
            val common = parts[0].toCharArray().toSet().intersect(parts[1].toCharArray().toSet())
            common.sumOf { calculateScore(it) }
        }
    }

    override fun part2(lines: List<String>): Int {
        return lines.chunked(3).sumOf { ch ->
            ch.foldIndexed(setOf<Char>()) { index, acc, s ->
                if (index == 0)
                    s.toCharArray().toSet()
                else
                    acc.intersect(s.toCharArray().toSet())
            }.sumOf { char -> calculateScore(char) }
        }
    }

    private fun calculateScore(char: Char) = (if(char.isUpperCase()) 27 else 1)+char.toLowerCase().minus('a')
}