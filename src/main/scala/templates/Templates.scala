package templates

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.theme.bootstrap3.HepekBootstrap3BlogPage
import ba.sake.hepek.Resources._
import utils.Imports._

// settings for BLOG static pages
trait MyBlogPage extends MyStaticPage with HepekBootstrap3BlogPage {

  override def blogSettings =
    super.blogSettings
      .withAuthor("John Doe")
      .withCreateDate(LocalDate.of(2019, 5, 5))

  override def pageHeader = None
}

// settings for ALL static pages
trait MyStaticPage extends StaticPage {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(site.Index)
      .withMainPages(site.Index, site.About)

  override def siteSettings =
    super.siteSettings
      .withName("example.com")
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon").ref)

  override def navbar = Some(Navbar)

  // custom bootstrap theme
  override def bootstrapDependencies = super.bootstrapDependencies.withCssDependencies(
    Dependencies()
      .withDeps(Dependency("spacelab/bootstrap.min.css", bootstrapSettings.version, "bootswatch"))
  )

  // custom css from /src/main/public/site/styles
  override def styleURLs = super.styleURLs :+ relTo(styles.css("main"))

  // custom js from /src/main/public/site/scripts
  override def scriptURLs = super.scriptURLs :+ relTo(scripts.js("main"))

}
