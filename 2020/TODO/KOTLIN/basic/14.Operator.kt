// 연산자 오버로딩

// 연산자를 오버로딩하기 위해 각 연산자에 대입되는 특정한 함수 이름을 사용해야한다. 

// 1. 이항연산자 

// 연산자 : 함수
//------------------
// a + b : a.plus(b)
// a - b : a.minus(b)
// a * b : a.times(b)
// a / b : a.div(b)
// a % b : a.rem(b)


// 각 연산자는 위 표에 나타난 함수로 번역되어 실행된다. 
// 즉, "a + b" 연산을 새롭게 정의하고 싶다면 "plus" 메서드를 정의해 주면 된다. 

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point){ // override 키워드가 아니라, operator 키워드를 붙어야한다.
        return Point(x + other.x, y+ other.y)
    }
}

fun firstOperator(){
    val p1 = Point(10, 20)
    val p2 = Point(20, 40)

    println(p1 + p2) // Point(x=40, y=60) -- p1.plus(p2) 로 변환되어 Point의 plus 메소드가 실행됨 
}

// 2. 단항연산자 

// 연산자 : 함수
//-----------------------
//  +a   : a.unaryPlus()
//  -a   : a.unaryMinus()
//  !a   : a.not()
//  ++a, a++ : a.inc()  // 일반적인 전위, 후위 연산의 방법과 동일하게 사용된다. 
//  --a, a-- : a.dec()  // 즉, ++연산을 앞에 쓰면 증가후 반환, 뒤에 쓰면 반환후 증가 -- but 객체가 증감되기 때문에 val 타입이 아니라 var 타입 이어야함 


data class Point(val x: Int, val y: Int) {
    operator fun unaryMinus(){ // override 키워드가 아니라, operator 키워드를 붙어야한다.
        return Point(-x, -y)
    }
}

fun secondOperator(){
    val p1 = Point(10, 20)

    println(p1) // Point(x=-10, y=-20) -- p1.unaryMinus() 로 변환되어 Point의 unaryMinus 메소드가 실행됨 
}

// 3. 복합 대입 연산자 

// 연산자 : 함수
//------------------
// a += b : a.plusAssign(b)
// a -= b : a.minusAssign(b)
// a *= b : a.timesAssign(b)
// a /= b : a.divAssign(b)
// a %= b : a.remAssign(b)


// 4. 비교 연산자 

// 연산자 : 함수
//------------------
// a == b : a?.equals(b)?: (b===null) -- a가 null이 아닐경우 a.equals(b)를 실행하여 결과를 반환, a가 null일 경우 b가 null인지 확인하여 결과 반환 
// a != b : !a?.equals(b)?: (b===null) -- "===" 객체가 완전한 동일 연산자 인지 확인 하는 연산자
// a > b : a.compareTo(b) > 0
// a < b : a.compareTo(b) < 0
// a >= b : a.compareTo(b) >= 0
// a <= b : a.compareTo(b) <= 0


// 5. 그외 연산자 

// 연산자 : 함수
//------------------
//  in   :  a.contain(b)
//  ..   :  a.rangeTo(b)
//  a()  :  a.invoke()