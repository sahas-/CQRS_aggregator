package com.aggregator

import akka.NotUsed
import akka.actor.{ActorRef,ActorSystem,Props}
import akka.persistence.query._
import akka.persistence.query.journal.redis._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

object Main extends App{
  val actor: String = "persistent-query-agg"
  private val system: ActorSystem = ActorSystem(actor)
  implicit val mat = ActorMaterializer()(system)

  val readJournal = PersistenceQuery(system)
    .readJournalFor[ScalaReadJournal]("akka-persistence-redis.read-journal")


  val source:Source[EventEnvelope,NotUsed]= readJournal
    .eventsByPersistenceId("UserActivityLedger",0L,Long.MaxValue)


  source.runForeach{
    Thread.sleep(1000)
    event => println(event)
  }
}
