package site

import scalatags.Text.all._
import utils.Imports.Bundle._, Classes._

object About extends templates.MyStaticPage {

  override def pageSettings =
    super.pageSettings.withTitle("About")

  override def pageContent =
    Panel.panel(
      Panel.Companion.Type.Info,
      s"""
        This is a custom page, using a different template.
        
        Here's a typesafe link to [second section](${Index.secondSection.ref}) 
        (almost impossible to make a mistake! :D)
      """.md,
      header = Some("About me")
    )

}
