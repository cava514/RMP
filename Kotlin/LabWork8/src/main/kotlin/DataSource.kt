interface DataSource<T> {
    fun getNext(n:T):T{
        return n
    }
}