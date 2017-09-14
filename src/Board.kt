class Board {

    var board_plays: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    fun move_options(): List<Int> {
        return board_plays.mapIndexedNotNull { index, value -> if (value == 0) index else null }
    }

}
