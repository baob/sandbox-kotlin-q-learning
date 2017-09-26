
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.should.shouldMatch
import org.junit.Assert.assertEquals
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
    fun `responds to toString with empty board`() {
        assertEquals("...\n...\n...\n", board.toString(null))
    }
}

   class `board after player 1 moves to 8` {

    val board = Board(arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1))
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
        expectedBoardList.toList().shouldMatch(equalTo(board.toList()))

        assertEquals(expectedBoardList.toList(), board.toList())
//        assertThat(board.toArray().includesExactly(expectedBoardArray))
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