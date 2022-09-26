package model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val name: String,
    val about: String,
    val image: String,
    val workExperience: List<WorkExperience>,
    val skills: List<Skill>,
    val projects: List<Project>,
    val socials: List<Social>
)