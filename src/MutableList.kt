

fun <E> MutableList<E>.push(e: E): MutableList<E> {
    this.add(this.size , e)
    return this
}

fun <E> MutableList<E>.pop(): E {
    return removeAt(size - 1)
}

fun <E> MutableList<E>.unshift(e: E): MutableList<E>? {
    this.add(0, e)
    return this


}
