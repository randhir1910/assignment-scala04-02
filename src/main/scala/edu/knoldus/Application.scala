package edu.knoldus

import java.io.File

import scala.io.StdIn._
import org.apache.log4j.Logger

object Application extends App {

  val Printer = Logger.getLogger(this.getClass)
  Printer.info(" enter folder path  ")
  val FolderPath = readLine()
  val Folder = new File(FolderPath).listFiles().toList
  val FilePath = new FilePath().getFilePath(Folder)
  Printer.info(FilePath)
  Thread.`yield`()
}
