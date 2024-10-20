package org.nkcoder

class Bank:
  def reduce(source: Expression, to: Currency): Money = source.reduce(to)

