import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

//var s = mutableListOf(1,2,3)
//var s2 = s.add(1,2)
//var s3 = s.push(88)

class `a mutable list with elements 1 2 3` {
    var list: MutableList<Int> = mutableListOf(1,2,3)

    @Test
    fun `push(21) should give 1 2 3 21`() {
        assertThat(list.push(21), equalTo(mutableListOf(1,2,3,21)))

    }
}


