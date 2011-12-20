package oppgave4

import org.scalatest._
import matchers.ShouldMatchers

class For extends FunSuite with ShouldMatchers {

  test("Filtrer en liste med tall og produser en ny liste med kun oddetall"){
    val xs = List(1,2,3,4,5,6,7,8,9,10)

    val oddetall = Nil // TODO: Implementer

    oddetall should be(List(1,3,5,7,9))
  }

  case class Adresse(postnr:String, gate:Option[String])
  case class Person(navn:String, adresse:Option[Adresse])
  test("Hent alle gatenavn, ved hjelp av en for comprehension"){
    val personer = List(
      Person("Kristian", Some(Adresse("0010", Some("Fyrstikkalleen 17")))),
      Person("Trygve", Some(Adresse("0350", Some("Sinsenkrysset")))),
      Person("Jon-Anders", Some(Adresse("0370", None))),
      Person("Thor Åge", None)
    )

    val gatenavn = Nil // TODO: Implementer

    gatenavn should be(List("Fyrstikkalleen 17", "Sinsenkrysset"))
  }

  test("Finn sidene for alle trekanter der alle sider er <= 3."){
    val lengder = Nil // TODO: Implementer

    val expected = Set((1,1,1), (2,1,1), (2,2,1), (2,2,2), (3,1,1), (3,2,1), (3,2,2), (3,3,1), (3,3,2), (3,3,3))
    expected should be(lengder.toSet)
  }

  test("Finn sidene for alle trekanter der alle sider er <= 10 og omktretsen == 24"){
    val lengder = Nil // TODO: Implementer

    val expected = Set((8,8,8), (9,8,7), (9,9,6), (10,7,7), (10,8,6), (10,9,5), (10,10,4))
    expected should be(lengder.toSet)
  }

  test("Pytagoras (a^2 + b^2 = c^2): Finn sidene for rettvinklete trekanter der alle sider er <= 10 og omkretsen er 24"){

    // Tips: a^2 skrives math.pow(a, 2)
    import math.pow

    val py = Nil // TODO: Implementer

    py should be(Vector((6,8,10)))
  }
}