import java.util.Scanner
class NoteScreen(private val note: Note) {
    fun run() {
        println("Заголовок: ${note.title}")
        println("Текст:")
        println(note.text)
        println("Нажмите Enter, чтобы вернуться")
        Scanner(System.`in`).nextLine()
    }
}