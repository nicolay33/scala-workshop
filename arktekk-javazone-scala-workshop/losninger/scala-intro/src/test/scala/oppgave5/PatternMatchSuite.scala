package oppgave5

import org.scalatest._
import matchers.ShouldMatchers

class PatternMatchSuite extends FunSuite with ShouldMatchers {
  
  val tree = 
    Branch(
      Branch(Leaf(1), Leaf(2)),
      Branch(Leaf(3), Branch(
        Leaf(4), Leaf(5))))
  
  test("Tree.size"){
    Tree.size(tree) should be === 5
  }
  
  test("Tree.height"){
    Tree.height(tree) should be === 3
  }
  
  test("Tree.contains"){
    Tree.contains(4, tree) should be(true)
    Tree.contains(7, tree) should be(false)
  }
}