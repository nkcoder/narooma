package org.nkcoder

trait Money(val amount: Int):
  def times(multiplier: Int): Money

  override def equals(obj: Any): Boolean = obj match
    case that: Money => amount == that.amount
    case _ => false

  override def hashCode(): Int = amount.hashCode
