package org.nkcoder

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MultiCurrencySpec extends AnyFlatSpec with should.Matchers {

  "Dollar" should "be able to process multiplication" in {
    val fiveDollar = Dollar(5)
    val product2 = fiveDollar.times(2)
    product2.amount should be(10)

    val product5 = fiveDollar.times(5)
    product5.amount should be(25)
  }
}
