package site

import scalatags.Text.all._
import ba.sake.hepek.prismjs.PrismDependencies
import templates.MyStaticPage
import utils.Imports._

object About extends MyStaticPage with PrismDependencies {

  override def prismTheme = "prism-twilight"

  override def pageTitle = "About"

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("About")
    ),
    row(
      half1(
        div(cls := "well well-lg ")(
          md("""
          About me...  TODO :p

          This page is using a different template, isn't a blog post. :)
        """)
        )
      ),
      half2(
        "Highlight code with prismjs:",
        chl.scala.withLineHighlight("4,8")(
          """
            // Define a set of case classes for representing binary trees.
            sealed abstract class Tree
            case class Node(elem: Int, left: Tree, right: Tree) extends Tree
            case object Leaf extends Tree

            // Return the in-order traversal sequence of a given tree.
            def inOrder(t: Tree): List[Int] = t match {
              case Node(e, l, r) => inOrder(l) ::: List(e) ::: inOrder(r)
              case Leaf          => List()
            }
          """
        )
      )
    )
  )

}
