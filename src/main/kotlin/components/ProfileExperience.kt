package components

import csstype.*
import emotion.react.css
import model.WorkExperience
import react.ChildrenBuilder
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.strong

fun ChildrenBuilder.ProfileWorkExperience(workExperience: List<WorkExperience>) {
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
            +"Jobs history"
        }
        workExperience.forEach { experience ->
            WorkExperienceItem(experience)
        }
    }
}

private fun ChildrenBuilder.WorkExperienceItem(experience: WorkExperience) {
    div {
        css {
            fontSize = 3.vmin
            display = Display.flex
            flexDirection = FlexDirection.column
            whiteSpace = WhiteSpace.nowrap
//            backgroundColor = Colors.indigo
        }
        div {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
//                backgroundColor = Colors.gold
            }
            strong { +experience.company }
            strong { +experience.dates }
        }
        span { +experience.role }
    }
}