package components

import csstype.*
import emotion.react.css
import model.WorkExperience
import react.ChildrenBuilder
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.strong
import theme.Colors

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
            marginTop = 2.vmin
            marginBottom = 2.vmin
            display = Display.flex
            whiteSpace = WhiteSpace.nowrap
            alignItems = AlignItems.center
        }
        img {
            css {
                width = 10.vmin
                height = 10.vmin
                borderRadius = 30.pct
                objectFit = ObjectFit.contain
                backgroundColor = Colors.white
            }
            src = experience.image
        }
        div {
            css {
                display = Display.flex
                flexDirection = FlexDirection.column
                marginLeft = 2.vmin
                marginRight = 2.vmin
            }
            strong {
                css { fontSize = 3.vmin }
                +experience.company
            }
            span {
                css { fontSize = 2.vmin }
                +experience.dates
            }
            span {
                css { fontSize = 2.vmin }
                +experience.role
            }
        }
    }
}