package kotlin_in_action_ch04

// 아래의 코드는 너무 불필요하다.
// 왜냐하면, 변경할 필요가 없는 메서드, 프로퍼티까지 모두 override를 해줘야하기 때문이다.
class DelegatingCollection<T>: Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()
}

// 위의 코드는 아래와 같이 by 키워드를 통해 간단하게 작성 가능하다.
class DelegatingCollectionKotlin<T> (
    innerList: Collection<T> = ArrayList<T>()
): Collection<T> by innerList


// 예제 코드
class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val set = CountingSet<Int>()
    set.addAll(listOf(3, 5, 7, 9, 7))
    println("${set.objectsAdded} objects were added, ${set.size} remain")
}