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

    fun toArray() : Array<Int> = boardPlays.copyOf()

    fun toString(playerTokens: String? ) : String {
        return boardPlays.foldIndexed ( "", {index, acc, player  ->  toStringFold(index, acc, player, playerTokens)} )
    }

    private fun toStringFold(index: Int, acc: String, player: Int, playerTokens: String?) : String {
        var tokens: String = playerTokens ?: "12"
        var res: String = acc
        if (player == 0) res += "."
        else { res += tokens[player-1] }
        if ((index+1).rem(3) == 0) res += "\n"
        return res
    }
}
