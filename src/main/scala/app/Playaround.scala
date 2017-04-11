package app

trait Bar[A] {self:Foo[A] =>

 def setFoo(x:A)= foo = x

}

trait Foo[A]{
 def foo:A
 def foo_=(x:A):Unit
}
