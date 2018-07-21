package site

import scalatags.Text.all._
import templates.MyStaticPage
import utils.Imports._

object About extends MyStaticPage {

  override def pageTitle = "About"

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("About")
    ),
    div(cls := "well well-lg ")(
      md("""
        About me...  TODO :p

        This is a custom page, using a different template (also called layout in other SSGs).
      """)
    )
  )

}
