import app.StatementPrinter
import models.{Invoice, Performance, Play}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StatementPrinterTests extends AnyFunSuite with Matchers {
  test("example amount owed tva fr"){
    val plays = Map(
      "hamlet" -> Play("Hamlet", "tragedy"),
      "as-like" -> Play("As You Like It", "comedy"),
      "othello" -> Play("Othello", "tragedy"))

    val invoice = Invoice(
      "FR_BigCo",
      List(
        Performance("hamlet", 55),
        Performance("as-like", 35),
        Performance("othello", 40)
      )
    )

    val statementPrinter = new StatementPrinter
    val result = statementPrinter.print(invoice, plays)

    //TODO: Probably needs some rework...
    val amountString = "Amount owed is $"
    val finalString = "You earned"
    result.substring(result.indexOf(amountString) + amountString.length, result.indexOf(finalString)).trim should be("1,825.00")
  }

  test("statement example") {
    val plays = Map(
      "hamlet" -> Play("Hamlet", "tragedy"),
      "as-like" -> Play("As You Like It", "comedy"),
      "othello" -> Play("Othello", "tragedy")
    )

    val invoice = Invoice(
      "BigCo",
      List(
        Performance("hamlet", 55),
        Performance("as-like", 35),
        Performance("othello", 40)
      )
    )

    val statementPrinter = new StatementPrinter()
    val result = statementPrinter.print(invoice, plays)

    result should be("""Statement for BigCo
        |  Hamlet: $650.00 (55 seats)
        |  As You Like It: $580.00 (35 seats)
        |  Othello: $500.00 (40 seats)
        |Amount owed is $1,730.00
        |You earned 47 credits
        |""".stripMargin)
  }

  test("statement with new play types") {
    val plays = Map(
      "henry-v" -> Play("Henry V", "history"),
      "as-like" -> Play("As You Like It", "pastoral")
    )

    val invoice = Invoice(
      "BigCoII",
      List(
        Performance("henry-v", 53),
        Performance("as-like", 55)
      )
    )

    val statementPrinter = new StatementPrinter()
    assertThrows[Exception] {
      statementPrinter.print(invoice, plays)
    }
  }
}
