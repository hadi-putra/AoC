class SolutionDay6(fileInput: String): BaseSolution(fileInput) {
    override fun part1(lines: List<String>): Int {
        return findFirstMarker(lines[0])
    }

    override fun part2(lines: List<String>): Int {
        return findFirstMarker(lines[0], 14)
    }

    private fun findFirstMarker(text:String, length:Int = 4):Int {
        val dict = mutableMapOf<Char, Int>()
        var start = 0

        text.forEachIndexed { index, c ->
            if (c in dict && (dict[c]?:0) >= start){
                start = (dict[c]?:-1) + 1
            }

            if ((index+1 - start) == length){
                return index+1
            }
            dict[c] = index
        }
        return -1
    }
}