class PolicyRandom {

    fun play(board: Board, player: Int): Board {
        val move_options = board.move_options()
        val move = move_options[(Math.random()*move_options.size).toInt()]
        return board.apply_move(move, player)
    }

}
