class ArchiveMenu(private val archives: MutableMap<String, MutableList<Note>> = mutableMapOf()) : Menu(mutableListOf()) {
    init {
        items.add(MenuItem("Создать архив") { CreateArchiveMenu(archives).run(); rebuildMenu() })
        if (archives.isNotEmpty()) {
            archives.keys.forEachIndexed { index, archive ->
                items.add(MenuItem(archive) { NoteMenu(archives, archive).run() })
            }
        } else {
            items.add(MenuItem("Архивов нет") {})
        }
    }
    private fun rebuildMenu() {
        items.clear()
        items.add(MenuItem("Создать архив") {
            CreateArchiveMenu(archives).run(); rebuildMenu() })
        archives.keys.forEachIndexed {index, archive -> items.add(MenuItem(archive) {NoteMenu(archives, archive).run()})
        }
        if (archives.isEmpty()) {
            items.add(MenuItem("Архивов нет") {})
        }
    }
}