import java.util.Scanner
class CreateArchiveMenu(private val archives: MutableMap<String, MutableList<Note>>) {
    private val scanner = Scanner(System.`in`)
    fun run() {
        while (true) {
            println("Введите название нового архива (не может быть пустым): ")
            val archiveName = scanner.nextLine().trim()
            if (archiveName.isEmpty()) {
                println("Название архива не может быть путым.")
                continue
            }
            if (archives.containsKey(archiveName)) {
                println("Архив с таким именем уже существует.")
                continue
            }
            archives[archiveName] = mutableListOf()
            println("Архив '$archiveName' создан.")
            break
        }
    }
}