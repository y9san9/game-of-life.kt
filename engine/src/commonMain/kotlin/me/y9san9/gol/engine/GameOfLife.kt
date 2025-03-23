package me.y9san9.gol.engine

import me.y9san9.gol.geometry.Coordinate
import me.y9san9.gol.geometry.GameField
import me.y9san9.gol.geometry.MutableGameField
import me.y9san9.gol.geometry.neighbours
import me.y9san9.gol.geometry.toMutableGameField

class GameOfLife(val field: GameField<Unit>) {
  fun isAlive(coordinate: Coordinate): Boolean {
    return coordinate in field.coordinates
  }

  fun tick(): GameOfLife {
    val field = this.field.toMutableGameField()
    val visited = mutableSetOf<Coordinate>()

    for (coordinate in this.field.coordinates) {
      visit(coordinate, visited, field)
      for (neighbour in coordinate.neighbours()) {
        visit(neighbour, visited, field)
      }
    }

    return GameOfLife(field)
  }

  private fun visit(
    coordinate: Coordinate,
    visited: MutableSet<Coordinate>,
    field: MutableGameField<Unit>,
  ) {
    if (coordinate in visited) return
    visited += coordinate
    if (willAlive(coordinate)) {
      field.set(coordinate, Unit)
    } else if (coordinate in field.coordinates) {
      field.remove(coordinate)
    }
  }
  
  /**
   * 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
   * 2. Any live cell with two or three live neighbours lives on to the next generation.
   * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
   * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
   * 
   * Source: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
   */
  private fun willAlive(coordinate: Coordinate): Boolean {
    val neighbours = this.field.neighbours(coordinate)
    if (isAlive(coordinate)) {
      return neighbours.size in 2..3
    } else {
      return neighbours.size == 3
    }
  }
}

