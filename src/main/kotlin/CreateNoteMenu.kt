import java.util.Scanner
class CreateNoteMenu(private val archives: MutableMap<String, MutableList<Note>>, private val archiveName: String) {
    private val scanner = Scanner(System.`in`)
    fun run() {
        while (true) {
            println("Введите название новой заметки (не может быть пустым): ")
            val title = scanner.nextLine().trim()
            if (title.isEmpty()) {
                println("Заголовок заметки не может быть пустым.")
                continue
            }
            if (archives[archiveName]?.any { it.title == title } == true) {
                println("Заметка с таким именем уже существует.")
                continue
            }
            while (true) {
                println("Введите текст заметки (не может быть пустым): ")
                val text = scanner.nextLine().trim()
                if (text.isEmpty()) {
                    println("Содержимое заметки не может быть пустым.")
                    continue
                }
                val newNote = Note(title, text)
                archives[archiveName]?.add(newNote) ?: println("Ошибка добавления заметки.")
                println("Заметка '$title' создана.")
                break
            }
            break
        }
    }
}