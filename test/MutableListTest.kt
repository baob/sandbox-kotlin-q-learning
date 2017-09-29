import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

//var s = mutableListOf(1,2,3)
//var s2 = s.add(1,2)
//var s3 = s.removeAt()     removeAt()

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


