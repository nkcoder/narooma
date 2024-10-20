package org.nkcoder

class Sum(val augend: Money, val addend: Money) extends Expression:
  def reduce(to: Currency): Money =
    val amount = augend.amount + addend.amount
    Money(amount, to)
