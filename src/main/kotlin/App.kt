import components.Content
import components.Menu
import csstype.*
import emotion.react.css
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.MenuOption
import model.Profile
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useEffectOnce
import react.useState
import theme.glacialIndifference
import utils.readFile
import widgets.VerticalDivider

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
                this.options = MenuOption.items()
                this.selectedMenuOption = currentMenuOption
                this.onItemClick = { menuOption ->
                    currentMenuOption = menuOption
                }
            }
            VerticalDivider()
            Content {
                this.profile = it
                this.selectedMenuOption = currentMenuOption
            }
        }

    }
}


