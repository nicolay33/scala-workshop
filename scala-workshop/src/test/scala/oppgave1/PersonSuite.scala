package oppgave1

import org.scalatest._
import matchers.ShouldMatchers

class PersonSuite extends FunSuite with ShouldMatchers {

  /*
  test("a) person"){
    val person = new Person("A")
    person.name should be("A")
  }

  test("b) hi metode"){
    val person = new Person("A")
    person.hi("B") should be("Hi B, my name is A")
  }

  test("c) Hi.hi"){
    val person:Hi = new Person("A")
    person.hi("B") should be("Hi B, my name is A")
  }

  test("d) UpperCase hi"){
    val person = new Person("A")
    person.upperHi("B") should be(person.hi("B").toUpperCase)
  }

  test("e) Friendly"){
    val person = new Person("A") with Friendly
    person.friends += "C"

    person.hi("B") should be("Hi B, my name is A")
    person.hi("C") should be("Hi C, what's up?")
  }

  test("f) Friendly uppercase"){
    val person = new Person("A") with Friendly
    person.friends += "C"

    person.upperHi("C") should be("HI C, WHAT'S UP?")
  }

  test("g) Companion object"){
    val person = Person.regular("A")

    person.hi("B") should be("Hi B, my name is A")
    person.hi("C") should be("Hi C, my name is A")

    val friendly = Person.friendly("A")
    friendly.friends += "C"

    friendly.hi("B") should be("Hi B, my name is A")
    friendly.hi("C") should be("Hi C, what's up?")
  }
  */
}