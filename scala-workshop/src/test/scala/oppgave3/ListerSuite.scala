package oppgave3

import org.scalatest._
import matchers.ShouldMatchers

class ListerSuite extends FunSuite with ShouldMatchers {

  import collection.mutable.ListBuffer

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  test("cons") {
    val consed = Nil // TODO: Implementer

    val imperative = {
      val buffer = list.toBuffer
      buffer.prepend(0)
      buffer.toList
    }

    consed should be === imperative
    consed should be === List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  }

  test("legg 1 til hvert element") {
    val plus1 = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      for (n <- list)
        buffer += n + 1
      buffer.toList
    }

    plus1 should be === imperative
    plus1 should be === List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
  }

  test("multipliser hvert element med 3") {
    val mult3 = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      for (n <- list)
        buffer += n * 3
      buffer.toList
    }

    mult3 should be === imperative
    mult3 should be === List(3, 6, 9, 12, 15, 18, 21, 24, 27, 30)
  }

  test("alle par-tall") {
    val even = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      for (n <- list)
        if (n % 2 == 0)
          buffer += n
      buffer.toList
    }

    even should be === imperative
    even should be === List(2, 4, 6, 8, 10)
  }

  test("alle odde-tall") {
    val odd = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      for (n <- list)
        if (n % 2 == 1)
          buffer += n
      buffer.toList
    }

    odd should be === imperative
    odd should be === List(1, 3, 5, 7, 9)
  }

  test("5 første") {
    val fiveFirst = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      var i = 0
      for (n <- list) if (i < 5) {
        buffer += n
        i += 1
      }
      buffer.toList
    }

    fiveFirst should be === imperative
    fiveFirst should be === List(1, 2, 3, 4, 5)
  }

  test("alle unntatt de 5 første") {
    val exceptFiveFirst = Nil // TODO: Implementer

    val imperative = {
      val buffer = new ListBuffer[Int]
      var i = 0
      for (n <- list) {
        if (i < 5)
          i+= 1
        else
          buffer += n
      }
      buffer.toList
    }

    exceptFiveFirst should be === imperative
    exceptFiveFirst should be === List(6, 7, 8, 9, 10)
  }

  test("par og oddetall på en gang (tips: partition)") {
    val (even, odd) = Nil -> Nil // TODO: Implementer

    val (imperativeOdd, imperativeEven) = {
      val odd, even = new ListBuffer[Int]
      for(n <- list)
        if(n % 2 == 0)
          even += n
        else
          odd += n
      (odd, even)
    }

    even should be === imperativeEven
    odd should be === imperativeOdd

    even should be === List(2, 4, 6, 8, 10)
    odd should be === List(1, 3, 5, 7, 9)
  }

  test("sum") {
    val sum = Nil // TODO: Implementer

    val imperative = {
      var i = list.head
      for(n <- list.tail)
        i += n
      i
    }

    imperative should be === sum
    sum should be === 55
  }

  test("produkt") {
    val prod = Nil // TODO: Implementer

    val imperative = {
      var i = 1
      for(n <- list)
        i *= n
      i
    }

    imperative should be === prod
    prod should be === 3628800
  }

  test("reverse") {
    val reversed = Nil // TODO: Implementer

    val imperative = {
      var l = List[Int]()
      for(n <- list)
        l = n :: l
      l
    }

    imperative should be === reversed
    reversed should be === list.reverse
  }

  val smallList = List(1,2,3)
  test("0 to i list") {
    val expandedList = Nil // TODO: Implementer

    val imperative = {
      var l = List[Int]()
      for(i <- smallList) {
        val range = 0 to i
        l ++= range
      }
      l
    }

    imperative should be === expandedList
    expandedList should be === List(0,1,0,1,2,0,1,2,3)
  }
}