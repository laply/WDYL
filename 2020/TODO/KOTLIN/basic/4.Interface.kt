// interface

// 인터페이스 선언

// interface 키워드로 정의한다.
interface Cliackable {
    fun click()
    // 인터페이스를 구현하는 클레스에서는 click() 메서드를 반드시 구현해야한다. 
    fun showOFF() = println("i'm clickalbe") 
    // 구현된 메서드가 포함될수 있지만 default 구현과 같은개념
    // default 키워드를 붙이지 않아도 된다. 
}
// 인터페이스의 추상메서드를 구현하기 위해선 앞에 override 키워드를 붙혀줘야한다. 

class Button: Clickable {
    override fun click() = println("I was clicked") // 추상 메서드 구현 
}

interface Focusable {
    fun setFocus(b: Boolean)
    fun showOFF() = println("i'm Focusable") 
}

class Button2: Cliackable, Focusable{
    override fun click() = println("I was clicked")
    override fun fun setFocus(b: Boolean) = println("$b")
// 다중 interface에서 같은 method 존재 시, class 내부에서 super키워드 사용하면됨
    override fun showOFF() {
        super.<Focusable>.showOFF()
    }
}

// 인터페이스 클래스는 추상 메서드 외에도 추상 프로퍼티를 가질 수 있다. 
interface User{
    val nickname: String
}
// 인터페이스에서는 가질 수 없으며, 구현하는 클래스에서 추상 프로퍼티를 호출해야함 
class PricateUser(override val nickname: String): User