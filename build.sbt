name := "scala-spark-examples"

organization := "home"

version := "0.1-SNAPSHOT"

scalaOrganization := "org.typelevel"

scalaVersion := "2.11.8"

libraryDependencies ++= {

  val sparkVersion = "2.3.0"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    // Test dependencies
    "org.scalatest" %% "scalatest" % "3.0.1"
  )
}
