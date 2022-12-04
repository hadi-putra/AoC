class SolutionDay4(fileInput: String): BaseSolution(fileInput) {
    override fun part1(lines: List<String>): Int {
        return lines.sumOf { line ->
            val parts= line.split(",")
            val elf1 = parts[0].split("-").map { it.toInt() }
            val elf2 = parts[1].split("-").map { it.toInt() }

            if (elf1[1]-elf1[0] > elf2[1]-elf2[0]){
                isCovered(elf1, elf2)
            } else {
                isCovered(elf2, elf1)
            }
        }
    }

    private fun isCovered(a: List<Int>, b: List<Int>) = if (b[0] >= a[0] && b[1] <= a[1] ) 1 else 0

    override fun part2(lines: List<String>): Int {
        return lines.sumOf { line ->
            val parts= line.split(",")
            val elf1 = parts[0].split("-").map { it.toInt() }
            val elf2 = parts[1].split("-").map { it.toInt() }

            isOverlap(elf1, elf2)
        }
    }

    private fun isOverlap(a: List<Int>, b: List<Int>) = if (a[0] > b[1] || b[0] > a[1]) 0 else 1
}