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
import widgets.Image
import widgets.LinkText
import widgets.Text
import widgets.TitleText

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
                width = 10.vmin,
                height = 10.vmin,
                radius = 30.pct
            )
            div {
                css {
                    margin(horizontal = 2.vmin)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                }
                LinkText(workExperience.company, "", fontWeight = FontWeight.bold)
                Text(workExperience.dates, fontSize = 2.vmin)
                Text(workExperience.role, fontSize = 2.vmin)
            }
        }
        div {
            css { margin(left = 12.vmin) }
            workExperience.responsibilities.forEach {
                li { +it.name }
            }
        }
    }
}