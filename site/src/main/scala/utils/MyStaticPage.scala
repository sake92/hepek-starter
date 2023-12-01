package utils

import ba.sake.hepek.Resource
import Bundle._

trait MyStaticPage extends StaticPage {

  override def staticSiteSettings = super.staticSiteSettings
    .withIndexPage(files.Index)
    .withMainPages(files.Index, files.About)

  override def siteSettings = super.siteSettings
    .withName("myblog.com")
    .withFaviconNormal(Resource("images/favicon.ico").ref)
    .withFaviconInverted(Resource("images/favicon.ico").ref)

  override def navbar = Some(Navbar)

  // custom bootstrap theme
  override def bootstrapDependencies = super.bootstrapDependencies
    .withCssDependencies(
      Dependencies().withDeps(Dependency("dist/flatly/bootstrap.min.css", bootstrapSettings.version, "bootswatch"))
    )

  override def styleURLs = super.styleURLs
    .appended(Resource("styles/main.css").ref)

  override def scriptURLs = super.scriptURLs
    .appended(Resource("styles/main.js").ref)
}
