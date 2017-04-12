package app

import scala.reflect.runtime.universe._


object TestuPickle extends App{
  import upickle.default._
  import shapeless.Typeable
  case class Test[T : Typeable]() {
    def info: String = implicitly[Typeable[T]].describe
  }

  val v= new Test[Int]()
  val t: _root_.scala.reflect.runtime.universe.TypeTag[Int] = typeTag[Int]
  println(t)

  val w: String = write(v)
  println("serialized: "+ w)
  println("serialized: "+ v.info)


}
