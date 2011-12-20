package oppgave6

sealed trait Ansatt
case class Utvikler(navn:String, lønn:Int) extends Ansatt
case class Manager(navn:String, lønn:Int, tittel:String) extends Ansatt

object Ansatt {
  
  // finn lønn til ansatt
  def lønn(ansatt:Ansatt):Int = sys.error("todo")

  // summer lønn for ansatte
  def summerLønn(ansatte:List[Ansatt]):Int = sys.error("todo")

  // finn navn til ansatt
  def navn(ansatt:Ansatt):String = sys.error("todo")

  // sett lønn til ansatt
  def setLønn(kr:Int, ansatt:Ansatt):Ansatt = sys.error("todo")

  // øk lønn til ansatt med kronebeløp
  def økLønnMedKr(kr:Int, ansatt:Ansatt):Ansatt = sys.error("todo")

  // øk lønn til managers med kronebeløp
  def økLønnForManagersMedKr(kr:Int, ansatte:List[Ansatt]):List[Ansatt] = sys.error("todo")

  // øk lønn til developers med kronebeløp
  def økLønnForDevelopersMedKr(kr:Int, ansatte:List[Ansatt]):List[Ansatt] = sys.error("todo")

  // øk lønn til managers med prosent
  def økLønnForManagersMedProsent(prosent:Int, ansatte:List[Ansatt]):List[Ansatt] = sys.error("todo")

  // øk lønn til developers med prosent
  def økLønnForDevelopersMedProsent(prosent:Int, ansatte:List[Ansatt]):List[Ansatt] = sys.error("todo")
}