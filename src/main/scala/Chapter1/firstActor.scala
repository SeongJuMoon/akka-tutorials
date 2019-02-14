package Chapter1

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

object PrintMyActorRefActor {
  def props: Props = Props(new PrintMyActorRefActor)
}

// 나만의 액터 생성
class PrintMyActorRefActor extends  Actor {
  override def receive: Receive = {
    case "printit" =>
      val secondRef = context.actorOf(Props.empty,"second-actor")
      println(s"Second: $secondRef")
  }
}

object ActorHierarchyExperiments extends  App {
    val system = ActorSystem("testSystem")

    val firstRef = system.actorOf(PrintMyActorRefActor.props,"first-actor")
    println(s"Firlst : $firstRef")
    firstRef ! "printit"

    println(">> Press ENTER to exit")
  try StdIn.readLine()
  finally system.terminate()
}

