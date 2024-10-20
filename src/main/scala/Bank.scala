package org.nkcoder


class Bank:
  private val rates = collection.mutable.Map.empty[Pair, Int]

  def reduce(source: Expression, to: Currency): Money = source.reduce(this, to)

  def addRate(from: Currency, to: Currency, rate: Int): Unit =
    rates += Pair(from, to) -> rate

  def rate(from: Currency, to: Currency): Int =
    if from == to then 1
    else rates(Pair(from, to))

  private case class Pair(from: Currency, to: Currency):
    override def equals(obj: Any): Boolean =
      obj match
        case pair: Pair => from == pair.from && to == pair.to
        case _ => false

    override def hashCode(): Int = from.hashCode + to.hashCode

