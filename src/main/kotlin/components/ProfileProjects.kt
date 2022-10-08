package components

import csstype.*
import csstype.Image
import emotion.react.css
import model.Project
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import utils.margin
import widgets.*

fun ChildrenBuilder.ProfileProjects(projects: List<Project>) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        TitleText("Projects")
        Column(
            items = projects
        ) { project ->
            LinkText(
                text = project.name,
                url = project.url
            )
            Text(project.description)
        }
    }
}

private fun ChildrenBuilder.ProjectItem(project: Project) {

    div {
        css {
            margin(vertical = 2.vmin)
            display = Display.flex
            alignItems = AlignItems.center
        }
        Image(
            src = "",
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
            LinkText(project.name, project.url, fontWeight = FontWeight.bold)
            Text(project.description, fontSize = 2.5.vmin)
        }
    }

}