package tictactoe

import org.scalatest._
import matchers.ShouldMatchers

class TictacToeSuite extends FunSuite with ShouldMatchers {

  val game = Game("A", "B", List(
      Mark(3,Crosses),
      Mark(1, Nought),
      Mark(7, Crosses),
      Mark(5, Nought),
      Mark(9, Crosses),
      Mark(6, Nought),
      Mark(8, Crosses)))

  val gameXml =
    <game>
      <noughts>A</noughts>
      <crosses>B</crosses>
      <marks>
        <mark player="x" at="3"/>
        <mark player="o" at="1"/>
        <mark player="x" at="7"/>
        <mark player="o" at="5"/>
        <mark player="x" at="9"/>
        <mark player="o" at="6"/>
        <mark player="x" at="8"/>
      </marks>
    </game>

  test("Game.fromXml") {
    Game.fromXml(gameXml) should be === game
  }

  test("Game.toXml") {
    Game.fromXml(Game.toXml(game)) should be === game
  }
}