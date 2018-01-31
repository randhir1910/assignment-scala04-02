package edu.knoldus

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import java.io.File

class FilePath {

  def getFilePath(file: List[File], filePaths: List[File] = Nil): Future[List[File]] = {

    file match {
      case Nil => Future { filePaths }
      case first :: remain if first.isDirectory => getFilePath(remain ++ first.listFiles().toList, filePaths)
      case first :: remain if first.isFile => getFilePath(remain, filePaths :+ first)
      case _ => Future {  Nil }
    }

  }
}
