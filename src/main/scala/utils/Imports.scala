package utils

import ba.sake.hepek.html.component.BasicComponents
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle

object Imports extends BootstrapStaticBundle with BasicComponents {

  object grid extends Grid {

    override def screenRatios =
      super.screenRatios
        .withSm(None) // stack divs on small screens :)
        .withXs(None)
  }

}
