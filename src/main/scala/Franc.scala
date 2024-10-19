package org.nkcoder

class Franc(override val amount: Int, override val currency: Currency = Currency.CHF) extends Money(amount, currency)
