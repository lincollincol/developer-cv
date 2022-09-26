package model

sealed class MenuOption(
    val title: String
) {
    object About : MenuOption("ABOUT")
    object Skills : MenuOption("SKILLS")
    object Projects : MenuOption("PROJECTS")
    object Contact : MenuOption("CONTACT")

    companion object {
        fun items() = listOf(About, Skills, Projects, Contact)
    }
}