package components

import csstype.*
import emotion.react.css
import model.MenuOption
import model.Profile
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.header
import theme.Colors
import utils.margin
import widgets.*

external interface ProfileProps : Props {
    var profile: Profile
    var selectedMenuOption: MenuOption
    var options: List<MenuOption>
    var onItemClick: (MenuOption) -> Unit
}

val CvProfile = FC<ProfileProps> { props ->
    Column(
        extraStyleProperties = {
            height = 100.pct
            width = 100.pct
            color = Colors.white
        }
    ) {
        Row {
            Image(
                src = props.profile.image,
                width = 20.vmin,
                height = Auto.auto,
                radius = 50.pct,
            )
            Text(
                text = props.profile.name,
                fontSize = 3.vmin,
                fontWeight = FontWeight.bold,
                extraStyleProperties = {
                    whiteSpace = WhiteSpace.nowrap
                    margin(top = 2.vmin)
                }
            )
        }

        /** Summary */
        TitleText("About Me")
        Text(props.profile.about)

        /** Experience */
        TitleText("Professional Experience")
        props.profile.workExperience.forEach { experience ->
            WorkExperienceItem(experience)
        }

        /** Experience */
        TitleText("Skills")
        props.profile.skills.groupBy { it.group }
            .forEach { group ->
                TitleText(text = group.key, fontSize = 3.vmin)
                ColumnList(
                    items = group.value
                ) { skill ->
                    ListText(text = skill.name, fontSize = 2.5.vmin)
                }
            }

        /** Experience */
        TitleText(text = "Interesting projects")
        ColumnList(items = props.profile.projects) { ProjectItem(it) }
    }
}