package oppgave2

/**
 * Eksempler på constructor parametere:
 * val dyretSier = Map("Dog" -> "Woof", "Cat" -> "Meow", "Cow" -> "Mooh")
 * val berOmMat = Map("Woof" -> "Meat", "Meow" -> "Fish", "Mooh" -> "Grass")
 * *
 *
 * HINT!!! Følg metode signaturene for Map.get og Option (spesielt .map og .flatMap)
 *
 * Map[A, B]
 *  def get(a:A):Option[B]
 *
 * Option[A]
 *    def flatMap[B](f:A => Option[B]):Option[B]
 *    def map[B](f:A => B):Option[B]
 *
 */
class SultneDyr(dyretSier:Map[String, String], berOmMat:Map[String, String]) {

  // TODO: Returner Some med hva dyret sier om det finnes, eller None hvis det ikke finnes"
  def hvaSier(dyr:String):Option[String] = // sys.error("todo")
    dyretSier.get(dyr)
  
  // TODO: Returner Some med med hva dyret sier i UpperCase hvis det finnes, eller None hvis det ikke finnes
  def HVA_SIER(dyr:String):Option[String] = //sys.error("todo")
    hvaSier(dyr).map(n => n.toUpperCase)
  
  // TODO: Returner Some med hva dyret spiser om det finnes, eller None hvis det ikke finnes
  def hvaSpiser(dyr:String):Option[String] = //sys.error("todo")
    dyretSier.get(dyr).flatMap(
      sier => berOmMat.get(sier))

  // TODO: Returner List med en setning som beskriver hva de dyrene vi kjenner til sier og spiser
  def hvaSpiserDeViVetOm(dyrene:List[String]):List[String] = // sys.error("todo")
    dyrene.flatMap(dyr =>
      dyretSier.get(dyr).flatMap(sier =>
        berOmMat.get(sier).map(mat =>
          dyr + " sier " + sier + " og liker " + mat)))

  // TODO: Returner Some med uppercase hva dyret spiser om det finnes, eller None hvis det ikke finnes, (benytt metoden .toUpperCase på String)
  def HVA_SPISER(dyr:String):Option[String] = // sys.error
    hvaSpiser(dyr).map(n => n.toUpperCase)
}