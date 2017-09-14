import org.junit.Assert.assertEquals
import org.junit.Test

class BoardTest {

    @Test
    fun `new board responds to move_options with 0 to 8`() {

        val board = Board()
        val moves = board.move_options()

        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8), moves)
    }
}