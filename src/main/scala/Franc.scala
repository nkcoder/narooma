package org.nkcoder

class Franc(override val amount: Int) extends Money(amount):
  override def times(multiplier: Int): Money = Money.franc(amount * multiplier)

  override def currency: Currency = Currency.CHF
