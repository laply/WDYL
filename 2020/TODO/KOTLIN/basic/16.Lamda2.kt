// 람다

// 코틀린은 함수형 언어이기 때문에 람다 식을 통해 함수를 값으로 표현 할 수 있고, 
// 람다 식은 하나의 타입처럼 사용할 수 있다.

// lamda 

// 기본적으로 람다에는 매개변수의 타입과 반환타입이 명시 되어야하고, 타입 추론에 의해 생략할 수 있다면 생략할 수 있다.

val sum : (Int, Int) -> Int = { x: Int, y:Int -> x + y }
val minus : (Int, Int) -> Int = { x, y = x + y }
val mul = {x: Int, y: Int = x * y}

val hello : () -> Unit = { println("hello")}
 // 반환 값이 없을 경우 Unit 키워드로 반환 값이 없다는 것을 명시한다.
val there = {println("there")}


fun main1(){
    println("sum: ${sum(1,2)}")
    hello(); there()
}

// 람다에 Nullable type
val NullableReturn: (Int, Int) -> Int? = { x, y -> null } // 실제로 널 값을 리턴 하는 모습 


// 고차함수 -- 람다를 매개 변수로 받는 고차함수를 정의해보자 

fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int ) = operation(a, b) //  받는 함수의 정의 부분 만 들어가 있다. 
fun calculator1(a: Int, b: Int, operation: (Int, Int) -> Int = { a, b -> a*2 + b } )
 // 다른 매개 변수와 마찬가지로 디폴트 값을 지정 할 수 있다.  

fun main1(){
    val sum = { x: Int, y: Int -> x + y }
    println(calculator(1, 2, sum))  // return 3
    println(calculator(2, 1, { x: Int, y: Int -> x - y })) // return 1

}


// 함수 반환 
// 람다를 매개 변수로 받는 경우 뿐만 아니라, 반환 값으로 함수를 넘겨줘야하는 경우도 있다. 

enum class Operator {SUM, MINUS}

fun calculator2(op: Operator?): (Int, Int) -> Int { // 리턴 값을 함수로 지정 
    if (op == Operator.SUM) return { x, y -> x + y }
    else if (op == Operator.MINUS) return { x, y -> x - y } 
    return { x, y -> x*10 + y }
}


// 람다의 패널티 -- 인라인 함수

// 고차 함수에서 람다를 사용할 경우 런타임시 특정 패널티가 발생한다. 
// 람다를 사용하면 각 함수는 객체로 변환되어 메모리 할당과 가상 호출 단계를 거치게 되는데, 이는 런타임 오버해드를 초래한다. 

fun calculator3(a: Int, b:Int, op: (Int, Int) -> Int): Int = op( a, b )

fun main2(){
    println( calculator(1, 2, {a: Int, b: Int -> a + b}))
}

// calculator 함수를 예제로 보자면 -- 컴파일 시 이코드는 아래와 비슷한코드로 변환된다.

fun calculator3(a: Int, b: Int, op: Function2<Int, Int, Int>) : Int {
    return op.invoke(a, b)
}

fun main2(){
    val f2: Function2<Int,Int,Int> = {a, b -> a + b}
    println( calculator(1, 2, {a: Int, b: Int -> a + b}))
}

// 보면, 컴파일 단계에서 함수 타입의 변수, 즉, 람다를 FunctionN 인터페이스를 구현한 '객체' 로 저장한다. 
// 코틀린 표준 라이브러리는 매개 변수 개수에 따라 Function<R>, Function<p1, R> ... Function22<>가지 제공되고 
// 각 인터페이스에는 매개변수 개수에 맞는 invoke() 메서드가 하나씩 선언되어있다. 

// 컴파일러는 FunctionN 인터페이스의 invoke() 메서드 내에 람다 식을 구현하고, 해당 객체를 파라미터로 사용하는 것이다.
// mai2 에서 매개변수로 전달한 "{a:Int, b:Int -> a + b} 람다 식은 매개 변수가 두개이므로, Function2<Int, Int, Int> 
// 인터페이스르 구현한 임의의 객체로 생성되어 calculator()의 'op' 매개 변수로 전달된다.

// 만약 calculator() 함수를 다른 람다식을 사용해서 여러번 실행할 경우 람다 식마다 각각의 객체가 생성되어 메모리에 저장 되고 
// invoke() 함수가 각각 호출되기 때문에 메모리 할당과 가상호출에 의한 런타임 오버해드가 발생한다. 

// 인라인 함수 -- 람다를 매개변수로 사용하는 고차 함수를 '인라인 함수(Inline Function)'으로 정의하여 오버해드를 줄일 수 있다. 

// 인라인 함수는 컴파일 단계에서 호출하는 방식이 아니라 코드 자체가 복사되는 방식으로 컴파일 된다. 

fun sum1(a: Int, b: Int) = a + b
fun main(){
    val result = sum(1, 2)
    println(result)
}
 
// 이 코드가 컴파일 되면 sum() 함수에 바이트 코드가 메모리에 할당되어 있고, 
// main() 의 내용은 sum() 함수 의 바이트코드가 저장된 "주소를 호출하는" 바이트 코드를 포함 할 것이다. 

// but inline 키워드르 붙여 인라인 함수로 선언하면, 컴파일러는 main() 함수에서 sum() 함수를 호출하는 모든 부분을
// sum() 함수의 본문인 "a+b"로 복붙 한다. 


// 실행 단계에서는 아래 와 같은 코드의 형태가 된다.
inline sum2(a: Int, b: Int) = a + b

fun main3() {
    val a = 1
    val b = 2
    val result = a + b // sum()이 인라이닝 됨 
    println(result)
}


// noinline 

// 만일 매개 변수로 받는 람다가 2개 이상이고, 일부람다는 inline 방식을 사용하고 싶지 않을때에는! 
// 인라인 함수 선언시 해당 파라미터 앞에 noinline 키워드를 붙혀주면된다.

inline fun inlineFun(op1: () -> Unit, noinline op2: () -> Unit) {} 
// 요런 식으로오오오오오오오오오오 


// 인라인 함수를 썼을때 코드의 길이는 더 길어진다. 인라인 함수도 효율적으로 잘쓰면 된다.


// 람다의 리턴! 

// 코틀린 람다식에서는 return을 사용할 수 없다. return은 명명된 메서드나 익명 함수 에서만 사용할 수 있다. 

data class Person(val name: String, val age: Int)

fun findPerson(op: () -> Unit){
    op()
}

inline fun findPerson2(op: () -> Unit){
    op()
}

fun main3(){
    val people = listOf(Person("a", 21), Person("b". 24))
    findPerson{
        for (person in people){
            if(person.name == "b"){
                println("Find")
                return 
            }
        }
        println("nothing")
    }
    // findPerson 함수를 사용하면 return 부분에서 에러 메세지가 발생한다. 
    
    findPerson2{
        for (person in people){
            if(person.name == "b"){
                println("Find")
                return 
            }
        }
        println("nothing")
    }
    // 인라인 함수에서는 return을 사용할수 있다.
    // 하지만 람다를 인자로 받는 인라인 함수도 또한 함께 종료시킨다.


    // 그렇다면 어찌 해야할까 ? 
    
    // 레이블을 이용한 local Return 을 이용하면 된다. 
    
    findPerson lable@{ // 레이블 선언!
        for (person in people){
            if(person.name == "b"){
                println("Find")
                return@lable // 레이블 위치로 반환 ! -- return 과 @lable 사이에는 띄어쓰기가 없어야한다. 
            }
        }
        println("nothing")
    }

    findPerson{ 
        for (person in people){
            if(person.name == "b"){
                println("Find")
                return@findPerson // 또는 반환될 지점의 함수명을 바로 레이블로 사용 할 수도 있다!  
            }
        }
        println("nothing")
    }


    // 익명 함수에서의 return도 가능하다. 
    // 만약 람다식에서 return을 여러곳에서 해야할 경우라던지, 레이블을 사용하기 곤란한 경우가 생긴다면 람다식을 
    // '익명 함수'로 바꿔 사용 할 수있다. 

    findPerson( fun() { // 익명함수는 말 그대로 함수명 없이 fun 키워드와 매개 변수 만으로 선언된 함수를 뜻한다. 
        for (person in people){
            if(person.name == "b"){
                println("Find")
                return 
            }
        }
        println("nothing")
    })
}


