package edu.knoldus

import java.io.File

class FilePath {

  def getFilePath(file: List[File], filePaths: List[File] = Nil): List[File] = {

    file match {
      case first :: remain if first.isDirectory => getFilePath(first.listFiles().toList ++ remain, filePaths)
      case first :: remain if first.isFile => getFilePath(remain, filePaths :+ first)
      case first :: Nil if first.isFile => getFilePath(Nil, filePaths :+ first)
    }
  }
}
