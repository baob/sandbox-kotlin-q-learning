import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat

class PolicyRandomTest: TestCase() {

  fun `responds to play() with a board`() {
    val board = Board()
    val player = 1
    val playRandom = PolicyRandom().play(board, player)

    assertThat(playRandom, is(Board.class) )
  }

}
