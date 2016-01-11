package my

import akka.actor.{Props, ActorSystem}


/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {
    val system = ActorSystem("sample")
    val fileCounter = system.actorOf(Props[FilesCounter])

    fileCounter ! args(0)
  }



}
