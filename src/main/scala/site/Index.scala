package site

import utils.Bundle._, Grid._, Tags.*

object Index extends templates.MyBlogPage {

  override def pageSettings =
    super.pageSettings.withTitle("Hello world!")

  override def blogSettings =
    super.blogSettings.withSections(firstSection, secondSection)

  /* CONTENT */
  val firstSection = Section(
    "First section",
    s"""
      This is some *Markdown*:
      - yep
      - it **works**
      - *italics*
      - `def code()`
      
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in tempus sem, sed interdum tortor. Fusce et interdum dolor. Integer tristique lacus nunc, eget vulputate nulla porta tempor. Ut molestie eu mi pharetra gravida. Quisque sit amet nibh felis. Sed congue in ante vehicula maximus. Morbi volutpat id urna sit amet tempor. Curabitur vel diam et orci mollis tempor sed ac lacus. Aenean tempus nisi in congue sollicitudin. Morbi rhoncus nisl eget nulla suscipit, sed lacinia lorem volutpat. Suspendisse potenti. Aliquam id mi elementum, mollis mauris et, gravida nisi. Praesent nec ex quam. Suspendisse sagittis molestie nisl.
    """.md
  )

  val secondSection = Section(
    "Second section",
    div(
      row(
        third("Need help from a real programming language?"),
        third("Have it check you can properly nest these rows, columns etc?"),
        third(
          ul(
            List("How", "awesome", "is", "that?").map(s => li(s))
          )
        )
      ),
      row(
        s"""
          Sections, Table of Contents, PDFs? Trivial.  
          Relative links with no hassle? You got it!
          [Click here!](${About.ref})

          Docs? [here](https://sake92.github.io/hepek/index.html)  
          Examples? [here](https://github.com/sake92/hepek-examples)
        """.md
      )
    )
  )
}
