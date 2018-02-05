package edu.knoldus

import edu.knoldus.Constant.Const
import org.apache.log4j.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn._
import scala.util.{Failure, Success}

object Application extends App {

  val Printer = Logger.getLogger(this.getClass)

  Printer.info(" Enter folder path  ")
  val folderPath = readLine()
  val filePath = new FilePath().getFilePath(folderPath)

  filePath onComplete {
    case Success(path) => Printer.info(path)
    case Failure(exception) => Printer.info(exception)
  }

  Thread.sleep(Const.thousand)


}
