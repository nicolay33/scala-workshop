package oppgave2

import org.scalatest._
import matchers.ShouldMatchers

class SultneDyrSuite extends FunSuite with ShouldMatchers {
  
  val dyretSier = Map("Dog" -> "Woof", "Cat" -> "Meow", "Cow" -> "Mooh")
  val berOmMat = Map("Woof" -> "Meat", "Meow" -> "Fish", "Mooh" -> "Grass")
  
  val sultneDyr = new SultneDyr(dyretSier, berOmMat)
  
  /* A */
  
  for((dyr, sier) <- dyretSier){
    test(dyr + " skal si " + sier){
      sultneDyr.hvaSier(dyr) should be(Some(sier))
    }
    test(dyr + " skal også si " + sier.toUpperCase){
      sultneDyr.HVA_SIER(dyr) should be(Some(sier.toUpperCase))
    }
  }
    
  test("ukjent dyr sier None"){
    dyretSier.keys.foreach(k => sultneDyr.hvaSier("ikkeEn"+k) should be(None))
  }    
  
  test("ukjent dyr SIER None"){
    dyretSier.keys.foreach(k => sultneDyr.HVA_SIER("ikkeEn"+k) should be(None))
  }

  /* B */
  
  test("Dog spiser Meat"){
    sultneDyr.hvaSpiser("Dog") should be(Some("Meat"))
  }
  
  test("Cat spiser Fish"){
    sultneDyr.hvaSpiser("Cat") should be(Some("Fish"))
  }
  
  test("Cow spiser Grass"){
    sultneDyr.hvaSpiser("Cow") should be(Some("Grass"))
  }
  
  /* C */
  test("Hva spiser de dyrene vi vet om"){
    val expected = List("Dog sier Woof og liker Meat", "Cat sier Meow og liker Fish", "Cow sier Mooh og liker Grass")
    sultneDyr.hvaSpiserDeViVetOm("ukjent1" :: "ukjent2" :: dyretSier.keys.toList) should be === expected
  }
  
  /* D */
  test("HVA_SPISER"){
    sultneDyr.HVA_SPISER("Dog") should be(Some("MEAT"))
    sultneDyr.HVA_SPISER("Cat") should be(Some("FISH"))
    sultneDyr.HVA_SPISER("Horse") should be(None)
  }
  
}