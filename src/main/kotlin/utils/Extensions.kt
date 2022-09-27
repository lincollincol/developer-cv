package utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.w3c.xhr.XMLHttpRequest

fun readFile(
    file: String,
    result: (String) -> Unit
) {
    val request = XMLHttpRequest()
    request.overrideMimeType("application/json")
    request.open("GET", file, true)
    request.onreadystatechange = {
        if(request.readyState.equals(4) && request.status.equals(200)) {
            result(request.responseText)
        }
    }
    request.send(null)
}

//inline fun <reified T> readJson(
//    jsonFile: String,
//    crossinline result: (T) -> Unit
//) {
//    utils.readFile(jsonFile) {
//        result(Json.decodeFromString(it))
//    }
//}