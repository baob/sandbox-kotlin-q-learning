class Board(){

    private val defaultBoard: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var boardPlays: Array<Int> = defaultBoard

    init {
        boardPlays = defaultBoard
    }

    constructor(initialBoard: Array<Int>?) : this() {
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

    fun toList() : List<Int> = boardPlays.toList()

    override fun toString() : String {
        return boardPlays.foldIndexed ( "", {index, acc, player  ->  toStringFold(index, acc, player)} )
    }

    private fun toStringFold(index: Int, acc: String, player: Int) : String {
        var res = acc
        if (player == 0) res  = res + "."
        else { res = res + player.toString() }
        if ((index+1).rem(3) == 0) res = res + "\n"
        return res
    }
}
