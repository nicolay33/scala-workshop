package oppgave6

import org.scalatest._
import matchers.ShouldMatchers

class FPSuite extends FunSuite with ShouldMatchers {
  
  val ansatte:List[Ansatt] = 
    Manager("Man1", 100, "Chief Officer") ::
    Manager("Man2", 120, "Second in Command") ::
    Utvikler("Dev1", 90) :: 
    Utvikler("Dev2", 110) :: Nil    
  
  def split(ansatte:List[Ansatt]) = ansatte.take(2) -> ansatte.takeRight(2)  
  
  val managers = ansatte.take(2)
  val developers = ansatte.takeRight(2)
  
  test("finn lønn til ansatt"){
    for((lønn, ansatt) <- List(100, 120, 90, 110).zip(ansatte))
      Ansatt.lønn(ansatt) should be === lønn
  }
  
  test("summer lønsnutgifter"){
    Ansatt.summerLønn(ansatte) should be(100 + 120 + 90 + 110)
  }
  
  test("finn navn til ansatt"){
    for((navn, ansatt) <- List("Man1", "Man2", "Dev1", "Dev2").zip(ansatte))
      Ansatt.navn(ansatt) should be === navn
  }
  
  test("sett lønn til ansatt"){
    for((ansatt, ny) <- ansatte.zip(List(1,2,3,4)))
      Ansatt.lønn(Ansatt.setLønn(ny, ansatt)) should be === ny
  }
  
  test("øk lønn til ansatt med kronebeløp"){
    for((ansatt, kr) <- ansatte.zip(List(1,2,3,4))){
      val økt = Ansatt.økLønnMedKr(kr, ansatt)
      Ansatt.lønn(økt) should be === (Ansatt.lønn(ansatt) + kr)
    }
  }
  
  test("øk lønn til managers med kronebeløp"){
    val (m, d) = split(Ansatt.økLønnForManagersMedKr(10, ansatte))    
    d should be === developers
    m should be === (Manager("Man1", 110, "Chief Officer") :: Manager("Man2", 130, "Second in Command") :: Nil)
  }
  
  test("øk lønn til developers med kronebeløp"){
    val (m, d) = split(Ansatt.økLønnForDevelopersMedKr(20, ansatte))    
    d should be === (Utvikler("Dev1", 110) :: Utvikler("Dev2", 130) :: Nil)
    m should be === managers
  }
  
  test("øk lønn til managers med prosent"){
    val (m, d) = split(Ansatt.økLønnForManagersMedProsent(10, ansatte))    
    d should be === developers
    m should be === (Manager("Man1", 110, "Chief Officer") :: Manager("Man2", 132, "Second in Command") :: Nil)
  }
  
  test("øk lønn til developers med prosent"){
    val (m, d) = split(Ansatt.økLønnForDevelopersMedProsent(20, ansatte))    
    d should be === (Utvikler("Dev1", 108) :: Utvikler("Dev2", 132) :: Nil)
    m should be === managers
  }
}