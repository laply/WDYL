// 확장함수 -- 확장 함수 정의

// 어떤 클래스 밖에서, 마치 그 클래스의 멤버인 것처럼 선언된 메서드 
// 클래스 내부에 있지 않지만 그 클래스 내부 멤버에 접근 할 수있고,
// 클래스 멤버 메서드와 동일한 방식으로 호출할 수 있다.


class Calculator {
    var lastResult: Int = 0

    fun sum(a: Int, b: Int): Int{
        lastResult = a + b
        return lastResult
    }
    fun minus(a: Int, b: Int):{
        lastResult = a - b
        return lastResult
    }
}

// 확장함수 -- but 확장함수는 클래스 내부에서만 사용할 수 있도럭 선언된 private 멤버, protected 멤버에 접근할 수 없다. 
fun Calculator.sum(a: Int, b: Int, c: Int) {
    lastResult = sum(a, b) + c
    return lastResult
}
fun Calculator.minus(a: Int) {
    lastResult = -a
    return lastResult
}

// 클래스 내부의 멤버 메서드와 동일한 함수명,
// 동일한 매개 변수를 가진 확장함수는 정의할 수 없다. 
// 확장 함수로 오버라이드 할 수 없다. -- 주의

fun main(args: Array<String){
    val calc = Calculator()

    println("1+2 = ${calc.sum(1,2)}")
    println("2-1 = ${calc.minus(2,1)}")

    // 확장 프로퍼티도 가능 
    val Calculator.signResult: Char
    get() = if(lastResult < 0) '-' else '+'
    // 접근은 - 그대로 접근 가능하다. 
}
