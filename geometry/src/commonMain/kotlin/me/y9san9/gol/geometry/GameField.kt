package me.y9san9.gol.geometry

interface GameField<T> {
  val coordinates: Set<Coordinate>
  operator fun get(coordinate: Coordinate): T
}

inline fun <T> buildGameField(
  block: MutableGameField<T>.() -> Unit
): GameField<T> {
  val field = MutableGameField<T>()
  field.block()
  return field.toGameField()
}

operator fun <T> GameField<T>.get(x: Int, y: Int): T {
  return get(Coordinate(x, y))
}

fun <T> GameField<T>.toMutableGameField(): MutableGameField<T> {
  val new = MutableGameField<T>()
  for (coordinate in this.coordinates) {
    new[coordinate] = this[coordinate]
  }
  return new
}

fun <T> GameField<T>.toGameField(): GameField<T> {
  return toMutableGameField()
}

fun <T> GameField<T>.getOrNull(coordinate: Coordinate): T? {
  if (coordinate !in this.coordinates) return null
  return this[coordinate]
}

fun <T> GameField<T>.neighbours(coordinate: Coordinate): Set<Coordinate> {
  return coordinate
    .neighbours()
    .filterTo(mutableSetOf()) { neighbour -> neighbour in this.coordinates }
}

