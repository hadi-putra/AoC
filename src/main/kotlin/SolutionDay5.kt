import java.util.*

class SolutionDay5(fileInput: String): BaseSolution(fileInput) {
    override fun part1(lines: List<String>): Int {
        val (stackStr, operationStr) = lines.splitBy { it.isEmpty() }
        val stacks = buildStack(stackStr)

        operationStr.forEach { operation ->
            val tmp = operation.split(" ")
            var N = tmp[1].toInt()
            val from = tmp[3].toInt()
            val to = tmp[5].toInt()

            while (N > 0 && stacks[from-1].isNotEmpty()){
                stacks[to-1].push(stacks[from-1].pop())
                N--
            }
        }
        println(stacks.filter { it.isNotEmpty() }.joinToString("") { it.peek() })
        return 0
    }

    override fun part2(lines: List<String>): Int {
        val (stackStr, operationStr) = lines.splitBy { it.isEmpty() }
        val stacks = buildStack(stackStr).map { it.toMutableList() }

        operationStr.forEach { operation ->
            val tmp = operation.split(" ")
            var N = tmp[1].toInt()
            val from = tmp[3].toInt()
            val to = tmp[5].toInt()

            val tmp1 = stacks[from-1].dropLast(N)
            stacks[to-1].addAll(stacks[from-1].takeLast(N))
            stacks[from-1].clear()
            stacks[from-1].addAll(tmp1)
        }
        println(stacks.joinToString("") { it.last() })
        return 0
    }

    private fun buildStack(stackStr: List<String>): Array<Stack<String>> {
        val size = separateItems(stackStr[stackStr.lastIndex]).size
        val stacks = Array(size){ Stack<String>()}

        for (i in stackStr.lastIndex-1 downTo 0){
            val tmp = separateItems(stackStr[i])

            tmp.forEachIndexed { index, s ->
                if (s.isNotEmpty()){
                    stacks[index].push(s[1].toString())
                }
            }
        }

        return stacks
    }

    private fun separateItems(str: String): List<String> {
        val list = mutableListOf<String>()
        for (i in 0..str.lastIndex step 4){
            list.add(str.substring(i, (i + 4).coerceAtMost(str.length)).trim())
        }
        return list
    }

    fun <E> List<E>.splitBy(predicate: ((E)-> Boolean)): List<List<E>>{
        return this.fold(mutableListOf(mutableListOf())){acc: MutableList<MutableList<E>>, e: E ->
            if (predicate(e)){
                acc.add(mutableListOf())
            } else {
                acc[acc.lastIndex].add(e)
            }
            acc
        }
    }
}