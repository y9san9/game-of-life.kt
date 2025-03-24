# Game of Life

Command Line
[Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
implementation using **Jetpack Compose**.

## Demo

![](demo.gif)

## Code

Rendering **Game of Life** is implemented using a simple Composable function:

```kotlin
@Composable
fun GameOfLifeContent(
  config: MosaicGameOfLife,
  game: GameOfLife,
) {
  val (width, height) = LocalTerminal.current.size

  Column {
    repeat(height) { column ->
      Row {
        repeat(width) { row ->
          val centeredCoordinate = Coordinate(
            x = row - width / 2,
            y = column - height / 2,
          )
          val isAlive = game.isAlive(centeredCoordinate)
          val char = if (isAlive) config.aliveChar else config.deadChar
          Text("$char")
        }
      }
    }
  }
}
```

## Running (with Java)

> [!WARNING]
> Do not run the following commands inside Intellij Idea since its terminal
> lacks some of the important features required by this program. Use builtin
> terminals for Unix systems and PowerShell for Windows.

First, **clone this repo** and CD into it. Then copy-paste a command depending
on your system:

### Unix

```shell
./gradlew mosaic:installJvmDist
./mosaic/build/install/mosaic-jvm/bin/mosaic
```

### Windows

```shell
./gradlew.bat mosaic:installJvmDist
./mosaic/build/install/mosaic-jvm/bin/mosaic.bat
```

## Running (Native)

This project is already configured to support Kotlin/Native, but I don't have
time at the moment to provide docs on how to configure its build and run. So,
contributions are welcome.

## Mosaic

This showcase uses [Mosaic](https://github.com/JakeWharton/mosaic) library,
which is based on **Jetpack Compose** and can help with creating arbitrary TUI
(Terminal UI) Apps.

