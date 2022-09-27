package components

import csstype.*
import emotion.react.css
import model.MenuOption
import model.Profile
import react.ChildrenBuilder
import react.FC
import react.Props
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.footer
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import theme.*

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
            img {
                css {
                    width = 75.pct
                    borderRadius = 50.pct
                    marginTop = 2.vmin
                    marginBottom = 2.vmin
                    display = Display.block
                    marginLeft = Auto.auto
                    marginRight = Auto.auto
                }
                src = props.profile.image
            }
            span {
                css {
                    fontSize = 3.vmin
                    marginTop = 2.vmin
                    fontWeight = FontWeight.bold
                    whiteSpace = WhiteSpace.nowrap
                }
                +props.profile.name
            }
        }
        main {
            css {
                marginTop = 2.vmin
                marginBottom = 2.vmin
            }
            div {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                }
                props.options.forEach {
                    MenuOptionItem(it, it == props.selectedMenuOption) { props.onItemClick(it) }
                }
            }
        }
        footer {
            css {
                marginTop = Auto.auto
                textAlign = TextAlign.center
                fontSize = 2.vmin
            }
            div {
                css {
                    display = Display.flex
                    justifyContent = JustifyContent.spaceEvenly
                }
                props.profile.socials.forEach {
                    a {
                        href = it.url
                        target = AnchorTarget._blank
                        img {
                            css {
                                filter = invert(100)
                                width = 3.vmin
                                height = 3.vmin
                            }
                            src = it.image
                        }
                    }
                }
            }
            p {
                +"© 2022 lincollincol"
            }
        }
    }
}

private fun ChildrenBuilder.MenuOptionItem(
    option: MenuOption,
    selected: Boolean,
    onClick: () -> Unit
) {
    span {
        css {
            width = 100.pct
            height = 5.vmin
            fontSize = 2.5.vmin
            fontWeight = FontWeight.bold
            display = Display.inlineFlex
            alignItems = AlignItems.center
            cursor = "pointer".unsafeCast<Cursor>()
            transition = "all 0.2s ease-in-out 0s".unsafeCast<Transition>()
            if(selected) color = Colors.secondary
            hover {
                if(!selected) textDecoration = TextDecoration.underline
            }
        }
        this.onClick = { onClick() }
        +option.title
    }
}