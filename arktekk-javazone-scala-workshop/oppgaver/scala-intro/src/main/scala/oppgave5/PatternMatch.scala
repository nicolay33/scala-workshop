package oppgave5

sealed trait Tree
case class Branch(left:Tree, right:Tree) extends Tree
case class Leaf(value:Int) extends Tree

object Tree {

  def size(tree:Tree):Int = sys.error("todo")

  def height(tree:Tree):Int = sys.error("todo")

  def contains(value:Int, tree:Tree):Boolean = sys.error("todo")
}