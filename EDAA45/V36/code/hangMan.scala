import scala.util.Random
import java.net.{HttpURLConnection, URL}
import scala.io.Source

@main def hangMan = {
  def printHealthBar(startHealth: Int, health: Int) = {
    print("Your health: ")
    print("<")
    for (i <- 0 until startHealth) {
      if (i < health) {
        print("#")
      } else {
        print(" ")
      }
    }
    print(">")
    println()
  }

  println("Welcome to hang man. Let's play!")

  val wordApiUrl = "https://random-word-api.herokuapp.com/word"
  val word =
    Source.fromURL(wordApiUrl).mkString.drop(2).dropRight(2).toUpperCase()
  val wordLenth = word.length()
  val wordCharsAnswer = word.toCharArray()
  var wordCharsGuessed = Array.fill(wordLenth)('_')

  var gameOngoing = true
  val initialHealth = 15
  var health = initialHealth

  while (gameOngoing) {
    print("\u001b[2J")
    printHealthBar(initialHealth, health)

    for ((char, index) <- wordCharsGuessed.zipWithIndex) {
      print(char)
      if (index < wordCharsGuessed.length - 1) {
        print(" ")
      }
    }
    println()

    val userGuess: Char = scala.io.StdIn.readChar().toUpper
    var foundCorrectChar = false

    for ((char, index) <- wordCharsAnswer.zipWithIndex) {
      if (userGuess == char) {
        foundCorrectChar = true
        wordCharsGuessed = wordCharsGuessed.updated(
          index,
          char
        )
      }
    }
    if (!foundCorrectChar) {
      health -= 1
    }

    if (wordCharsGuessed.mkString == wordCharsAnswer.mkString) {
      print("\u001b[2J")
      gameOngoing = false
      println(s"You won, yay! The word was indeed ${word}")
    }

    if (health == 0) {
      print("\u001b[2J")
      gameOngoing = false
      println(s"You lost! The word was ${word}!")
    }
  }
}
