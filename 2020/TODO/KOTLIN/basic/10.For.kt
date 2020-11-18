// while, do while, for 

// while, do while java와 동일하다.
fun WhndoWn(){
    var x = 10
    while (x > 0 ) println("${x--} ")

    do {
        println("${x++} ")

    } while( x < 10 )
}

// in .. 

// ".." 연산자는 범위를 만든다.

fun inanddotdot(){
    val oneToTen = 1..10 // 이 범위는 숫자 '1'에서, '10'까지의 구간을 가진다. (양끝을 포함함)

    fun inLetter(c: Char) = c in 'a'..'z'|| c in 'A'.. 'Z'
    fun inNotDigit(c: Char) = c !in '0'..'9' // in 연산자는 매개변수가 범위 안에 들어있는 지 확인하는 연산자. 
    
    // !in 연산자는 값이 범위에 들어있지 않을경우 true를 반환한다. 

    // in .. 은 숫자나 문자 범위에만 국한되지 않는다.
    fun indatarray(arr1: Array<String>) println("kotrlin" in "Hello".."There")
 
}

fun forfofofofor(){
    for (i in 0..9) print("$i ") // 오름차순

    for (i in 10 downTo 1 stop 2) print("$i ") // 내림차순 stop 2는 2씩 감소 된다.
    
    for (i in 0 until array.size) println(array[i]) // 마지막 값 포함 되지 않는다.


    // 0 until array.size == 0.until(array.size)

    val strList = arrayListOf("Hello", "there", "welcome")
    for (str in strList) println(str)
    for ((index, value) in strList.withIndex()) // 요론식으로 키와 값을 분리하는 것도 가능하다 


}

