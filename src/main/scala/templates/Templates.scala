package templates

import java.time.LocalDate
import ba.sake.hepek.html.structure.{Dependencies, Dependency}
import ba.sake.hepek.theme.bootstrap3.HepekBootstrap3BlogPage
import utils.Imports._, resources._

// settings for BLOG static pages
trait MyBlogPage extends MyStaticPage with HepekBootstrap3BlogPage {
  override def blogSettings =
    super.blogSettings
      .withAuthor("Post Author")
      .withCreateDate(LocalDate.now)
}

// settings for ALL static pages
trait MyStaticPage extends StatikPage {

  override def siteSettings =
    super.siteSettings
      .withName("example.com")
      .withIndexPage(site.Index)
      .withMainPages(site.Index, site.About)
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon").ref)

  // custom css from /src/main/public/site/styles
  override def styleURLs = super.styleURLs :+ relTo(styles.css("main"))

  override def bootstrapDependencies = super.bootstrapDependencies.withCssDependencies(
    Dependencies()
      .withDeps(Dependency("darkly/bootstrap.min.css", bootstrapSettings.version, "bootswatch"))
  )

  // custom js from /src/main/public/site/scripts
  override def scriptURLs = super.scriptURLs :+ relTo(scripts.js("main"))
}
