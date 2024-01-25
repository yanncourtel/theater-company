package repository;

import models._

import scala.::
import scala.collection.mutable

object TheaterRepository {

  var DB_Customer: mutable.MutableList[String] = new mutable.MutableList[String]

  var DB_Invoice: mutable.MutableList[Invoice] = new mutable.MutableList[Invoice]

  var plays = Map(
    "hamlet" -> Play("Hamlet", "tragedy"),
    "as-like" -> Play("As You Like It", "comedy"),
    "othello" -> Play("Othello", "tragedy")
  )

  initDb()

  def initDb(){
    DB_Customer += ("FR_Patee", "LU_Schienergienen", "LU_LuxEntertainement", "BE_LesFunsWallons", "FR_CirqueZapata")

    //Invoices are stored by country
    //FRANCE
    DB_Invoice += Invoice("FR_Patee", List(
      new Performance("hamlet", 55),
      new Performance("as-like", 230),
      new Performance("othello", 402)))

    DB_Invoice += Invoice("FR_CirqueZapata", List(
      new Performance("hamlet", 683),
      new Performance("hamlet", 1260),
      new Performance("as-like", 350),
      new Performance("othello", 890)))

    //LUXEMBOURG
    DB_Invoice += Invoice("LU_LuxEntertainement", List(
      new Performance("hamlet", 30),
      new Performance("as-like", 121)))
    DB_Invoice += Invoice("LU_Schienergienen", List(
      new Performance("hamlet", 70),
      new Performance("hamlet", 89),
      new Performance("othello", 145)))

    //BELGIUM
    DB_Invoice += Invoice("BE_LesFunsWallons", List(
      new Performance("as-like", 26),
      new Performance("as-like", 55),
      new Performance("as-like", 48)))
  }

  def allInvoices(customer: String): mutable.MutableList[Invoice] = DB_Invoice

  def CustomersFromDb() = DB_Customer
}
