package site

import scalatags.Text.all._
import utils.Imports._

object About extends templates.MyStaticPage {

  override def pageSettings =
    super.pageSettings.withTitle("About")

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("About")
    ),
    div(cls := "well well-lg ")(
      s"""
        About me...  TODO :p

        This is a custom page, using a different template (also called layout in other SSGs).
        
        Here's a typesafe link to [second section](${Index.secondSection.ref}) (almost impossible to make a mistake! :D)
      """.md
    )
  )

}
