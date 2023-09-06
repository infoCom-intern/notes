import scala.util.Try
import scala.util.Random

object GissaMittNummer {

  // Helper function to convert string to integer option
  def tryToInt(s: String) = Try(s.toInt).toOption

  def main(args: Array[String]): Unit = {
    var gameOngoing: Boolean = true
    var userGuesses: Int = 0
    val randomNumber: Int = Random.between(1, 100)
    // Print welcome message
    println(
      "Välkommen till gissa mitt nummer! Jag tänker på ett nummer mellan 1 och 100. Gissa vilket!"
    )
    // Start the game loop
    while (gameOngoing) {
      // Read user input
      val userInput = scala.io.StdIn.readLine()
      // Convert user input to integer
      val userGuess = tryToInt(userInput)
      userGuess match {
        case None =>
          println(
            "Fel inmatning"
          ) // If user input is not a valid integer, print error message
        case Some(guess)
            if guess == randomNumber => { // If user input is equal to the random number
          gameOngoing = false // Stop the game loop
          userGuesses += 1 // Increment number of guesses
          // Print congratulations message
          println(
            s"Du vann! Snyggt. Du klarade det på $userGuesses gissningar."
          )
        }
        case Some(guess) if guess > randomNumber => {
          // If user input is greater than the random number, print hint
          userGuesses += 1 // Increment number of guesses
          println("Det är fel. Talet jag tänker på är mindre...")
        }
        case Some(guess) if guess < randomNumber => {
          // If user input is less than the random number, print hint
          userGuesses += 1 // Increment number of guesses
          println("Det är fel. Talet jag tänker på är större...")
        }
        case _ => {
          // Should not hit this case
          println("Något gick fel.")
        }
      }
    }
  }
}
