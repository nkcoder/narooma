package org.nkcoder

import scala.annotation.targetName

class Money(val amount: Int, val currency: Currency) extends Expression:
  def times(multiplier: Int): Money = Money(amount * multiplier, currency)

  /**
   * It is recommended that definitions of symbolic operators carry a @targetName annotation that provides an encoding
   * of the operator with an alphanumeric name.
   * Ref: https://docs.scala-lang.org/scala3/reference/changed-features/operators.html
   */
  @targetName("add")
  def +(addend: Money): Sum = Sum(this, addend)

  def reduce(bank: Bank, to: Currency): Money =
    val rate = bank.rate(currency, to)
    Money(amount / rate, to)

  override def equals(obj: Any): Boolean = obj match
    case that: Money => amount == that.amount && currency == that.currency
    case _ => false

  override def toString: String = s"$amount $currency"

  override def hashCode(): Int = amount.hashCode

object Money:
  def dollar(amount: Int): Money = Money(amount, Currency.USD)

  def franc(amount: Int): Money = Money(amount, Currency.CHF)
