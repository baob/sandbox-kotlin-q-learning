
fun <E> MutableList<E>.push(e: E): MutableList<E> {
    this.add(this.size , e)
    return this
}
