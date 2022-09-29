package model

import kotlinx.serialization.Serializable

@Serializable
data class WorkExperience(
    val company: String,
    val image: String,
    val role: String,
    val dates: String
)