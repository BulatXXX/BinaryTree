import kotlin.random.Random


fun main(args: Array<String>) {
    val binaryTree = BinaryTree()
    val arr = ArrayList<Int>()
    for (i in 1..7){
        arr.add(Random.nextInt(0,100))
    }

   // println(arr)
    //binaryTree.addList(arr)
    binaryTree.addAll(43, 35, 6, 82, 4, 94, 18)
    binaryTree.printTree()
    binaryTree.add(34)
    println("-------------------------------------------")
    binaryTree.printTree()
    binaryTree.remove(100)
    println("-------------------------------------------")
    binaryTree.printTree()
}