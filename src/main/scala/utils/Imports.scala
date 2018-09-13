package utils

import ba.sake.hepek.html.component.BasicComponents
import ba.sake.hepek.Resources
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents

object Imports extends BasicComponents {

  object grid extends BootstrapGridComponents {

    override def screenRatios =
      super.screenRatios
        .withSm(None) // stack divs on small screens :)
        .withXs(None)
  }

  object resources extends Resources

}
