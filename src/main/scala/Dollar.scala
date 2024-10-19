package org.nkcoder

import Currency.USD

class Dollar(override val amount: Int, override val currency: Currency = USD) extends Money(amount, currency)


