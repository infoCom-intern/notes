import scala.util.Try
import scala.util.Random

object GissaMittNummer {

  def tryToInt(s: String) = Try(s.toInt).toOption

  def main(args: Array[String]): Unit = {
    var gameOngoing: Boolean = true
    var userGuesses: Int = 0
    val randomNumber: Int = Random.between(1, 100)
    println(
      "Välkommen till gissa mitt nummer! Jag tänker på ett nummer mellan 1 och 100. Gissa vilket!"
    )
    while (gameOngoing) {
      val userInput = scala.io.StdIn.readLine()
      val userGuess = tryToInt(userInput)
      userGuess match {
        case None => println("Fel inmatning")
        case Some(guess) if guess == randomNumber => {
          gameOngoing = false
          userGuesses += 1
          println(
            s"Du vann! Snyggt. Du klarade det på $userGuesses gissningar."
          )
        }
        case Some(guess) if guess > randomNumber => {
          userGuesses += 1
          println("Det är fel. Talet jag tänker på är mindre...")
        }
        case Some(guess) if guess < randomNumber => {
          userGuesses += 1
          println("Det är fel. Talet jag tänker på är större...")
        }
        case _ => {
          println("Något gick fel.")
        }
      }
    }
  }
}
