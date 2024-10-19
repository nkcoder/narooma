package org.nkcoder

class Dollar(override val amount: Int) extends Money(amount):
  override def times(multiplier: Int): Money = Dollar(amount * multiplier)


