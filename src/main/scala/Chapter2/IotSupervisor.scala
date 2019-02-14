package Chapter2

import akka.actor.{Actor, ActorLogging, Props}


object IotSupervisor {
  def props : Props = Props(new IotSupervisor)
}

class IotSupervisor extends  Actor with ActorLogging{

  /*
    기존에는 println을 이용하여 로그를 출력했다면 scala의 mixin class를 이용하여 actorLogging을 actor를 정의할 때 같이 사용할 수 있다.
   */

  override def preStart(): Unit = log.info("[IotSuperviser] running !") // 생성될 시 라이프 사이클에 훅을 추가
  override def postStop(): Unit = log.info("[IotSuperviser] was stoped") // 정지될 시 라이프사이클에 나타낼 훅을 갱신

  override def receive: Receive = Actor.emptyBehavior // 부모는 받아서 처리할 무엇이 없다고 가정
}




