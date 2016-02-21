package com.horacio

import java.util.Scanner

import com.horacio.helpers.UserInput
import com.horacio.model.{Animal, Hability}
import collection.mutable.HashMap

import scala.collection.mutable

object Game {
  def start(userInput: UserInput): String = {
    println("think in an animal...")

    val gameMemory = initGameMemory()
    askHability(userInput, gameMemory)
  }

  def initGameMemory() = {
    val habilitiesAndAnimal = new HashMap[String, List[Animal]]()
    habilitiesAndAnimal += "had a tail" -> List(Animal("Dog", "barks"))
    habilitiesAndAnimal
  }

  def askHability(userInput: UserInput, memory: HashMap[String, List[Animal]]): String = {
    val in = userInput.askHability(memory.head._1)
    in match {
      case "y" => askHabilityAnimals(userInput: UserInput, memory)
      case _ => "not impemented yet"
    }
  }

  def askHabilityAnimals(userInput: UserInput, memory: HashMap[String, List[Animal]]): String = {
    val animals = memory.head._2

    def animalRecursion(animals: List[Animal]): String = {
      val in = userInput.askHability(animals.head.hability)
      in match {
        case "y" => askAnimal(userInput: UserInput, animals.head.name)
        case _ => animalRecursion(animals.tail)
      }
    }
    animalRecursion(animals)
  }

  def askAnimal(userInput: UserInput, animalName: String): String = {
    val in = userInput.askAnimal(animalName)
    in match {
      case "y" => finishGame(animalName)
      case _ => "not impemented yet"
    }
  }

  def finishGame(animal: String): String = {
    "The animal you thought was a $animal"
  }
}
