package org.nkcoder

class Dollar(override val amount: Int) extends Money(amount):
  override def times(multiplier: Int): Money = Money.dollar(amount * multiplier)

  override def currency: Currency = Currency.USD


