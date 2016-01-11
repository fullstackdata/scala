package my

import java.io.File

import akka.actor._



/**
  * Created by chandana on 1/10/16.
  */
class FileExplorer extends Actor {
  override def receive = {

    case dirName : String =>
      val file = new File(dirName)
      val children = file.listFiles()
      var filesCount = 0;

      if(children != null) {
        children.filter {
          _.isDirectory
        }.foreach {
          sender ! _.getAbsolutePath
        }
        filesCount = children.count{!_.isDirectory}
      }

      sender ! filesCount

  }
}
