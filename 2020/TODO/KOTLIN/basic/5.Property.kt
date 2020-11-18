// property 프로퍼티 

// 멤버 변수의 필드와 게터, 세터를 묶어 프로퍼티라고한다. 

// 프로퍼티는 개터와 세터라는 접근자를 가진다. 
// 사용자가 직접 구현하지 않을 경우 컴파일러가 자동으로 접근자를 만들어준다.

class Rectangle1 {
    var height: Int = 0
    var width: Int = 0
}

// 컴파일러가 만들어주는 개터와세터 

class Rectangle2 { 
    var height: Int = 0
    get() = field
    set(value){
        field = value
    }

    var width: Int = 0 
    get() = field
    set(value){
        field = value
    }
}

// 프로퍼티에 접근하기 위해 get()과 set()을 써야하지만,
// 프로퍼티의 이름을 써주기만 해도 코틀린 컴파일러가 알아서 호출해줌

fun main(args: Array<String>){
    val rect: Rectangle2()
    rect.height = 10
    rect.width = 20
}

// 프로퍼티 타입이 var가 아닌 val 타입이면 컴파일러는 게터만 만들고 세터는 만들지 않는다.

class Rectangele(var height: Int, var width: Int){
    val isSquare: Boolean
    get() = height == width

    // 원래 val 타입은 세터가 없음 but, 이 경우 isSquare는 자체 값을 저장하는 필드가 필요없음 
    // 직접 게터나 세터를 작성할 수 있음  -- but 커스텀 접근자에서 필드 값에 접근할 때에는 field 키워드를 사용한다. 

    init {
        isSqure = if (height == width) true else false
    }
    
    var conter: Int = 0
    private set
    // 접근자 가시성 변경가능 -- 여기서는 class 안에서만 setter 사용가능 하도록 수행 

    fun addWord(word: String) {
        counter += word.length 
    }   

}