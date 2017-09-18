import org.junit.Assert.assertNotEquals
import org.junit.Ignore
import org.junit.Test

class PolicyRandomTest {

    @Test
    fun `responds to play() with a board`() {
        val board = Board()
        val player = 1
        val playRandom = PolicyRandom().play(board, player)

        assert(playRandom is Board)
    }

    @Test
    @Ignore
    fun `responds to play() with a different board`() {
        val board = Board()
        val player = 1
        val playRandom = PolicyRandom().play(board, player)

        assertNotEquals(board.toState(), playRandom.toState())

    }

}
