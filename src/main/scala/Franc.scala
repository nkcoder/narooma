package org.nkcoder

class Franc(override val amount: Int) extends Money(amount):
  override def times(multiplier: Int): Money = Franc(amount * multiplier)
