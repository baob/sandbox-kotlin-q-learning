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
        var boardAsList = boardPlaysFromState(initialState)
        boardPlays = boardAsList.toTypedArray()
    }

    private val wins: List<List<Int>> = listOf(
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),
            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(0, 4, 8),
            listOf(2, 4, 6)
    )

    private fun boardPlaysFromState(initialState: Int): MutableList<Int> {
        var boardAsList = mutableListOf(initialState)

//      TODO: we're not really interested in defaultBoard, just want to loop the same number of times. Make cleaner ?
        defaultBoard.fold(boardAsList) { stack, _ ->
            val dividend = stack.pop();
            val rem = dividend.rem(3);
            val quotient = dividend.div(3); stack.unshift(rem); stack.push(quotient);
        }
        boardAsList.pop()
        return boardAsList
    }

    override fun equals(other: Any?): Boolean {
        if (other is Board) return this.toState() == other.toState()
        return super.equals(other)
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

    fun isWinFor(player: Int): Boolean {
        return wins.any { winningRow ->
            winningRow.all { boardPlays[it] == player }
        }
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
