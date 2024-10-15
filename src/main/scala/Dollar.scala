package org.nkcoder

class Dollar(val amount: Int):
  def times(multiplier: Int): Dollar = Dollar(amount * multiplier)
