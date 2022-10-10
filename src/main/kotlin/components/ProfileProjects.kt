package components

import csstype.*
import emotion.react.css
import model.Project
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import theme.Colors
import utils.margin
import widgets.*

fun ChildrenBuilder.ProfileProjects(projects: List<Project>) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        TitleText("Projects")
        ColumnList(
            items = projects
        ) { project ->
            ProjectItem(project)
//            LinkText(
//                text = project.name,
//                url = project.url
//            )
//            Text(project.description)
        }
    }
}

private fun ChildrenBuilder.ProjectItem(project: Project) {
    Row(
        extraStyleProperties = {
            margin(vertical = 2.vmin)
            alignItems = AlignItems.center
        }
    ) {
        if(project.image.isEmpty()) {
            Box(
                width = 12.vmin,
                height = 12.vmin,
                borderRadius = 30.pct,
                backgroundColor = Colors.primary,
                extraStyleProperties = {
                    display = Display.flex
                    justifyContent = JustifyContent.center
                    alignItems = AlignItems.center
                }
            ) {
                Text(
                    text = project.name.filter { it.isUpperCase() },
                    fontWeight = FontWeight.bold,
                    color = Colors.secondary
                )
            }
        } else {
            Image(
                src = project.image,
                width = 12.vmin,
                height = 12.vmin,
                radius = 30.pct
            )
        }
        Column(
            extraStyleProperties = { margin(horizontal = 2.vmin) }
        ) {
            LinkText(project.name, project.url, fontWeight = FontWeight.bold)
            Text(project.description, fontSize = 2.5.vmin)
        }
    }
}