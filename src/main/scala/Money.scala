package org.nkcoder

class Money(val amount: Int, val currency: Currency):
  def times(multiplier: Int): Money = Money(amount * multiplier, currency)

  override def equals(obj: Any): Boolean = obj match
    case that: Money => amount == that.amount && currency == that.currency
    case _ => false

  override def toString: String = s"$amount $currency"

  override def hashCode(): Int = amount.hashCode

object Money:
  def dollar(amount: Int): Money = Money(amount, Currency.USD)

  def franc(amount: Int): Money = Money(amount, Currency.CHF)
