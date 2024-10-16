package org.nkcoder

class Franc(val amount: Int):
  def times(multiplier: Int): Franc = Franc(amount * multiplier)

  override def equals(obj: Any): Boolean = obj match
    case that: Franc => amount == that.amount
    case _ => false

  override def hashCode(): Int = amount.hashCode
