package components

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import widgets.Text
import widgets.TitleText


fun ChildrenBuilder.ProfileAbout(about: String) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        TitleText("About Me")
        Text(about)
    }
}