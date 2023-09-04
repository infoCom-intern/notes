// Hangman game implementation in Scala.

import scala.util.Random
import java.net.{HttpURLConnection, URL}
import scala.io.Source

@main def hangMan = {
  // Function to print the health bar
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

  // Welcome message
  println("Welcome to hang man. Let's play!")

  // API URL to fetch a random word
  val wordApiUrl = "https://random-word-api.herokuapp.com/word"
  // Fetch a random word from the API and convert it to uppercase
  val word =
    Source.fromURL(wordApiUrl).mkString.drop(2).dropRight(2).toUpperCase()
  val wordLenth = word.length()
  // Convert the word to an array of characters
  val wordCharsAnswer = word.toCharArray()
  // Initialize an array to store the guessed characters
  var wordCharsGuessed = Array.fill(wordLenth)('_')

  var gameOngoing = true
  val initialHealth = 15
  var health = initialHealth

  // Game loop
  while (gameOngoing) {
    print("\u001b[2J") // Clear the terminal screen
    printHealthBar(initialHealth, health) // Print the health bar

    // Print the current state of the word with guessed characters
    for ((char, index) <- wordCharsGuessed.zipWithIndex) {
      print(char)
      if (index < wordCharsGuessed.length - 1) {
        print(" ")
      }
    }
    println()

    // Read user input for guessing a character
    val userGuess: Char = scala.io.StdIn.readChar().toUpper
    var foundCorrectChar = false

    // Check if the guessed character is present in the word
    for ((char, index) <- wordCharsAnswer.zipWithIndex) {
      if (userGuess == char) {
        foundCorrectChar = true
        wordCharsGuessed = wordCharsGuessed.updated(
          index,
          char
        ) // Update the guessed characters array
      }
    }
    if (!foundCorrectChar) {
      health -= 1 // Decrease health if the guessed character is incorrect
    }

    // Check if the word has been completely guessed
    if (wordCharsGuessed.mkString == wordCharsAnswer.mkString) {
      print("\u001b[2J")
      gameOngoing = false
      println(s"You won, yay! The word was indeed ${word}")
    }

    // Check if the player has run out of health
    if (health == 0) {
      print("\u001b[2J")
      gameOngoing = false
      println(s"You lost! The word was ${word}!")
    }
  }
}
