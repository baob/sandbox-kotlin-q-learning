class Board(initial_board: Array<Int>?){
    var board_plays: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    init {
        if (initial_board is Array<Int>) board_plays = initial_board
    }


    fun move_options(): List<Int> {
        return board_plays.mapIndexedNotNull { index, value -> if (value == 0) index else null }
    }

    fun toState(): Int {
        return board_plays.reduce{ memo, digit -> 3 * memo + digit }
    }

    fun apply_move(move: Int, player: Int): Board {
        var new_board_plays = board_plays.copyOf()
        new_board_plays[move] = player
        return Board(new_board_plays)
    }

    fun toArray() : Array<Int> = board_plays.copyOf()
}
