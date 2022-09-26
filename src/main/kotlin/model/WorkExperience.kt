package model

import kotlinx.serialization.Serializable

@Serializable
data class WorkExperience(
    val company: String,
    val role: String,
    val dates: String
)
//{
//    "company": "Deviark",
//    "role": "Android Developer",
//    "dates": "Mar 2021 — Present"
//}

/*
"Unexpected JSON token at offset 2894: Encountered an unknown key 'social' at path: $.projects
Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.
JSON input: .....      "url": ""
}
],
"social": [
{
    "name":....."*/
