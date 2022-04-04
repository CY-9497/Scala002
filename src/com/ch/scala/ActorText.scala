package com.ch.scala
import scala.actors.Actor

/**
 * 通讯模型
 * @param actor
 * @param string
 */
case class Message(actor: Actor,string: String)
class HelloActor1 extends Actor{
  override def act(): Unit = {
    while (true){
      receive {
        case message: Message=>{
          if (message.string.equals("hello")) {
            println("hello")
            message.actor ! "hi~"
          }
          if (message.string.equals("Can we be friends?")){
            println("Can we be friends?")
            message.actor ! "Welcome to be my friend!"
          }
          if (message.string.equals("I'm very happy.")){
            println("I'm very happy.")
            message.actor ! "Me too."
          }
        }
        case _=>{
          println("通话结束")
        }
      }
    }
  }
}
class HelloActor2(actor: Actor) extends Actor{
  actor ! Message(this, "hello")
  override def act(): Unit = {
    while (true){
      receive {
        case string: String=>{
          if (string.equals("hi~")) {
            println("hi~")
            actor ! Message(this,"Can we be friends?")
          }
          if (string.equals("Welcome to be my friend!")){
            println("Welcome to be my friend!")
            actor ! Message(this, "I'm very happy.")
          }
          if (string.equals("Me too."))
            println("Me too.")
        }
        case _=>{
          println("通话结束")
        }
      }
    }
  }
}
object ActorText {
  def main(args: Array[String]): Unit = {
    val actor1 = new HelloActor1()
    val actor2 = new HelloActor2(actor1)
    actor1.start()
    actor2.start()
  }

}