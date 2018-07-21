package site

import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import templates.MyBlogPage
import utils.Imports._

object Index extends MyBlogPage {

  override def pageTitle = "Hello world!"

  override def postSections = List(
    Section("First section", firstSectionContent),
    Section("Second section", scalaSectionContent)
  )

  /* CONSTS */
  val markdownURL =
    "https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet"

  /* CONTENT */
  val firstSectionContent =
    md(s"""
      This **is** some *Markdown* (read more about it [here]($markdownURL)):
        - yep
        - it works
    """)

  val scalaSectionContent =
    div(
      row(
        third1("Need help from a real programming language?"),
        third2(
          "Have it check you can properly nest these rows, columns etc?"
        ),
        third3(
          ul(
            List("How", "awesome", "is", "that?").map(s => li(s))
          )
        )
      ),
      row(
        md(s"""
            Sections, Table of Contents, PDFs? Trivial.  
            Relative links with no hassle? You got it!
        """),
        hyperlink(relTo(About))("Click here!")
      )
    )

  // add footer
  /*
    override def pageContent =
    frag(
      super.pageContent,
      div(cls := "well well-lg col-md-8 col-md-push-2")(
        md("Override template stuff. Wow! :D")
      )
    )
 */
}
