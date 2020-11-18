// 널 가능성 Nullability

//NULLPointerExcption -- Nullable 타입, Non-Null 타입 -- 널의 가능성을 체크함 

// non-Null 타입 
// 코틀린의 참조 변수는 기본적으로 Null 값 불가능 -
// so, null 값이 들어가거나 초기화하지 않았다면 컴파일러는 에러를 발생시킨다.


// but java에서는 null 값을 허용한다. 이를 적용하기 위해 '?' 을 사용한다.
// Nullable

// '?'는 모든 타입에 가능하고 Nullalbe 타입이라 정의된 경우에도 null 값이 가능하다. 

//ex

fun CreateBitmap(width: Int, height: Int): Bitmap?{
    if(width > 0 && height > 0) return Bitmap(width, height)
    else return null 
} 

// 반환되는 객체를 저장하기 위한 변수의 타입에도 nullable 을 명시해줘야한다.
// null이 될 수 있는 모든경우에 대한 예외 처리를 컴파일러에서 강제한다. 

fun main(arg: Array<String>) {
    val bitmap: Bitmap? = CreateBitmap(10, 10)
    //println(Bitmap.size) // 바로 참조 되지 못한다.
    if(bitmap != null) println(bitmap.size)

    // safe Call 안전한 호출 연산자 "?"
    println(bitmap?.size)
    // bitmap?.size - 왼쪽의 매개 변수가 null 타입인지 확인후 
    // null 이면 종료, 아니면 Non-null타입으로 변환하여 접근 
    // if(bitmap != null) println(bitmap.size) == println(bitmap?.size) 같은 의미 

    person.company?.addr?.city = "Seoul"   
    println(person.cityName2())
    // 이런식으로도 사용될 수 있다.
}

class address(val st:String, val zipCode: Int, val city:String)
class Company(val name:String, val addr:Address?)
class Person(val name: String, val company: Company?)

// name?:"unknown" -- null 이면 ?: 옆 부분 값 사용  

fun Person.cityname(): String{
    val address = this.company?.addr
    val city = address?.city
    return if (city != null) city else "Unknown"
}

fun Person.cityName2(): String {
    val city = this.company?.addr?.city
    return city?:"UnKnown"
}

fun Person.cityname3(): String {
    return this.company?.addr?.city?:"UnKnown"
}

// "!!" -- 절대 널 값이 오지않을 상황에서 절대 null 값이 올 수 없는 상황에서 
// nullable 타입의 변수를 사용해야할 때 Null heck가 없으면 컴파일 할 수 없는 상황에 사용  

// let 함수 -- Nullable 타입의 변수가 사용될 수 없는곳에 사용할 수 있는 방법 

fun letTest(){
    var bitmap: Bitmap? = CreateBitmap(10, 10)
    bitmap?.let{
        DrawBitmap(it)
    }
    // DrawBitmap 에서 쓸 수없는 Nullable 인자 값을 넣을 수 있게 해준다. 

}
