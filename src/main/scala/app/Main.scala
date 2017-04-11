package app



trait Entity

case class Ref[T](id: String)

case class IntEntity(int: Int)
case class StringEntity(s: String)

trait RefResolver {
  val implicits: MapProducerImplicits
  private def getMap[T: MapProducer](): Map[Ref[T], T] = implicitly[MapProducer[T]].produceMap
  def getEntity[T: MapProducer](r: Ref[T]): Option[T] = getMap[T]().get(r)
}

trait MapProducer[T] {
  def produceMap: Map[Ref[T], T]
}


trait MapProducerImplicits{
  implicit val IntMapProducer: MapProducer[Int]
  implicit val StringMapProducer: MapProducer[String]
}

object Implicits extends MapProducerImplicits{
 implicit object StringMapProducer extends MapProducer[String] {
    override def produceMap: Map[Ref[String], String] =
      Map(Ref[String]("bla") -> "stuff", Ref[String]("pina") -> "Shiraly")
  }
  implicit object IntMapProducer extends MapProducer[Int] {
    override def produceMap =
      Map(Ref[Int]("bla") -> 42, Ref[Int]("pina") -> 43)
  }
}


object Main2{
  object mainCoon extends RefResolver{
    val implicits = Implicits
  }

  import mainCoon.implicits._
  mainCoon.getEntity[Int](Ref("pina"))
}

