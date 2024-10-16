package org.nkcoder

class Dollar(val amount: Int):
  def times(multiplier: Int): Dollar = Dollar(amount * multiplier)

  override def equals(obj: Any): Boolean = obj match
    case that: Dollar => amount == that.amount
    case _ => false

  override def hashCode(): Int = amount.hashCode


