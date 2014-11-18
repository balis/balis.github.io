package com.example

import spray.http._
import spray.client.pipelining._
import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Await
import scala.concurrent.duration._



object Main {

  def main(args: Array[String]) {
    implicit val system = ActorSystem()
    import system.dispatcher // execution context for futures

    val pipeline: HttpRequest => Future[HttpResponse] = sendReceive

    val response: Future[HttpResponse] = pipeline(Get("http://localhost:8080/"))
    
    response onComplete {
    	case Success(r) => println(r)
    	case Failure(e) => println("An error has occured: " + e.getMessage)
    }
    Await.result(response, 5 seconds)
    system.shutdown

  }
}
