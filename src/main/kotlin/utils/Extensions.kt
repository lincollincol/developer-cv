package utils

import csstype.Margin
import csstype.Padding
import csstype.PropertiesBuilder
import csstype.px
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

fun PropertiesBuilder.padding(
    top: Padding = 0.px,
    bottom: Padding = 0.px,
    left: Padding = 0.px,
    right: Padding = 0.px
) {
    paddingTop = top
    paddingBottom = bottom
    paddingLeft = left
    paddingRight = right
}

fun PropertiesBuilder.padding(
    vertical: Padding = 0.px,
    horizontal: Padding = 0.px
) = padding(vertical, vertical, horizontal, horizontal)

fun PropertiesBuilder.margin(
    top: Margin = 0.px,
    bottom: Margin = 0.px,
    left: Margin = 0.px,
    right: Margin = 0.px
) {
    marginTop = top
    marginBottom = bottom
    marginLeft = left
    marginRight = right
}

fun PropertiesBuilder.margin(
    vertical: Margin = 0.px,
    horizontal: Margin = 0.px
) = margin(vertical, vertical, horizontal, horizontal)