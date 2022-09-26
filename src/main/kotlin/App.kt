import csstype.*
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import model.MenuOption
import model.Profile
import model.Social
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useState
import theme.Colors
import theme.glacialIndifference

val App = FC<Props> {
    var currentMenuOption: MenuOption by useState(MenuOption.About)
    div {
        css {
            width = 100.pct
            height = 100.pct
            maxHeight = 100.pct
            display = Display.flex
            fontFamily = FontFamily.glacialIndifference
        }
        Menu {
            profile = Profile(
                "ANDRII SERBENIUK",
                "https://avatars.githubusercontent.com/u/32796762",
                listOf(
                    Social("https://github.com/lincollincol", "img/github.png"),
                    Social("https://stackoverflow.com/users/9949259/lincollincol", "img/stack-overflow.png"),
                    Social("https://www.linkedin.com/in/andrew-linc-5976b0169/", "img/linkedin.png"),
                    Social("https://medium.com/@lincollincol", "img/medium.png")
                )
            )
            options = MenuOption.items()
            selectedMenuOption = currentMenuOption
            onItemClick = { menuOption ->
                currentMenuOption = menuOption
//                window.location.href += "/${menuOption.title}"
                window.location.pathname = menuOption.title
            }
        }
        VerticalDivider()
        Content {

        }
    }
}


