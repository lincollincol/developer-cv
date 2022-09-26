package model

import kotlinx.serialization.Serializable

@Serializable
data class Social(
    val name: String,
    val image: String,
    val url: String
)

//{
//    "name": "Github",
//    "image": "img/github.png",
//    "url": "https://github.com/lincollincol"
//}