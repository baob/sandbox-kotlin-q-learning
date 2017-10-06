import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class `a mutable list with elements 1 2 3` {
    var list1: MutableList<Int> = mutableListOf(1,2,3)

    @Test
    fun `push(21) should give 1 2 3 21`() {
        assertThat(list1.push(21), equalTo(mutableListOf(1,2,3,21)))

    }
}

class `a mutable list with elements 1 2 4` {

    @Test
    fun `pop() should change the list to 1 2`() {
        var list2 = mutableListOf(1,2,4)
        list2.pop()
        assertThat(list2, equalTo(mutableListOf(1,2)))
    }

    @Test
    fun `pop() should return 4`() {
        var list3 = mutableListOf(1,2,4)
        assertThat(list3.pop(), equalTo(4))
    }
}

class `a mutable list with elements 3 5 7` {
    var list11: MutableList<Int> = mutableListOf(3,5,7)

    @Test
    fun `unshift(9) should give 9 3 5 7`() {
        assertThat(list11.unshift(9), equalTo(mutableListOf(9,3,5,7)))
    }
}

class `a mutable list with elements 7 3 1` {

    @Test
    fun `shift() should change the list to 3 1`() {
        var list12 = mutableListOf(7,3,1)
        list12.shift()
        assertThat(list12, equalTo(mutableListOf(3,1)))
    }

    @Test
    fun `shift() should return 7`() {
        var list13 = mutableListOf(7,3,1)
        assertThat(list13.shift(), equalTo(7))
    }
}
