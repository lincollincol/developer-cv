package model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val name: String,
    val description: String,
    val url: String
)
//{
//    "name": "TopTalk messenger",
//    "description": "Messenger that translates messages to your native language",
//    "url": ""
//}