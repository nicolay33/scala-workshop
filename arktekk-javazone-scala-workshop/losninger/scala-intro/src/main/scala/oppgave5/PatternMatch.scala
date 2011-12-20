package oppgave5

sealed trait Tree
case class Branch(left:Tree, right:Tree) extends Tree
case class Leaf(value:Int) extends Tree

object Tree {

  def size(tree:Tree):Int = tree match {
    case Leaf(_) => 1
    case Branch(left, right) => size(left) + size(right)
  }
  
  def height(tree:Tree):Int = tree match {
    case Leaf(_) => 0
    case Branch(left, right) => 1 + (height(left) max height(right))
  }
  
  def contains(value:Int, tree:Tree):Boolean = tree match {
    case Leaf (v) => v == value
    case Branch(left, right) => contains(value, left) || contains(value, right)
  }
}