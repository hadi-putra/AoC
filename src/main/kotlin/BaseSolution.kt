import java.io.File

abstract class BaseSolution (private val fileName: String) {

    private fun readFilePerLine() =
        javaClass.getResource(fileName)?.toURI()?.let { uri ->
            File(uri).useLines { it.toList() }
        } ?: listOf()

    fun solve(part: Part = Part.ONE): Int {
        val lines = readFilePerLine()
        return when(part){
            Part.ONE -> part1(lines)
            Part.TWO -> part2(lines)
        }
    }

    abstract fun part1(lines: List<String>): Int
    abstract fun part2(lines: List<String>): Int

}