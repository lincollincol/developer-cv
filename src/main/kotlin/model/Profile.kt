package model

data class Profile(
    val name: String,
    val imageUrl: String,
    val socials: List<Social>
)