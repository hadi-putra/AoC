import java.io.File
import java.util.*

class SolutionDay1 (fileName: String): BaseSolution(fileName) {

    override fun part1(lines: List<String>): Int {
        var curSum = 0
        var maxSum = -1

        lines.forEach {
            if (it.isEmpty()){
                if (curSum > maxSum)
                    maxSum = curSum
                curSum = 0
            } else {
                curSum += it.toInt()
            }
        }

        return maxSum
    }

    override fun  part2(lines: List<String>): Int {
        val pq = PriorityQueue<Int>()
        var curSum = 0

        lines.forEach {
            if(it.isEmpty()){
                pq.add(curSum)
                if (pq.size > 3)
                    pq.poll()
                curSum = 0
            } else {
                curSum += it.toInt()
            }
        }

        return pq.sum()
    }
}