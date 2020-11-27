package templates

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.theme.bootstrap3.HepekBootstrap3BlogPage
import ba.sake.hepek.theme.bootstrap3.TocSettings
import ba.sake.hepek.theme.bootstrap3.TocType
import ba.sake.hepek.Resources._
import utils.Imports.Bundle._

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
      .withDeps(Dependency("readable/bootstrap.min.css", bootstrapSettings.version, "bootswatch"))
  )

  override def styleURLs = super.styleURLs.appended(styles.css("main").ref)

  override def scriptURLs = super.scriptURLs.appended(scripts.js("main").ref)
}

// settings for BLOG static pages
trait MyBlogPage extends MyStaticPage with HepekBootstrap3BlogPage {

  override def blogSettings =
    super.blogSettings
      .withAuthor("John Doe")
      .withCreateDate(LocalDate.now)

  override def pageHeader = None

  override def tocSettings = TocSettings(tocType = Some(TocType.Scrollspy(offset = 60)))
}