package site

import java.time.LocalDate
import ba.sake.hepek.theme.bootstrap5.*
import ba.sake.hepek.Resources.*
import Bundle._

trait MyStaticPage extends StaticPage {

  override def staticSiteSettings = super.staticSiteSettings
    .withIndexPage(site.Index)
    .withMainPages(site.Index, site.About)

  override def siteSettings = super.siteSettings
    .withName("myblog.com")
    .withFaviconNormal(images.ico("favicon").ref)
    .withFaviconInverted(images.ico("favicon").ref)

  override def navbar = Some(Navbar)

  // custom bootstrap theme
  override def bootstrapDependencies = super.bootstrapDependencies
    .withCssDependencies(
      Dependencies().withDeps(Dependency("dist/flatly/bootstrap.min.css", bootstrapSettings.version, "bootswatch"))
    )

  override def styleURLs = super.styleURLs
    .appended(styles.css("main").ref)

  override def scriptURLs = super.scriptURLs
    .appended(scripts.js("main").ref)
}

trait MyBlogPage extends MyStaticPage with HepekBootstrap5BlogPage {

  override def blogSettings = super.blogSettings
    .withAuthor("John Doe")
    .withCreatedDate(LocalDate.of(2023, 1, 1))

  override def pageHeader = None

  override def tocSettings = Some(TocSettings(tocType = TocType.Scrollspy(offset = 60)))
}
