class BinaryTree(var root: Node? = null) {

    fun addAll(vararg arr: Int) {
        for (v in arr) {
            add(v)
        }
    }
    fun addList(l:List<Int>){
        for (v in l) {
            add(v)
        }
    }

    fun add(value: Int) {
        if (root == null) {
            root = Node(value)
        } else {
            var currentNode = root!!
            while (true) {
                if (value == currentNode.key) {
                    return
                }
                if (value > currentNode.key) {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right!!
                    } else {
                        currentNode.right = Node(value)
                        return
                    }
                } else {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left!!
                    } else {
                        currentNode.left = Node(value)
                        return
                    }
                }

            }
        }
    }

    fun find(value: Int): Node? {
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.key == value) {
                return currentNode
            }
            currentNode = if (value > currentNode.key) currentNode.right else currentNode.left
        }
        return null
    }

    operator fun contains(value: Int) = find(value)!=null

    fun isEmpty() = root == null

    fun printTree(currentNode: Node?=root,level:Int=0){
        if (currentNode!=null) {
            printTree(currentNode.right, level + 1)
            var tab = ""
            for (i in 0..<level){
                tab+="   "
            }
            println(tab+currentNode.key)
            printTree(currentNode.left, level + 1);
        }
    }

    fun remove(value: Int) {
        root = removeNode(root, value)
    }

    private fun removeNode(node: Node?, value: Int): Node? {
        if (node == null) {
            return null
        }

        if (value < node.key) {
            node.left = removeNode(node.left, value)
        } else if (value > node.key) {
            node.right = removeNode(node.right, value)
        } else {
            if (node.left == null && node.right == null) {
                return null
            } else if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            } else {
                val minValue = findMinValue(node.right!!)
                node.key = minValue
                node.right = removeNode(node.right, minValue)
            }
        }

        return node
    }

    private fun findMinValue(node: Node): Int {
        var minValue = node.key
        var currentNode = node
        while (currentNode.left != null) {
            minValue = currentNode.left!!.key
            currentNode = currentNode.left!!
        }
        return minValue
    }




}

class Node(
    var key: Int,
    var left: Node? = null,
    var right: Node? = null
)



