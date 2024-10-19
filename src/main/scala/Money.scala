package org.nkcoder

trait Money(val amount: Int):
  def times(multiplier: Int): Money

  override def equals(obj: Any): Boolean = obj match
    case that: Money if getClass == that.getClass => amount == that.amount
    case _ => false

  override def hashCode(): Int = amount.hashCode

object Money:
  def dollar(amount: Int): Money = Dollar(amount)

  def franc(amount: Int): Money = Franc(amount)
