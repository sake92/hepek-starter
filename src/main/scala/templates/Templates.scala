package templates

import java.time.LocalDate
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents
import ba.sake.hepek.theme.bootstrap3.HepekBootstrap3BlogPage
import ba.sake.hepek.html.structure._
import ba.sake.hepek.html.component._
import utils.Imports._, resources._

// settings for BLOG static pages
trait MyBlogPage extends MyStaticPage with HepekBootstrap3BlogPage {
  override def postAuthor     = Option("Post Author")
  override def postCreateDate = Option(LocalDate.now)
}

// settings for ALL static pages
trait MyStaticPage extends BootstrapStaticPage with BootstrapGridComponents {

  override def siteSettings = SiteSettings(
    "hello.world",
    site.Index,
    List(site.Index, site.About),
    Option(relTo(images.ico("favicon"))),
    Option(relTo(images.ico("favicon")))
  )

  // custom css from /src/main/public/site/styles
  override def styleURLs = super.styleURLs :+ relTo(styles.css("main"))

  // custom js from /src/main/public/site/scripts
  override def scriptURLs = super.scriptURLs :+ relTo(scripts.js("main"))

  // stack divs on small screens :)
  override def screenRatios = super.screenRatios.copy(
    sm = None,
    xs = None
  )

}
