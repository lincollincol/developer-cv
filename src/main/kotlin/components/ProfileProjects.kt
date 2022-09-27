package components

import csstype.*
import emotion.react.css
import model.Project
import model.Skill
import react.ChildrenBuilder
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span

fun ChildrenBuilder.ProfileProjects(projects: List<Project>) {
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
            +"Projects"
        }
        projects.forEach { project ->
            ProjectItem(project)
        }
    }
}

private fun ChildrenBuilder.ProjectItem(project: Project) {
    div {
        css {
            fontSize = 3.vmin
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        a {
            href = project.url
            target = AnchorTarget._blank
            +project.name
        }
        span { +project.description }
    }
}