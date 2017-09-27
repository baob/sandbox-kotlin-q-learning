class Board(){

    private val defaultBoard: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var boardPlays: Array<Int> = defaultBoard

    init {
        boardPlays = defaultBoard
    }

    constructor(initialBoard: Array<Int>?) : this() {
        if (initialBoard is Array<Int>) boardPlays = initialBoard
    }

    constructor(initialState: Int) : this() {
        // TODO: this is WRONG it's just a placeholder
        boardPlays = defaultBoard
        boardPlays[0] = initialState
    }

    infix fun equals(other: Board) : Boolean {
        return this.toState() == other.toState()
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

    fun toString(playerTokens: String? ) : String {
        return boardPlays.foldIndexed ( "", {index, acc, player  ->  toStringFold(index, acc, player, playerTokens)} )
    }

    private fun toStringFold(index: Int, acc: String, player: Int, playerTokens: String?) : String {
        var tokens: String = playerTokens ?: "12"
        var res: String = acc + cellToString(index, player, tokens)
        return res
    }

    private fun cellToString(index: Int, player: Int, tokens: String) : String {
        var res: String
        if (player == 0) res = "."
        else res = tokens[player-1].toString()
        if ((index+1).rem(3) == 0) res += "\n"
        return res
    }
}
