fun main() {
    mergeTwoLists(prepareList(intArrayOf(1, 2, 4)), prepareList(intArrayOf(1, 3, 4)))
}

fun prepareList(array: IntArray): ListNode? {
    return if (array.isNotEmpty()) {
        val head = ListNode(array[0])
        head.next = null
        for (i in 1 until array.size) {
            var temp = head
            while (temp.next != null) {
                temp = temp.next!!
            }
            temp.next = ListNode(array[i])
        }
        head
    } else null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var temp1 = list1
    var temp2 = list2
    val tempList = ArrayList<Int>()
    while (temp1 != null && temp2 != null) {
        if (temp1.`val` <= temp2.`val`) {
            tempList.add(temp1.`val`)
            temp1 = temp1.next
        } else {
            tempList.add(temp2.`val`)
            temp2 = temp2.next
        }
    }
    while (temp1 != null) {
        tempList.add(temp1.`val`)
        temp1 = temp1.next
    }

    while (temp2 != null) {
        tempList.add(temp2.`val`)
        temp2 = temp2.next
    }

    return prepareList(tempList.toIntArray())
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}