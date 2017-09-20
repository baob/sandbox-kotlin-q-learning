import org.junit.Assert.assertEquals
import org.junit.Test

class BoardTest {

    @Test
    fun `new board responds to move_options with 0 to 8`() {

        val board = Board()

        val moves = board.moveOptions()

        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8), moves)
    }

    @Test
    fun `new board constructed with no arguments responds to move_options with 0 to 8`() {
        val board = Board()

        val moves = board.moveOptions()

        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8), moves)
    }
}