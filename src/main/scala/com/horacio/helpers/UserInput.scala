package com.horacio.helpers

import java.io.{InputStreamReader, BufferedReader}
import java.util.Scanner

/**
  * Created by horacio on 2/21/16.
  */
trait UserInput {
  def askHability(hability: String): String
  def askAnimal(animal: String): String
}

object ConsoleInput extends UserInput {
  override def askHability(hability: String): String = {
    Console.readLine("Does it ${hability}")
  }

  override def askAnimal(animal: String): String = {
    Console.readLine("It's a ${animal}")
  }
}

object UserInputTest extends UserInput {
  override def askHability(hability: String): String = {
//    Console.readLine("Does it ${hability}")
    "y"
  }

  override def askAnimal(animal: String): String = {
//    Console.readLine("It's a ${animal}")
    "y"
  }
}
