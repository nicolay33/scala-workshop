package oppgave1

/**
 * Se testklassen PersonSuite for forventet oppførsel.
 *
 * a) Lag klassen Person som tar navn som konstruktør argument
 *
 * b) Implementer metoden hi(who:String):String som returnerer en hilsen
 *
 * c) Flytt funksjonaliteten for "hi" ut i en trait "Hi"
 *
 * d) I Hi traiten, lag metoden "upperHi" som alltid svarer det samme som "hi", men i uppercase
 *
 * e) Lag traiten "Friendly" som extender Hi (bruk f.eks collection.mutable.ListBuffer[String] for å representere venner).
 *    Override metoden "hi" så den gir en vennligere hilsen til venner
 *
 * f) Verifiser at testen "f) Friendly uppercase" kjører grønt. Hvis ikke, kan du gjenbruke eksisterende funksjonalitet?
 *
 * g) Lag companion object med "factory metoder" for å opprette en Friendly og "vanlig" Person
 */

trait Hi {

  def name:String

  def hi(who:String):String = "Hi " + who + ", my name is " + name

  def upperHi(who:String) = hi(who).toUpperCase
}

trait Friendly extends Hi {
  import collection.mutable.ListBuffer

  val friends = new ListBuffer[String]

  override def hi(who: String) = if(friends.contains(who)) "Hi "+who+", what's up?" else super.hi(who)
}

class Person(val name:String) extends Hi

object Person {
  def regular(name:String) = new Person(name)

  def friendly(name:String) = new Person(name) with Friendly
}