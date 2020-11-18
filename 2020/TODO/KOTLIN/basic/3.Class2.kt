// 클래스의 초기화 블록 

// 프로퍼티를 초기화 하는 것 말고 다른 기능을 객체가 생성되는 시점에 하기

class Button(var id: Int){
    var text: String = ""

    init {
        println("Initializer Block: $id, $text")
    }
    constructor(id: Int, text: String): this(id){
        this.text = text
        println("constructor(id text) : ${this.id}, ${this.text}")
    } 

}
// 실행 순서는 (주), 초기화블록, 부 순서 // 즉, 주 생성자가 없을때에도 초기화 블록 설정 

// 클래스의 상속 

// 상속 제어 변경자 - final
// 자바와 같이 final을 사용했을 때 상속이 금지된 상태이다. 
// 해당 클래스를 상속 가능하게 만들려면 class 키워드 앞에 open 상속제어 변경자를 사용해야한다. -- 기본값은 final // open 해서 사용 
// open 상태의 메서드, 프로퍼티를 오버라이딩 할대는 멤버 앞에 'override' 키워드를 반드시 사용해야함 
// 프로퍼티나 메서드를 override를 하면 자동으로 open된다 다음세대부터 안했으면 좋겠다면 final로 설정

// interface 인터페이스 class의 경우 class 앞에 open 붙이지 않아도 사용가능 
// interface의 멤버는 (자동으로 open됨) final로 설정할 수 없다. 

// 추상 클래스의 경우 abstract 키워드를 사용한다. - abstract 역시 멤버들은 자동으로 open 
// 추상 클래스 정리 필요 

open class Book(val title: String, var prive: Int) {
    open fun printInfo() {
        println("Title: $title, Price: $price")
    }
}

class EBook(title: String, price: Int, var url: String): Book(title, price) {
    // override 해서 받아왔지만 다음부터는 안됨.
    final override fun printInfo(){
        println("Title: $title, Price: $price, URL: $url")
    }

}

open class Book1(val title: String, var price:Int)

class EBook: Book{
    var url =""
    constructor(title: String, price: Int, url: String): super(title, price){
        this.url = url
    }
}
