import junit.framework.TestCase

class PolicyRandomTest: TestCase() {

  fun `responds to play() with a board`() {
    val board = Board()
    val player = 1
    val playRandom = PolicyRandom().play(board, player)

    assertTrue("board not returned", playRandom.is(Board) )
  }

}
