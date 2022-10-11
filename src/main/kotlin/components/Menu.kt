package components

import csstype.*
import emotion.react.css
import model.MenuOption
import model.Profile
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.footer
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.main
import theme.*
import utils.margin
import widgets.*

external interface MenuProps : Props {
    var profile: Profile
    var selectedMenuOption: MenuOption
    var options: List<MenuOption>
    var onItemClick: (MenuOption) -> Unit
}

val Menu = FC<MenuProps> { props ->
    div {
        css {
            height = 100.pct
            paddingLeft = 2.vmin
            paddingRight = 2.vmin
            backgroundColor = Colors.black
            color = Colors.white
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        header {
            Image(
                src = props.profile.image,
                width = 20.vmin,
                height = Auto.auto,
                radius = 50.pct,
                extraStyleProperties = {
                    display = Display.block
                    margin(horizontal = Auto.auto, vertical = 2.vmin)
                }
            )
            Text(
                text = props.profile.name,
                fontSize = 3.vmin,
                fontWeight = FontWeight.bold,
                extraStyleProperties = {
                    whiteSpace = WhiteSpace.nowrap
                    margin(top = 2.vmin)
                }
            )
        }
        main {
            css { margin(vertical = 2.vmin) }
            ColumnList(
                items = props.options
            ) { menuOption ->
                val selected = menuOption == props.selectedMenuOption
                Text(
                    text = menuOption.title,
                    fontWeight = FontWeight.bold,
                    fontSize = 2.5.vmin,
                    onClick = { props.onItemClick(menuOption) },
                    extraStyleProperties = {
                        width = 100.pct
                        height = 5.vmin
                        display = Display.inlineFlex
                        alignItems = AlignItems.center
                        cursor = "pointer".unsafeCast<Cursor>()
                        transition = "color 0.2s ease-in-out 0s".unsafeCast<Transition>()
                        if(selected) color = Colors.secondary
                        hover {
                            if(!selected) textDecoration = TextDecoration.underline
                        }
                    }
                )
            }
        }
        footer {
            css {
                margin(top = Auto.auto, bottom = 2.vmin)
                textAlign = TextAlign.center
            }
            RowList(
                items = props.profile.socials,
                justifyContent = JustifyContent.spaceEvenly,
                extraStyleProperties = {
                    margin(vertical = 2.vmin)
                }
            ) {
                LinkImage(
                    src = it.image,
                    url = it.url,
                    width = 3.vmin,
                    height = 3.vmin,
                    extraStyleProperties = {
                        filter = invert(100)
                    }
                )
            }
            Text(
                text = "© 2022 lincollincol",
                fontSize = 2.vmin
            )
        }
    }
}