import scala.util.Try
import scala.util.Random

def tryToInt(s: String) = Try(s.toInt).toOption

def isGuessCorrect(userGuess: Int, correctGuess: Int): Boolean = {
  if (userGuess == correctGuess) then return true
  else return false
}

object Irritext {

  def main(args: Array[String]): Unit = {

    var gameOngoing = true
    var numberOfGuesses: Int = 0
    val randomInteger = Random.between(1, 100)

    println(
      "Välkommen till gissa mitt nummer! Jag tänker på ett nummer mellan 1 och 100. Gissa vilket!"
    )

    val responses = Array(
      "Bra gissning, men talet jag tänker på är mindre...",
      "Bra gissning, men talet jag tänker på är större..."
    )

    while (gameOngoing) {
      val userInput = scala.io.StdIn.readLine()
      val userGuess = tryToInt(userInput)
      numberOfGuesses += 1

      if isGuessCorrect(userGuess.get, randomInteger) then {
        println(s"Grattis! Du vann på endast $numberOfGuesses gissningar.")
        gameOngoing = false
      } else println(responses(Random.nextInt(responses.size)))
    }
  }
}
