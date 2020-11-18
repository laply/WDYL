// 클래스 위임 class Delegation 

// -- 내가 구현해야할 추상 메서드, 추상프로퍼티들의 정의를 다른 객체에 떠넘기는 방법

// 모든 class가 기본적으로 final 형태라 상속이 되지 않는다. 
// 상속을 원한다면 상속될 클래스에 'open' 접근자를 명시해 줘야한다. 
// 그래야 open이 붙은 클래스를 수정할 때 하위 클래스가 있다는 사실을 상기 하여 수정할 수 있다!

// 그래서 상속기능이 필요할 때 데코레이터 패턴(Decorator Pattern)이라는 방식을 사용하는데, 
// 상속하고 싶은 클래스와 동일 인터페이스를 구현하는 새로운 클래스를 만들고 
// 상속하고 싶은 클래스는 내부에 멤버 변수(프로퍼티)로 가지는 방식이다.


// 위임은 상속의 종속성에 대한 문제점을 회피 하면서 구현을 좀 더 쉽게 해준다 

// arrayList 클래스를 상속받아 리스트의 모든 기능을 사용하되, 추가되는 원소의 개수를 카운트하는 기능을 넣고 싶다. 
// 근데, arrayList 클래스는 final이라 상속받을 수 없다고 가정하자.  
// 그래서 arrayList가 구현한 MutableCollection 인터페이스를 CountingSet이라는 새로운 클래스로 구현하고, 
// ArrayList 클래스는 프로퍼티로 가진뒤 add() 메서드를 재정의한다.

class CountingSet<T> : MutableCollection<T> {  
    var objectAdded = 0 
    val innerList = arrayListOf<T>() // 프로퍼티로 arraylist 받고 

    override fun add(element: T): Boolean {
        objectAdded++
        return innerList.add(element) // array list에 추가함 
    }

} 
// 그러나 여기서는 MutableCollection 클래스의 모든 추상 메서드와 프로퍼티들이 많이 저장되어있어 이모든것들을 재정의 해주어야한다.

class CountingSet2<T>: MutableCollection<T> {
    var objectAdded = 0
    val innerList = arrayListOf<T>() // 사용할 arraylist class를 호출 해서 사용 

    override fun add(element: T) : Boolean{
        objectAdded++
        return innerList.add(element) // array
    }

    override fun addAll(elements: Collection<T>): Boolean{
        objectAdded += elements.size // 여러개 받을때 
        return innerList.addAll(elements)
    }
    override val size: Int get() = innerList.size
    override fun isEmpty(): Boolean = innerList.size
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.contains(elements)
    override fun clear() = innerList.clear()
    override fun iterator(): MutableIterator<T> = innerList.iterator()
    override fun remove(element: T) : Boolean = innerList.remove(element)
    override fun removeAll(elements: Collection<T>): Boolean = innerList.removeAll(elements)
    override fun retainAll(elements: Collection<T>): Boolean = innerList.retainAll(elements)

} 
// 하지만 이같은 경우는 너무 복잡하다. 그래서 코틀린데서는 'by'키워드를 통해 추상 메서드를
// 이미 구현된 다른 객체로 넘겨버리는 '위임' 이라는 가능을 만들었다. 


// by 키워드는 구현되어야 할 추상 메서드들을 명시된 객체로 구현을 위임한다는 사실을 나타낸다. 
class CountingSet<T>(Val innerSet: MutableCollection<T>): MutableCollection<T> by innerSet { 
    // class를 선언할때 mutableCollection<T> 인터페이스로 선언한 객체로 갖고오고 
    // 이를 명시된 객체로 구현을 위임한다.
    var objectAdded = 0 
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }
    override fun addAll(c: Collection<T>): Boolean {
        objectAdded += c.size
        return innerSet.addAll(c)
    }
    //overriding 하지 않은 추상 메서드들은 결과적으로 mutableList 클래스에 정의된 구현을 따라간다.

}

fun main1(args: Array<String){
    val lset = CountingSet<Int>(mutableListOf())
    val hset = CountingSet<Int>(hashSetOf()) 
    // 위임 기능이 유용한점은 MutableCollection 인터페이스를 구현한 클래스라면 생성자의 매개변수로 사용가능
    // 해당 클래스에 구현된 내용대로 실행된다는 점이다. 
}

// 위임 프로퍼티 -- 프로퍼티 필드에 접근하는 접근자 로직을 다른 객체에 맡기는 방식
// getter, setter 메서드를 가지는 다른 객체를 만들어서 그객체에 프로퍼티의 필드 접근 로직을 위임하는 것 

class Person(val name: String, val _age: Int, val _salary: Int){ 
    var age: Int = _age
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var salary: Int = _salary
        get(){
            return field
        }
        set(value){
            field = value
        }
        // 궂이? - get, set 기능을 하는 메서드를 따로 클래스로 만들고, 프로퍼티의 개터와 세터에서 호출하는 방식을 사용한다면?
}

class Delegator1 (val fname: String) {
    var value: Int = 0

    fun getMethod(): Int {
        return value
    }

    fun setMethod(newValue: Int) {
        value = newValue
    } 
}

class Person1(val name: String){ // 처음 초기화 할 때, age, salary가 사용되지 않음 
    val ageDelegator = Delegator("age")
    val salaryDelegator = Delegation("salary")

    var age: Int 
        get() = ageDelegator.getMethod()
        set(value: Int) = ageDelegator.setMethod(value)
    var salary: Int
        get() = salaryDelegator.getMethod()
        set(value: Int) = salaryDelegator.setMethod()

}

// 요론식으로 나누어 할 수 있는데, 위임을 사용하면 더 간단히 표기가능하다.

import kotlin.reflect.*

class Delegator2(var value: Int){
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("$(property.name) get: $value")
        return value
    }
    // thisRef =  위임을 사용하는 클래스와 같은 타입이거나 Any타입이이여야한다. 
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Int){
        value = newValue
    } 
}

class Person2(val name: String, age: Int, salary: Int) {
    var age: Int by Delegator2(age) // 위임 받을 클래스에는 getValue, setValue 메서드가 구현되어 있어야한다. //operator 필수
    var salary: Int by Delegator2(salary)
}

fun main2(){
    val p = person("Mongues", 20, 2000)
    p.age = 21
    p.salary = 2100
}

// 위임 프로퍼티 2 
// by Lazy() -- 지연초기화 (Lazy Intialization)

// 지연초기화는 프로퍼티의 초기화를 객체 생성때 하지 않고 필요할 때 초기화 하는 패턴이다. 
// 예를 들어 객체 생성시 서버에 연결하고 연결이 완료되면 데이터를 수신해서 프로퍼티에 값을 넣는 경우라거나 등등 

// Person class를 다시한번 예로 들어보면 - 프로퍼티로 주소록을 저장하는 리스트 'addrBook'을 가지고 있을때
// 라스트는 데이터베이스에 저장되어있고, 리스트를 읽어온느데 시간이 많이 걸리기 때문에 
// 생성시 초기화 하는 것이아니라, 주소록에 접근할 일이 있을때 데이터 베이스 에서 일겅온 값으로 초기화 하고싶다. 

data class Address(val name:String, var phone: String, var addr: string=""){}

fun loadAddBook(p: Person): List<Address>{
    // 로드 및 리턴
    return listOf() // 리스트 
}

class Person3(val name: String){
    private var _addrBook: List<Address>? = null
    val addrBook: List <Address>
        get(){
            if(_addrBook == null) _addrBook = loadAddrBook(this)
            return _addrBook!! // 널이던지 아니던지 리턴해!!!! 
        }
    // 지연초기화의 한 방식  
}


// 이런 귀찮은 수고를 없애기 위해 by lazy() 를 사용한다!! 


class Person4(val name: String){
    val addrBook by lazy ({loadAddBook(this)})
}

// 획기적으로 줄일수 있다!!!!!!!!!!!!

// 그러나 var 타입 프로퍼티에서는 사용할 수 없고,(그래서 세터 구현 불가능) 클래스 생성자에서 사용할 수 없다.

// Observable 

// 코틀린에서는 프로퍼티에 값이 할당될때 처리할 메서드를 등록할수 있는 메서드를 제공한다. 
// "Delegates.observable()" 메서드 
// observable() 메서드에서는 람다 식을 파라미터로 전달받아 setValue()메서드가 구현된 객체를 반환한다. 
// 그래서 위임프로퍼티 1에서 처럼 Delegator 없이도 사용할 수있다. 

import Kotlin.property.Delegates

class person5(val name: String, age: Int) {
    var age: Int by Delegates.observable(age) {
        prop, old, new -> println("${prop.name} set! $old->$new")
    } // 람다식을 전달 하는 것만으로도 프로퍼티가 바뀔때 수행될기능을 지정 할 수있다. 
}

fun setperson(){
    val p = person5("he", 20)
    p.age = 21
}

/// Delegates.observable() 
fun <T> observable(initialValue: T, onChange: (property: KProperty<*>, oldValue: T, newValue: T)-> Unit) : ReadWriteProperty<Any? , T>
// 여기서 매개변수가 initialValue 하나라고 생각한다면! 오류! 
// 람다식도 매개변수 마지막 매개변수가 람다식일경우 () 뒤로 뺄 수 있다아아아


// Map
// 코틀린의 Map과 MutableMap 인터페이스는 getValue()와 setValue()에 대한 확장 함수를 제공하고 있다.
// 즉 위임이 가능하다.

class person6(val map: MutableMap<String, Any?>)
    val name: String by map
    var age: Int by map
    var salary : Int by map 
}

fun main3(){
    val p = person6(mutableMapOf("name" to "he", "age" to 20, "salary" to 2000))
    p.salary = 2100
    println("name: ${p.name}, age: ${p.age}, salary: ${p.salary}") // map으로 되어 출력한 모습 
}