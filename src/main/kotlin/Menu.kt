import java.util.Scanner
data class MenuItem(val label: String, val action: () -> Unit)
open class Menu(val items: MutableList<MenuItem>) {
    private val scanner = Scanner(System.`in`)
    fun show() {
        items.forEachIndexed {index, item -> println("${index}. ${item.label}")
        }
        println("${items.size}. Выход")
    }
    fun run() {
        while (true) {
            show()
            println("Выберете пункт меню: ")
            val input = scanner.nextLine()
            try {
                val choice = input.toInt()
                if (choice == items.size)
                    return
                if (choice in items.indices) {
                    items[choice].action()
                } else {
                    println("Неверный номер пункта меню.")
                }
            } catch (e: NumberFormatException)  {
                println("Пожалуйста, введите число.")
            }
        }
    }
}