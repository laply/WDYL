
fun main(args: Array<String>) : Unit { // 반환값이 없을 경우 Unit 사용 
    println(sum(1, 2));
    

    val person = Person("hi", 20)

    person.age = 21 // 나이는 바꿀수 있지만 이름은 변경불가 

    println(person.name) 
}

// function 
// 같은 함수의 다른 표현 
fun sum (a: Int, b: Int) : Int {
    return a + b;
}
fun sum2 (a: Int, b: Int) : Int = a + b

// 타입 추론해서 사용가능 
fun sum3 (a: Int, b: Int) = a + b 

// 매개변수의 디폴트 값 
fun sum4 (a: Int, b: Int = 10) = a + b
fun sum4 (a: Int, b: Int = 10) = a + b


// 변수 variable - var와 val
fun variable(){
    // 변경 가능한 변수
    var name: String = "hithere"
    var age: Int = "20"
    var typefigure = "data"

    // 변경 불가능한 변수 -- 객체 참조 할때 많이 사용 한다.
    val hi = "aaa"
}
 