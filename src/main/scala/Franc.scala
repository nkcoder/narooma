package org.nkcoder

class Franc(override val amount: Int) extends Money(amount):
  def times(multiplier: Int): Franc = Franc(amount * multiplier)
