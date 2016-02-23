package com.horacio

import scala.annotation.tailrec
import scala.io.StdIn

trait Tree

case class Node(message: String, left: Tree, right: Tree) extends Tree

case class Leaf(message: String) extends Tree

object Game {
  def main(args: Array[String]) {
    val tree = Node("Seu animal é um mamífero ?", Leaf("Gato"), Leaf("Peixe"))
    play(tree)
    println("Obrigado por jogar!")
  }

  @tailrec
  def play(tree: Tree): Unit = {
    val newTree = traverseTree(tree)
    println("Vamos jogar novamente ?")
    val again = StdIn.readLine().toLowerCase
    if (again == "sim" || again == "s") play(newTree)
  }

  def traverseTree(tree: Tree): Tree = tree match {
    case Leaf(animal) =>
      println(s"Seu é animal um $animal ?")
      StdIn.readLine().toLowerCase match {
        case "s" | "sim" =>
          println("Show! Eu acertei!")
          tree
        case _ => newAnimal(animal)
      }
    case Node(question, yes, no) =>
      println(question)
      StdIn.readLine().toLowerCase match {
        case "s" | "sim" => Node(question, traverseTree(yes), no)
        case _ => Node(question, yes, traverseTree(no))
      }
  }

  def newAnimal(oldAnimal: String): Tree = {
    println("Eu desisto!")
    println("Qual é o animal que você pensou ?")
    val animal = StdIn.readLine()
    println("Digite uma caracteristica desse animal")
    val question = StdIn.readLine()
    Node(question, Leaf(animal), Leaf(oldAnimal))
  }

}
