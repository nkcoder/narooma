package org.nkcoder

trait Expression:
  def reduce(bank: Bank, to: Currency): Money
