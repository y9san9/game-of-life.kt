package me.y9san9.gol.geometry

interface MutableGameField<T> : GameField<T> {
  operator fun set(coordinate: Coordinate, value: T)
  fun remove(coordinate: Coordinate)
}

operator fun <T> MutableGameField<T>.set(x: Int, y: Int, value: T) {
  set(Coordinate(x, y), value)
}

fun <T> MutableGameField(): MutableGameField<T> {
  return MutableGameFieldImpl()
}

private class MutableGameFieldImpl<T> : MutableGameField<T> {
  private val map = mutableMapOf<Coordinate, T>()

  override val coordinates get() = this.map.keys

  override operator fun set(coordinate: Coordinate, value: T) {
    this.map[coordinate] = value
  }

  override operator fun get(coordinate: Coordinate): T {
    return this.map.getValue(coordinate)
  }

  override fun remove(coordinate: Coordinate) {
    if (coordinate !in this.coordinates) {
      error("Can't remove an element that is not present anyways")
    }
    this.map.remove(coordinate)
  }

  override fun equals(any: Any?): Boolean {
    if (any === this) return true
    if (any !is MutableGameField<*>) return false
    if (coordinates != any.coordinates) return false
    return coordinates.all { coordinate -> any[coordinate] == this[coordinate] }
  }

  override fun hashCode(): Int {
    return map.hashCode()
  }

  override fun toString(): String {
    return map.toString()
  }
}
