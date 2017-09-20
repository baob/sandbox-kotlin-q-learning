import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class PolicyRandomTest {

    val emptyBoard = Board(null)
    val boardWithOneMove = Board(null)


    @Test
    fun `responds to play() with a board`() {
        val board = Board(null)
        val player = 1
        val playRandom = PolicyRandom().play(board, player)

        assert(playRandom is Board)
    }

    @Test
    fun `responds to play() with a different board`() {
        val board = emptyBoard
        val player = 1
        val playRandom = PolicyRandom().play(board, player)

        assertNotEquals(board.toState(), playRandom.toState())
    }

    @Test
    fun `responds to play() by choosing one of the available moves`() {
        val board = emptyBoard
        val player = 1
        val playRandom = PolicyRandom().play(board, player)

        assertEquals("should be one less available move",
                board.moveOptions().size - 1, playRandom.moveOptions().size)
    }
}
