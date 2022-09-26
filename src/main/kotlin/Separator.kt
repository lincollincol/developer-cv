import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import theme.Colors

fun ChildrenBuilder.VerticalDivider(
    color: Color = Colors.white,
    width: Length = 1.px,
    opacity: Opacity = number(0.25)
) {
    div {
        css {
            this.width = width
            this.opacity = opacity
            backgroundColor = color
            height = 100.pct
        }
    }
}