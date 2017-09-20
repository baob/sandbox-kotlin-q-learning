class PolicyRandom {

    fun play(board: Board, player: Int): Board {
        val moveOptions = board.moveOptions()
        val move = moveOptions[(Math.random()*moveOptions.size).toInt()]
        return board.applyMove(move, player)
    }

}
