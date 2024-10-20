package org.nkcoder

trait Expression:
  def reduce(to: Currency): Money
