package org.nkcoder

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CurrencySpec extends AnyFlatSpec with should.Matchers {

  behavior of "Dollar"
  "Dollar" should "be able to process multiplication" in {
    val fiveDollar = Dollar(5)
    fiveDollar.times(2) should be(Dollar(10))
    fiveDollar.times(5) should be(Dollar(25))
  }

  it should "be able to process equality" in {
    Dollar(5) should be(Dollar(5))
    assert(Dollar(5) == Dollar(5))
    assert(Dollar(5) != Dollar(6))

    Dollar(5) should not be null
  }

  behavior of "Franc"
  "Franc" should "be able to process multiplication" in {
    val fiveFranc = Franc(5)
    fiveFranc.times(2) should be(Franc(10))
    fiveFranc.times(5) should be(Franc(25))
  }

  it should "be able to process equality" in {
    Franc(5) should be(Franc(5))
    assert(Franc(5) == Franc(5))
    assert(Franc(5) != Franc(6))

    Franc(5) should not be null
  }

  it should "not be equal to Dollar" in {
    Dollar(5) should not be Franc(5)
  }

  behavior of "Money"
  "Money" should "be able to process multiplication" in {
    val fiveDollar: Money = Money.dollar(5)
    Money.dollar(10) should be(fiveDollar.times(2))

    val fiveFranc: Money = Money.franc(5)
    Money.franc(15) should be(fiveFranc.times(3))
  }

  it should "be able to process equality" in {
    Money.dollar(5) should be(Money.dollar(5))
    Money.dollar(5) should not be Money.dollar(6)
    Money.franc(5) should be(Money.franc(5))
    Money.franc(5) should not be Money.franc(6)
    Money.dollar(5) should not be Money.franc(5)
  }

  it should "be able to process addition with currency reduce" in {
    val sum: Expression = Money.dollar(5) + Money.dollar(6)
    val bank = Bank()
    val reduced = bank.reduce(sum, Currency.USD)
    reduced should be(Money.dollar(11))
  }

  it should "return Sum for addition" in {
    val five = Money.dollar(5)
    val six = Money.dollar(6)
    val result: Expression = five + six
    val sum = result.asInstanceOf[Sum]
    sum.augend should be(five)
    sum.addend should be(six)
  }

  it should "reduce sum" in {
    val sum: Expression = Sum(Money.dollar(3), Money.dollar(4))
    val bank = Bank()
    val result = bank.reduce(sum, Currency.USD)
    result should be(Money.dollar(7))
  }

  it should "reduce Money" in {
    val bank = Bank()
    val result = bank.reduce(Money.dollar(1), Currency.USD)
    result should be(Money.dollar(1))
  }

  behavior of "Bank"
  "Bank" should "be able to reduce Money with different currency" in {
    val bank = Bank()
    bank.addRate(Currency.CHF, Currency.USD, 2)
    val result = bank.reduce(Money.franc(2), Currency.USD)
    result should be(Money.dollar(1))
  }
  
  it should "handle identity rate" in {
    Bank().rate(Currency.USD, Currency.USD) should be(1)
  }

  behavior of "Currency"
  "Currency" should "be there for us" in {
    Currency.USD should be(Money.dollar(1).currency)
    Currency.CHF should be(Money.franc(1).currency)
  }
}
