import csstype.*
import emotion.react.css
import kotlinext.js.asJsObject
import kotlinext.js.require
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.Json
import model.MenuOption
import model.Profile
import model.Social
import org.w3c.fetch.Request
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.xhr.XMLHttpRequest
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useEffectOnce
import react.useState
import theme.Colors
import theme.glacialIndifference
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

val App = FC<Props> {

    var currentMenuOption: MenuOption by useState(MenuOption.About)
    var profile: Profile? by useState(null)
    useEffectOnce {
        readFile("profile-schema.json") {
            profile = Json.decodeFromString(it)
        }
//        readJson<Profile>("profile-schema.json") { profile = it }
    }
    profile?.let {
        div {
            css {
                width = 100.pct
                height = 100.pct
                maxHeight = 100.pct
                display = Display.flex
                fontFamily = FontFamily.glacialIndifference
            }
            Menu {
                this.profile = it
                options = MenuOption.items()
                selectedMenuOption = currentMenuOption
                onItemClick = { menuOption ->
                    currentMenuOption = menuOption
                }
            }
            VerticalDivider()
            Content {

            }
        }

    }
}


