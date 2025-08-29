// Time Complexity : O(n*m * 3L) //n*m for board and we will be moving in 4 - 1(visited) directions for checking word of length "L"
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val ROWS = board.size
        val COLS = board[0].size
        val dir = arrayOf(
            -1 to 0,
            1 to 0,
            0 to -1,
            0 to 1
        )

        fun doDFS(r: Int, c: Int, i: Int): Boolean {
            if (word.length == i) {
                return true
            }
            if (r !in 0 until ROWS || c !in 0 until COLS
                || board[r][c] == '#'
                || word[i] != board[r][c]
            ) {
                return false
            }
            board[r][c] = '#' //mark as visited aka action
            //recurse
            for ((dr, dc) in dir) {
                val nr = r + dr
                val nc = c + dc
                if (doDFS(nr, nc, i + 1)) {
                    // board[r][c] = word[i] for just boolean case we need not do it
                    return true
                }
            }
            //backTrack
            board[r][c] = word[i]
            return false
        }

        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                val firstChar = word[0]
                if (firstChar == board[r][c]) {
                    if (doDFS(r, c, 0)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}