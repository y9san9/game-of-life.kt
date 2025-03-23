package me.y9san9.gol.geometry

data class Coordinate(
  val x: Int,
  val y: Int
)

fun Coordinate.neighbours(): Set<Coordinate> {
  return (-1..1).flatMapTo(mutableSetOf()) { xDelta ->
    (-1..1).mapNotNull { yDelta -> 
      if (xDelta == 0 && yDelta == 0) {
        null
      } else {
        Coordinate(x = x + xDelta, y = y + yDelta)
      }
    }
  }
}
