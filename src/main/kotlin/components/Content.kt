package components

import csstype.*
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import model.MenuOption
import model.Profile
import model.WorkExperience
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener
import react.ChildrenBuilder
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.strong
import theme.Colors
import utils.margin
import utils.padding
import widgets.Space

external interface ContentProps : Props {
    var profile: Profile
    var selectedMenuOption: MenuOption
}

val Content = FC<ContentProps> { props ->
    div {
        css {
            height = 100.pct
            width = "fill-available".unsafeCast<Width>()
            maxHeight = 100.pct
            fontSize = 2.vmin
            padding(horizontal = 2.vmin)
            overflowY = Overflow.scroll
            backgroundColor = Colors.surface
            color = Colors.primary
            display = Display.block
        }
        div {
            css {
                margin(vertical = 5.pct, horizontal = 15.pct)
            }
            when(props.selectedMenuOption) {
                MenuOption.About -> ProfileAbout(props.profile.about)
                MenuOption.Projects -> ProfileProjects(props.profile.projects)
                MenuOption.Skills -> ProfileSkills(props.profile.skills)
                MenuOption.WorkExperience -> ProfileWorkExperience(props.profile.workExperience)
            }
        }
    }
}
