package edu.knoldus

import java.io.File

import scala.io.StdIn._

import org.apache.log4j.Logger

object Application extends App {

  val Printer = Logger.getLogger(this.getClass)

  try {
    Printer.info(" enter folder path  ")
    val folderPath = readLine()
    val filePath = new FilePath().getFilePath(new File(folderPath).listFiles().toList)
    Printer.info(filePath)
  }
  catch {
    case ex => Printer.info(ex)
  }
}
