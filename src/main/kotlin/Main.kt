fun main() {
    val archives = mutableMapOf<String, MutableList<Note>>()
    ArchiveMenu(archives).run()
    println("Программа завершена.")
}