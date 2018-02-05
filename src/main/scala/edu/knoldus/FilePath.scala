package edu.knoldus

import java.io.File

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FilePath {

  def getFilePath(file: String): Future[List[File]] = Future {

    @tailrec
    def getPath(file: List[File], filePaths: List[File] = Nil): List[File] = {
      file match {
        case Nil => filePaths
        case first :: remain if first.isDirectory => getPath(remain ++ first.listFiles().toList, filePaths)
        case first :: remain if first.isFile => getPath(remain, filePaths :+ first)
      }
    }

    getPath(List(new File(file)))

  }
}
