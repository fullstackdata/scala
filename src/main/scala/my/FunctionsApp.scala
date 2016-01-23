package my

/**
  * Created by chandana on 1/22/16.
  */
object FunctionsApp {

  def sumOfList(list : List[Int], filterFn : Int => Boolean) : Int = {
    // Fold Left Syntax -- init val /: Collection {fn}
    return (0/:list.filter(filterFn)){_+_};
  }


  // Currying - Pass multiple parameter lists with one param each
  // Regular - fn(a, b)
  // Curried - fn(a)(b)
  def curriedSum(list : List[Int])(filterFn : Int => Boolean) : Int = {
    return (0/:list.filter(filterFn)){_+_};
  }

  def main(args : Array[String]): Unit ={
    val intList : List[Int] = (1 to 10 toList)
    println(sumOfList(intList, {_ => true}))
    println(sumOfList(intList, {itm => itm % 2 == 0 }))
    println(sumOfList(intList, {itm => itm % 2 == 1 }))

    println(curriedSum(intList){_ => true})
    println(curriedSum(intList){itm => itm % 2 == 0 })
    println(curriedSum(intList){itm => itm % 2 == 1 })

  }

}
