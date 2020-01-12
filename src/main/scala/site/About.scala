package site

import scalatags.Text.all._
import utils.Imports._, Classes._

object About extends templates.MyStaticPage {

  override def pageSettings =
    super.pageSettings.withTitle("About")

  override def pageContent =
    div(cls := "well well-lg", txtAlignCenter)(
      s"""
        ## About me...  TODO

        This is a custom page, using a different template.
        
        Here's a typesafe link to [second section](${Index.secondSection.ref}) 
        (almost impossible to make a mistake! :D)
      """.md
    )

}
