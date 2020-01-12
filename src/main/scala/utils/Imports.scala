package utils

import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle

object Imports extends BootstrapStaticBundle {

  val grid = Grid.withScreenRatios(
    Grid.screenRatios
      .withSm(None) // stack on small
      .withXs(None) // and extra-small screens
  )

}
