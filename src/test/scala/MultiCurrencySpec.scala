package org.nkcoder

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.Console.in

class MultiCurrencySpec extends AnyFlatSpec with should.Matchers {

  "Dollar" should "be able to process multiplication" in {
    val fiveDollar = Dollar(5)
    fiveDollar.times(2) should be(Dollar(10))
    fiveDollar.times(5) should be(Dollar(25))
  }

  "Dollar" should "be able to process equality" in {
    Dollar(5) should be(Dollar(5))
    assert(Dollar(5) == Dollar(5))
    assert(Dollar(5) != Dollar(6))

    Dollar(5) should not be null
  }

  "Franc" should "be able to process multiplication" in {
    val fiveFranc = Franc(5)
    fiveFranc.times(2) should be(Franc(10))
    fiveFranc.times(5) should be(Franc(25))
  }
  
  "Franc" should "be able to process equality" in {
    Franc(5) should be(Franc(5))
    assert(Franc(5) == Franc(5))
    assert(Franc(5) != Franc(6))

    Franc(5) should not be null
  }
}
