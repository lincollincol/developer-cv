package components

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span


fun ChildrenBuilder.ProfileAbout(about: String) {
    div {
        css {
            width = 70.pct
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        p {
            css {
                fontSize = 6.vmin
                fontWeight = FontWeight.bold
            }
            +"About Me"
        }
        span {
            css {
                fontSize = 3.vmin
            }
            +about
        }
    }
}