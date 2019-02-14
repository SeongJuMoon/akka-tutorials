package Chapter2

import akka.actor.ActorSystem

import scala.io.StdIn

object IotApp {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("iot-System")

    try {
      system.actorOf(IotSupervisor.props,"iot-supervisor")
      // 엔터를 누르면 프로그램이 종료되도록 함
      StdIn.readLine()
    } finally {
      system.terminate()
    }

  }

}
