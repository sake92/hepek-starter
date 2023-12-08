
import $ivy.`ba.sake::mill-hepek::0.0.2`

import mill._
import mill.scalalib._
import ba.sake.millhepek.MillHepekModule

object site extends MillHepekModule with SbtModule {

  def scalaVersion = "3.3.1"

  def ivyDeps = Agg(
    ivy"ba.sake::hepek:0.18.0"
  )

}
