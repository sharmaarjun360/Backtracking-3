// Time Complexity : O(n*n!)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val mat = Array(n) { BooleanArray(n) } //false by default
        val ROWS = n
        val COLS = n
        val result = mutableListOf<MutableList<String>>()

        fun isValid(r: Int, c: Int): Boolean {
            var k = 1
            while (r - k >= 0) {
                // -1, 0 up
                if (mat[r - k][c]) {
                    return false
                }
                //-1, -1 diagonal left
                if (c - k >= 0 && mat[r - k][c - k]) {
                    return false
                }
                //-1, +1 diagonal right
                if (c + k < COLS && mat[r - k][c + k]) {
                    return false
                }

                k++
            }
            return true
        }

        fun helper(r: Int, boundry: Int) {

            if (r == boundry) {
                val list = mutableListOf<String>()
                for (r in 0 until ROWS) {
                    val sb = StringBuilder()
                    for (c in 0 until COLS) {
                        val ch = if (mat[r][c]) 'Q' else '.'
                        sb.append(ch)
                    }
                    list.add(sb.toString())
                }
                result.add(list)
                return
            }

            for (c in 0 until COLS) {
                if (isValid(r, c)) {
                    mat[r][c] = true
                    helper(r + 1, boundry)
                    mat[r][c] = false
                }
            }
        }

        helper(0, n)
        return result

    }
}