// if && when 

fun GetMax1(a: Int, b: Int): Int {
    var max = a
    if (a < b) max = b
    return max 
}

fun GetMax2(a: Int, b: Int): Int {
    var max: Int
    if(a < b) max = b else max = a
    return max 
}

// kotlin은 함수형 프로그래밍을 지원한다. 함수를 변수에 저장, 매개변수로 전달, 함수에서 새로운함수 만들어 반환가능 

fun GetMax3(a: Int, b: Int): Int {
    var max = if (a < b) b else a
    return max
}

fun GetMax4(a: Int, b: Int): Int = if(a < b) b else a

// if문 블럭 문 마지막 식이 블럭의 반환값이된다. // 궂이 return 안써도 됨 

// when ------------------- switch 함수 대체 함수 


fun printValue1 (a: Int) {
    when (a){
        1 -> println("value: 1")
        2 -> println("value: 2")
        else -> println("value else")
    }
}

fun printValue2(a: Int, str: String){
    when(a){
        str.toInt() -> println("str is a") // 함수가 값 대신 사용 될 수 있다.
        else -> println("str is not a")
    }
}

fun hasPrefix(x: Any) = When(x){
    is String -> x.strtsWith("prefix")
    eles -> false
} // smart cast 기능 - Any type으로 받은 x가 스트링인지 확인, 및 when 함수의 결과 값 역시 함수형으로 반환할 수 있다. 

// 매개 변수 없이 사용할 수 있다. 이경우 조건문이 true 일 경우 해당 구문을 실행한다.
fun checkValue(a: Int) {
    when {
        a.isOdd() -> println("$a is odd")
        else -> println("$a is even")
    }
}










