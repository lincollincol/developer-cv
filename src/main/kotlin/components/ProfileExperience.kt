package components

import csstype.*
import emotion.react.css
import model.WorkExperience
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.li
import theme.Colors
import utils.margin
import widgets.*

fun ChildrenBuilder.ProfileWorkExperience(workExperience: List<WorkExperience>) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        TitleText("Jobs history")
        workExperience.forEach { experience ->
            WorkExperienceItem(experience)
        }
    }
}

private fun ChildrenBuilder.WorkExperienceItem(workExperience: WorkExperience) {
    div {
        css {
//            margin(vertical = 2.vmin)
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        div {
            css {
                margin(vertical = 2.vmin)
                display = Display.flex
                alignItems = AlignItems.center
            }
            Image(
                src = workExperience.image,
                width = 12.vmin,
                height = 12.vmin,
                radius = 30.pct
            )
            div {
                css {
                    margin(horizontal = 2.vmin)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                }
                LinkText(workExperience.company, "", fontWeight = FontWeight.bold)
                Text(workExperience.dates, fontSize = 2.5.vmin)
                Text(workExperience.role, fontSize = 2.5.vmin)
            }
        }
        Column(
            items = workExperience.responsibilities,
            extraStyleProperties = { margin(left = 14.vmin) }
        ) {
            ListText(it.name, fontSize = 2.5.vmin)
        }
    }
}