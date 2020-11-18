// 고차함수와 람다. 

// 고차함수 -- 매개 변수,반환값으로 또 다른 함수가 사용되는 함수
// call back 함수


// 자바에서 람다가 사용되기 전에 버튼 이벤트 처리
Button button = findViewId(R.id.button)
button.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View view){
        // --- 
    }
})

// 자바에서 람다가 사용가능해 지면서

button.setOnClickListener({
    // ----
}) 
// 요로코롬 간단하게 변함 

// 매개변수로 함수자체를 받는 함수를 '고차 함수' -- 매개변수로 전해지는 함수를 '람다' 라고 한다
// 람다식은 반드시 중괄호로 묶여 있어야 하며

{ variable1: type, variable2: type -> return } // 요로코롬 쓰인다.

fun a(){
    val sum1 = {x : Int, y: Int -> x + y } // 간결해진 문장 
    val sum2 = (Int, Int) -> Int : { x, y -> x + y } // 정식 포멧
}

// 익명 함수 -- Anonymous Function

fun AnonymousF(){
    Calculator(2, 1, {a: Int, b:Int -> a + b})
}

fun calculator(a: Int, b: Int, p: (Int, Int) -> Int ){ 
    println("$a, $b -> ${p(a, b)}")
    return p(a, b)
}
// 고차 함수에서는 람다식의 형식을 반드시 명시해 줘야하며 명시된 형식과 동일한 형식의 람다식만 전달할 수 있다. 

// 람다식의 표현 
fun expressLamda(){

    Calculator(2, 1) {a: Int, b: Int -> a - b} // 함수 호출시 맨 마지막 인자가 람다일경우 람다식을 밖으로 뺄 수 있다. 
    Calculator(2, 1) {a, b -> a*b } // 고차 함수에 람다식의 인자 타입명시시 표현식에서 삭제 가능 
    Square(2) {a -> a*a} // 람다식에 인자가 하나면 it을 사용해 인자를 생략할 수 있다.
    Square(2) {it*it}
    // 만일 호출하는 고차함수에 인자가 람다식 뿐이라면 호출 식의 소괄호 역시 생략가능하다.
    PrintInfo() { println("1.0")}
    PrintInfo { println("1.1")} // () 요로코롬 생략

}

fun PrintInfo(p: () -> Unit) { // 리턴값이 없는 경우 우우우우우우우우우
    print("Calculator Version: ")
    p()
}

fun PrintInfo2(p: (() -> Unit)? = null) { // 람다 역시 널타입이 될 수 있습니다아아아
    p()    
}

// 또한 익명 함수 뿐만 아니라 일반함수도 람다에 들어갈 수 있습니다. 

fun sum(a: Int, b: Int) = a + b

fun nomfuntionlamda(){
    Calculator(2, 1, ::sum)

    //당연히 함수 형 변수도 가능합니다.

    val minus: (Int, Int) -> Int ={a, b -> a-b}
    Calculator(2, 1,  minus)
}
