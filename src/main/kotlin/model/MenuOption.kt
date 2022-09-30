package model

sealed class MenuOption(
    val title: String
) {
    object About : MenuOption("About")
    object WorkExperience : MenuOption("Work Experience")
    object Skills : MenuOption("Skills")
    object Projects : MenuOption("Projects")

    companion object {
        fun items() = listOf(About, WorkExperience, Skills, Projects)
    }
}