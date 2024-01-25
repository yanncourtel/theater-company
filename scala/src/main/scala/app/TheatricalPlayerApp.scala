package app

import repository.TheaterRepository

object TheatricalPlayerApp {

  //TO CHANGE the customer name to display all invoices
  var customer = "FR_Patee"

  def main(args: Array[String]) : Unit = {
    val printer = new StatementPrinter

    val invoices = TheaterRepository.allInvoices(customer)

    invoices.map((i) => println(printer.print(i, TheaterRepository.plays)))
  }
}
