package components

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import widgets.Column
import widgets.Text
import widgets.TitleText


fun ChildrenBuilder.ProfileAbout(about: String) {
    Column {
        TitleText("About Me")
        Text(about)
    }
}