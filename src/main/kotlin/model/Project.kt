package model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val name: String,
    val image: String,
    val description: String,
    val url: String,
    val isOpenSource: Boolean,
)