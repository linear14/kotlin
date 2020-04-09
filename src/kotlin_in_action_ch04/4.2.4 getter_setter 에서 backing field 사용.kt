package kotlin_in_action_ch04

class User2(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                $name's AddressChanged : from "$field" -> "$value"  
            """.trimIndent())
            field = value
        }
}

fun main() {
    val user = User2("동현")
    user.address = "수원"
    user.address = "용인"
}