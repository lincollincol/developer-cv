package widgets

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import theme.Colors

fun ChildrenBuilder.Space(
    width: Length = 0.px,
    height: Length = 0.px,
) {
    div {
        css {
            this.width = width
            this.height = height
        }
    }
}