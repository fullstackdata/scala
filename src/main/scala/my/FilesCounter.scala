package my

import akka.actor.{Props, Actor}
import akka.routing.RoundRobinPool

/**
  * Created by chandana on 1/10/16.
  */
class FilesCounter  extends Actor {

  var pending = 0
  var filesCount = 0

  val fileExplorers = context.actorOf(RoundRobinPool(10).props(Props[FileExplorer]))
  val start = System.nanoTime
  override def receive = {
    case dirName : String =>
      pending = pending + 1
      fileExplorers ! dirName
    case count : Int =>
      filesCount = filesCount + count
      pending = pending - 1

    if(pending == 0){
      val end = System.nanoTime
      context.system.terminate()
      println(filesCount)
      println(s"Time Taken : ${(end-start)/1000000000}")

    }

  }
}
