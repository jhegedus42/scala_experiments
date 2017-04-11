package app

import monocle.macros.Lenses
trait Bla[A]

@Lenses
case class Ref2(id: String)  {

}


import monocle.Lens
case class Address(streetNumber: Int, streetName: String)
object Lensy {
  val f: (Int) => (Address) => Address ={ n:Int => { a:Address => a.copy(streetNumber = n)}}
  val streetNumber                     = Lens[Address, Int](_.streetNumber)(f)
}
