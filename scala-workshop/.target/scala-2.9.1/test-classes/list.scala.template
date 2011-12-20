import scala.{List => _, Nil => _}

sealed trait List[+A] {
  // returnerer om listen er tom
  def isEmpty:Boolean = pending
  
  // returnerer størrelsen på listen
  def size:Int = pending
  // henter første elementet i listen (kaster exception ved tom liste)
  def head:A = pending
  
  // henter halen til listen (kaster exception ved tom liste)
  def tail:List[A] = pending
  
  // returner en ny liste ved å kalle funksjonen for hvert element i lista
  def map[B](f:A => B):List[B] = pending
  
  // legg "other" til på slutten av denne lista
  def append[AA >: A](other:List[AA]):List[AA] = pending
  
  // returnerer en ny liste vel å kalle funksjonen f for alle elementene og appende resultatene etter hverandre
  // f.eks Cons(1, Cons(2, Nil)).flatMap(a => List(a, a + 1)) == Cons(1, Cons(2, Cons(2, Cons(3, Nil))))
  def flatMap[B](f:A => List[B]):List[B] = pending
  
  // returner en liste som inneholder all elementer som er 'true' for predikatet f
  def filter(f:A => Boolean):List[A] = pending
  
  // returnerer listen reversert
  def reverse:List[A] = pending
  
  // Cons(1, Cons(2, Cons(3, Nil)).foldLeft(10)(f)
  // f(f(f(10, 1), 2), 3)
  // http://upload.wikimedia.org/wikipedia/commons/5/5a/Left-fold-transformation.png
  // @annotation.tailrec
  final def foldLeft[B](acc:B)(f:(B, A) => B):B = pending
  
  // Cons(1, Cons(2, Cons(3, Nil))).foldRight(10)(f)
  // f(3, f(2, f(3, 10)))
  // http://upload.wikimedia.org/wikipedia/commons/3/3e/Right-fold-transformation.png
  final def foldRight[B](acc:B)(f:(A, B) => B):B = pending
  
  // returnerer en liste flatet ut (om det er mulig, ellers compile error)
  // f.eks. Cons(Cons(1, Nil), Cons(2, Nil)).flatten == Cons(1, Cons(2, Nil))
  def flatten[B](implicit f:A => List[B]):List[B] = pending
  
  // returnerer summen av elementene i listen (om den inneholder nummer, ellers compile error)
  def sum[B >: A](implicit num:Numeric[B]):B = pending
}
final case class Cons[A] (x: A, xs:List[A]) extends List[A]
case object Nil extends List[Nothing]

val list = Cons(1, Cons(2, Cons(3, Nil)))
val list2 = Cons(4, Cons(5, Nil))
val nested = Cons(list, Cons(list2, Nil))
val list3 = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

def pending = error("pending")

def assertEq[A](name:String, a1:A, a2: => A){
  def msg(color:String, status:String, name:String, m:String = "") = println(color + status + " :: " + name + " " + m + Console.RESET)
  try{  
    if(a1 == a2)
      msg(Console.GREEN, "OK", name)
    else
      msg(Console.RED, "FAIL", name, a1 + " != " + a2)
  } catch {
    case e if e.getMessage == "pending" => println(Console.YELLOW + "PENDING :: " + name)
    case e => msg(Console.RED, "FAIL", name, e.getMessage)
  }
}

assertEq("isEmpty", false, list.isEmpty)
assertEq("isEmpty", true, Nil.isEmpty)
assertEq("size", 3, list.size)
assertEq("head", 1, list.head)
assertEq("tail", Cons(2, Cons(3, Nil)), list.tail)
assertEq("map", Cons(2, Cons(3, Cons(4, Nil))), list.map(1 +))
assertEq("append", list3, list.append(list2))
assertEq("flatMap", list3, nested.flatMap(identity))
assertEq("filter", Cons(2, Cons(4, Nil)), list3.filter(_ % 2 == 0))
assertEq("reverse", Cons(3, Cons(2, Cons(1, Nil))), list.reverse)
assertEq("foldLeft", 4, list.foldLeft(10)(_ - _))
assertEq("foldRight", -8, list.foldRight(10)(_ - _))
assertEq("flatten", list3, nested.flatten)
assertEq("sum", 6, list.sum)

