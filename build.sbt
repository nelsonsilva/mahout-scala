name := "hello"

version := "1.0"

scalaVersion := "2.9.1"

checksums in update := Nil

libraryDependencies ++= Seq(
	"org.apache.mahout" % "mahout-core" % "0.5"
)
