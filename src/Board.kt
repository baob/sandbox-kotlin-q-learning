class Board(initialBoard: Array<Int>?){

    var boardPlays: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    init {
        if (initialBoard is Array<Int>) boardPlays = initialBoard
    }

    fun moveOptions(): List<Int> {
        return boardPlays.mapIndexedNotNull { index, value -> if (value == 0) index else null }
    }

    fun toState(): Int {
        return boardPlays.reduce{ memo, digit -> 3 * memo + digit }
    }

    fun applyMove(move: Int, player: Int): Board {
        var newBoardPlays = boardPlays.copyOf()
        newBoardPlays[move] = player
        return Board(newBoardPlays)
    }

    fun toArray() : Array<Int> = boardPlays.copyOf()
}
