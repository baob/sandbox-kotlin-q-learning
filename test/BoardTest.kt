import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Assert.*
import org.junit.Test

class `a new board` {

    val board = Board()
    val moves = board.moveOptions()
    val emptyBoardMoves = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    val emptyBoardList = listOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    @Test
    fun `responds to moveOptions with 0 to 8`() {
        assertEquals(emptyBoardMoves, moves)
    }

    @Test
    fun `responds to toState with 0`() {
        assertEquals(0, board.toState())
    }

    @Test
    fun `responds to toArray with arrayOf(zeroes)`() {
        assertEquals(emptyBoardList, board.toList())
    }

    @Test
    fun `can be reconstructed from State`() {
        assertTrue(board == Board(board.toState()))
    }

    @Test
    fun `responds to toString with empty board`() {
        assertEquals("...\n...\n...\n", board.toString(null))
    }
}

class `board after player 1 moves to 8` {

    val board = Board().applyMove(8, 1)
    val moves = board.moveOptions()
    val expectedBoardMoves = listOf(0, 1, 2, 3, 4, 5, 6, 7)
    val expectedBoardList = listOf(0, 0, 0, 0, 0, 0, 0, 0, 1)

    @Test
    fun `responds to moveOptions with 0 to 7`() {
        assertEquals(expectedBoardMoves, moves)
    }

    @Test
    fun `responds to toState with 1`() {
        assertEquals(1, board.toState())
    }

    @Test
    fun `responds to toArray with arrayOf(zeroes) except 8 is 1`() {
        assertThat(board.toList(), equalTo(expectedBoardList))
    }

    @Test
    fun `can be reconstructed from State`() {
        assertThat(board, equalTo(Board(board.toState())))
    }

    @Test
    fun `responds to toString with 1 in position 8`() {
        assertEquals("...\n...\n..1\n", board.toString(null))
    }

    @Test
    fun `responds to toString XO with X in position 8`() {
        assertEquals("...\n...\n..X\n", board.toString("XO"))
    }
}

class `board after player 1 moves to 8 and player 2 moves to 7` {

    val board = Board().applyMove(8, 1).applyMove(7, 2)
    val moves = board.moveOptions()
    val expectedBoardMoves = listOf(0, 1, 2, 3, 4, 5, 6)
    val expectedBoardList = listOf(0, 0, 0, 0, 0, 0, 0, 2, 1)

    @Test
    fun `responds to moveOptions with 0 to 6`() {
        assertEquals(expectedBoardMoves, moves)
    }

    @Test
    fun `responds to toState with 5`() {
        assertEquals((2 * 3 + 1), board.toState())
    }

    @Test
    fun `can be reconstructed from State`() {
        assertThat(board, equalTo(Board(board.toState())))
    }

    @Test
    fun `responds to toArray with arrayOf(zeroes) except 8 is 1 and 7 is 2`() {
        assertThat(board.toList(), equalTo(expectedBoardList))
    }

    @Test
    fun `responds to toString with 1 in position 8 and 2 in 7`() {
        assertEquals("...\n...\n.21\n", board.toString(null))
    }

    @Test
    fun `responds to toString XO with X in position 8 and O in 7`() {
        assertEquals("...\n...\n.OX\n", board.toString("XO"))
    }
}

class `board after player 1 moves to 8 and player 2 moves to 7 and player 1 moves to 0` {

    val board = Board().applyMove(8, 1).applyMove(7, 2).applyMove(0, 1)
    val moves = board.moveOptions()
    val expectedBoardMoves = listOf(1, 2, 3, 4, 5, 6)
    val expectedBoardList = listOf(1, 0, 0, 0, 0, 0, 0, 2, 1)

    @Test
    fun `responds to moveOptions with 0 to 6`() {
        assertEquals(expectedBoardMoves, moves)
    }

    @Test
    fun `responds to toState with 6568`() {
        assertEquals((1 * 9 * 9 * 9 * 9 + 2 * 3 + 1), board.toState())
    }

    @Test
    fun `can be reconstructed from State`() {
        assertThat(board, equalTo(Board(board.toState())))
    }

    @Test
    fun `responds to toArray with arrayOf(zeroes) except 8 is 1 and 7 is 2`() {
        assertThat(board.toList(), equalTo(expectedBoardList))
    }

    @Test
    fun `responds to toString with 1 in position 8 and 2 in 7`() {
        assertEquals("1..\n...\n.21\n", board.toString(null))
    }

    @Test
    fun `responds to toString XO with X in position 8 and O in 7`() {
        assertEquals("X..\n...\n.OX\n", board.toString("XO"))
    }
}

class BoardWinsTest {

    @Test
    fun `3 in a row makes a win`() {
        expected_wins.forEach { win -> assertWinningRow(win) }
    }

    @Test
    fun `empty board is not a win`() {
        assertFalse(Board().isWinFor(1))
        assertFalse(Board().isWinFor(2))
    }

    @Test
    fun `any single play is not a win`() {
        (0..8).forEach{cell -> assertFalse(Board().applyMove(cell,1).isWinFor(1) ) }
    }

    @Test
    fun `any double play is not a win`() {
        (1..8).forEach { cell1 ->
            (0..(cell1-1)).forEach{ cell2 ->
                assertFalse(Board().applyMove(cell1,1).applyMove(cell2,1).isWinFor(1))
            }
        }
    }

    private fun assertWinningRow(expected_win_row: List<Int>): Unit {
        val winBoard = expected_win_row.fold(Board(),
                { tempBoard, move -> tempBoard.applyMove(move, 1) }
        )
        assertTrue(winBoard.isWinFor(1))
        assertThat(winBoard.winner(), equalTo(1))
    }

    private val expected_wins: List<List<Int>> = listOf(
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),
            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(0, 4, 8),
            listOf(2, 4, 6)
    )

    @Test
    fun `any single play is not a win next time`() {
        (0..8).forEach{cell ->
            val applyMove = Board().applyMove(cell, 1)
            assertFalse(applyMove.nextTimeCouldBeWinFor(1) )
            assertFalse(applyMove.nextTimeIsWinFor(1) )
        }
    }

    @Test
    fun `a win less one play could be a win next time`() {
        expected_wins.forEach { winningRow ->
            var board = Board()
            (0..1).forEach { index -> board = board.applyMove(winningRow[index], 1) }
            assertTrue(board.nextTimeCouldBeWinFor(1))
        }
    }

    @Test
    fun `when one move left on board, a win less one play MUST be a win next time`() {
        expected_wins.forEach { winningRow ->
            var board = Board(arrayOf(2, 2, 2, 2, 2 ,2 ,2 ,2 ,2))
            (0..1).forEach { index -> board = board.applyMove(winningRow[index], 1) }
            board = board.applyMove(winningRow[2], 0)
            assertTrue(board.nextTimeIsWinFor(1))
        }

    }




}
