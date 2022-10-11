package components

import csstype.*
import emotion.react.css
import model.Skill
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import widgets.Column
import widgets.ColumnList
import widgets.ListText
import widgets.TitleText

fun ChildrenBuilder.ProfileSkills(skills: List<Skill>) {
    Column {
        TitleText("Skills")
        skills.groupBy { it.group }
            .forEach { group ->
                TitleText(text = group.key, fontSize = 3.vmin)
                ColumnList(
                    items = group.value
                ) { skill ->
                    ListText(text = skill.name, fontSize = 2.5.vmin)
                }
            }
    }
}