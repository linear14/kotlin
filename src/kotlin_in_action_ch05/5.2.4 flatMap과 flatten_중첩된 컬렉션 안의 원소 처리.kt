package kotlin_in_action_ch05

data class Book(val title: String, val authors: List<String>)
fun main() {
    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )

    // toSet을 사용하면? -> 중복을 제거해준다~
    println(books.flatMap{ it.authors }.toSet())
}