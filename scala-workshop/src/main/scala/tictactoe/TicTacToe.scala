package tictactoe

import xml.{NodeSeq}

object Player {
  def opposite(player:Player) = player match {
    case Nought => Crosses
    case _ => Nought
  }

  def fromString(n:String) = n match {
    case "x" => Crosses
    case "o" => Nought
  }
}

sealed trait Player

case object Nought extends Player

case object Crosses extends Player

case class Mark(where: Int, by: Player)

case class Game(noughts: String, crosses: String, marks: List[Mark])

object Game {
  def toXml(game: Game) =
    <game>
      <noughts>{game.noughts}</noughts>
      <crosses>{game.crosses}</crosses>
      <marks>
      {
        game.marks.flatMap { mark =>
          def player = mark.by match {
            case Nought => "o"
            case Crosses => "x"
          }
          <mark player={player} at={mark.where.toString} /> }
      }
      </marks>
    </game>

  def fromXml(xml: NodeSeq): Game = {
    val noughts = (xml \ "noughts").text
    val crosses = (xml \ "crosses").text
    val marks = (xml \ "marks" \ "mark") map { mark =>
      val player = Player.fromString(mark \ "@player" text)
      val at = (mark \ "@at").text.toInt
      Mark(at, player)
    }
    Game(noughts, crosses, marks.toList)
  }
}

object TicTacToe extends App {

}