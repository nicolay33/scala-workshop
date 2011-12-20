package oppgave6

sealed trait Ansatt
case class Utvikler(navn:String, lønn:Int) extends Ansatt
case class Manager(navn:String, lønn:Int, tittel:String) extends Ansatt

object Ansatt {
  
  // finn lønn til ansatt
  def lønn(ansatt:Ansatt):Int = //sys.error("todo")
    cata(_.lønn, _.lønn)(ansatt)
  
  // summer lønn for ansatte
  def summerLønn(ansatte:List[Ansatt]):Int = //sys.error("todo")
    ansatte.foldLeft(0)(_ + lønn(_))
  
  // finn navn til ansatt
  def navn(ansatt:Ansatt):String = //sys.error("todo")
    cata(_.navn, _.navn)(ansatt)
  
  // sett lønn til ansatt
  def setLønn(kr:Int, ansatt:Ansatt):Ansatt = //sys.error("todo")
    cata(utvLønn(_ => kr), manLønn(_ => kr))(ansatt)
  
  // øk lønn til ansatt med kronebeløp
  def økLønnMedKr(kr:Int, ansatt:Ansatt):Ansatt = //sys.error("todo")
    cata(utvLønn(økKr(kr)), manLønn(økKr(kr)))(ansatt)
  
  // øk lønn til managers med kronebeløp
  def økLønnForManagersMedKr(kr:Int, ansatte:List[Ansatt]):List[Ansatt] = //sys.error("todo")
    ansatte.map(cata(identity, manLønn(økKr(kr))))
  
  // øk lønn til developers med kronebeløp
  def økLønnForDevelopersMedKr(kr:Int, ansatte:List[Ansatt]):List[Ansatt] = //sys.error("todo")
    ansatte.map(cata(utvLønn(økKr(kr)), identity))
  
  // øk lønn til managers med prosent
  def økLønnForManagersMedProsent(prosent:Int, ansatte:List[Ansatt]):List[Ansatt] = //sys.error("todo")
    ansatte.map(cata(identity, manLønn(økProsent(prosent))))
  
  // øk lønn til developers med prosent
  def økLønnForDevelopersMedProsent(prosent:Int, ansatte:List[Ansatt]):List[Ansatt] = //sys.error("todo")
    ansatte.map(cata(utvLønn(økProsent(prosent)), identity))

  // expression problem. Skalere koden ved å legge til operasjoner vs legge til typer
  // hva er felles mellom de forskjellige metodene, hva er likt ?
  // hvor mye kan vi gjenbruke/parametrisere
  
  def cata[A](u:Utvikler => A, m:Manager => A)(ansatt:Ansatt):A = ansatt match {
    case utvikler:Utvikler => u(utvikler)
    case manager:Manager => m(manager)
  }  
  def utvLønn(f:Int => Int) = (u:Utvikler) => u.copy(lønn = f(u.lønn))
  def manLønn(f:Int => Int) = (m:Manager) => m.copy(lønn = f(m.lønn))
  def økKr(kr:Int):Int => Int = kr+ 
  def økProsent(prosent:Int):Int => Int = i => (i * (prosent / 100.0 + 1)).toInt
}