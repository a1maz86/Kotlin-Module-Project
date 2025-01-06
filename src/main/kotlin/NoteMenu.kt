class NoteMenu(private val archives: MutableMap<String, MutableList<Note>>, private val archiveName: String) : Menu(mutableListOf()) {
    init {
        items.add(MenuItem("Создать заметку") {CreateNoteMenu(archives, archiveName).run(); rebuildMenu()})
        val notes = archives[archiveName] ?: emptyList()
        if (notes.isNotEmpty()) {
            notes.forEachIndexed { index, note ->
                items.add(MenuItem(note.title) { NoteScreen(note).run() })
            }
        } else {
            items.add(MenuItem("Заметок нет") {})
        }
    }
    private fun rebuildMenu() {
        items.clear()
        items.add(MenuItem("Создать заметку") { CreateNoteMenu(archives, archiveName).run(); rebuildMenu() })
        val notes = archives[archiveName] ?: emptyList()
        if (notes.isNotEmpty()) {
            notes.forEachIndexed { index, note ->
                items.add(MenuItem(note.title) { NoteScreen(note).run() })
            }
        } else {
            items.add(MenuItem("Заметок нет") {})
        }
    }
}