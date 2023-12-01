package utils

import java.time.LocalDate
import ba.sake.hepek.theme.bootstrap5.*

trait MyBlogPage extends MyStaticPage with HepekBootstrap5BlogPage {

  override def blogSettings = super.blogSettings
    .withAuthor("John Doe")
    .withCreatedDate(LocalDate.of(2023, 1, 1))

  override def pageHeader = None

  override def tocSettings = 
    Some(TocSettings(tocType = TocType.Scrollspy(offset = 60)))
}
