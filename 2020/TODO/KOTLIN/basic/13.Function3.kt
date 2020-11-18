// 함수들
// ----------- api 

// 속성 
// var size:Int

fun var_size(){
    val list = arrayListOf("One", "Two")
    println(list.size) // print out 5
}

// 함수

fun function(){
    val list = arrayListOf("One", "Two", "Three")

    // fun contain(element: E): Boolean - 지정 항목이 컬랙션에 포함 되어있는지 반환 
    println(list.contains("Three"))

    // fun get(index: Int):E -- 지정된 인덱스의 항목을 반환
    println(list.get(2))

    // fun indexOf(element: E): Int --  지정된 항목의 인덱스를 반환, 리스트 처음부터 검색
    println(list.indexOf("Three"))

    // fun isEmpty:Boolean -- 컬랙션이 비어있는지 반환
    println(list.isEmpty())

    // fun subList(formlndex: Int, tolndex: Int) : List<E> -- 시작인덱스 부터 끝인덱스 전까지의 리스트를 반환 한다. 
    // 반환되는 리스트는 원본 리스트를 참조하기 때문에 이 리스트가 변경되면 원본리스트 역시 변경됨
    println(list.subList(1,3))

}

// 확장기능

fun morefunction(){
    val list = arrayListOf("One", "Two", "Three")

    // fun <T> Iterable<T>.all(predicate:(T) -> Boolean): Boolean -- 모든 항목이 지정된 조건에 만족할경우 true
    println(list.all{ it.startsWith("T") }) // false - 모든 항목의 시작이 T면 true

    // fun <T> Iterable<T>.any(predicate: (T) -> Boolean): Boolean
    list.any{ it.startsWith("T") } // true  - 하나 이상의 항목이 지정된조건에 만족할 경우 true

    // fun <T> Iterable<T>.asReversed(): List<T> -- 리스트의 역순리스트 반환 
    list.asReversed() 

    // fun <T> Collection<T>.containsAll(elements: Collection<T>) : Boolean -- 지정된 컬랙션의 모든요소가 리스트 내에 있는지 확인 후 반환
    list.containsAll(listOf("One", "Two")) // true

    // fun <T> Iterable<T>.count(predicate:(T)-> Boolean):Int -- 지정된 조건과 일치하는 항목의 개수를 반환 
    list.count(it.startsWith("F")) // 2

    // fun <T> Iterable<T>.drop(n:int):List<T> -- 처음 n개의 항목을 제외한 리스트 반환
    list.drop(2) // [Three]

    // fun <T> List<T>.dropLast(n: Int):List<T> -- 마지막 n개의 항목을 제외한 리스트를 반환 
    list.dropLast(2) // [One]

    // fun <T> Iterable<T>.filter(predicate:(T)-> Boolean) : List<T>
    list.filter{ it.startsWith("T")}  // [Three] -- 지정된 조건과 일치하는 항목만 포함하는 리스트를 반환 

    // fun <T> Iterable<T>.filterNot(predicate:(T)-> Boolean) : List<T>
    list.filterNot{ it.startWith("T") } // [One, Two] -- 지정된 조건과 일치하지 않는 항목만 포함하는 리스트를 반환 

    // fun <T> Iterable<T>.find(predicate: (T) -> Boolean):T? -- 지정된 조건과 일치하는 첫번째 항목을 반환 없을경우 null 
    list.find{ it.startsWith("T") } // [Two]
    list.findLast{ it.startsWith("T")} // [Three] - 자정된 조건과 일치하는 마지막 항목을 반환 항목이 없을경우  null

    // fun <T> List<T>.first(): T
    list.first() // 첫번째 항목을 반환 

    // fun <T> Iterable<T>.forEach(action: (T)-> Unit) -- 각 항목에 지정된 작업을 수행 
    list.forEach{print("$it ")}  //One Two Three  
    
    // fun <T> Iterable<T>.forEachindexed(action: (Index: Int, T) -> Unit)
    list.forEachindexed {i, e -> print("$e(${i+1}")} // 각 항목에 순차적으로 인덱스를 제공하며 지정된 작업을 수행 -One(1) Two(2) Three(3)

    // fun <T> List<T>.Last():T -- 마지막 항목을 반환 
    list.last() // five

    // fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> -- 모든 항목에 지정된 변환 함수가 적용된 결과 리스트를 반환 
    list.map{it + "!"} // [one!, Two!, Three!]

    // fun <T, R> Iterable<T>.mapIndexed(transform: (index, I) -> R): List<R> -- 인덱스와 함께 지정된 변환함수가 적용된 결과 리스트를 반환 
    list.mapIndexed{ i, e -> e +"(${i + 1}" } // One(1), Two(2), Three(3)

    // fun <T: Comparable<T>> Iterable<T>.max(): T? -- 가장 큰 값 반환 없으면 null
    list.max() // Two

    // fun <T: Comparable<T>> Iterable<T>.min(): T? -- 가장 작은 값 반환 없으면 null
    list.min() // five

    // fun <T> lterable<T>.minus(element: T): List<T> -- 지정항목이 제외된 리스트 반환 // 새로운 리스트를 만들어 반환한다.
    list.minus("One") // [Two, Three]

    // fun <T> Iterable<T>.plus(element: T): List<T> -- 지정 항목이 추가된 리스트 반환 // 새로운 리스트를 만들어 반환
    list.plus(listOf("Four", "Five")) // [One, Two, Three, Four, Five] 

    // fun <T> Iterable<T>.shuffled():List<T> -- 순서가 랜덤하게 섞인 새로운 리스트 반환
    list.shuffled() // [Two, Three, One]

    // fun <T: Comparable<T>> Iterable<T>.sorted():List<T> -- Comparable 인터페이스에 구현된 순서되로 정렬된 리스트 반환 // 새로운 리스트를 반환 
    list.sorted() // [One, Three, Two]

    // fun <T, R: Comparable<R>> Iterable<T>.sortedBy(selector: (T)->R?):List<T> -- 지정한 람다식(새로 식을 지정할 수 있다.) -- 람다식에 의한 순서대로 정렬된 리스트를 반환
    list.sortedBy{ it } // [One, Three, Two] -- 지정한 람다식 없이 바로 출력하므로 그대로 출력

    // fun <T> Iterable<T>.take(n: Int): List<T> -- 첫항 목부터 n개의 항목을 반환 
    list.take(2) // 첫 항목부터 n개의 항목을 반환 

}

// MutableCollection 메서드
fun MutableCollectionMethed(){
    val list = arrayListOf("One", "Two", "Three")

    // fun add(element: E):Boolean --- 리스트의 항목을 추가한다.
    list.add("Four")
    println(list) // [One, ..., Four]

    // fun clear() -- 모든 항목을 제거한다.
    list.clear()
    println(list) // []

    val list2 = arrayListOf("One", "Two", "Three")
    // fun remove(Element: E) : Boolean -- 하나의 항목을제거한다. 
    list2.remove("One") // 제거 할수 없다면 false를 리턴 하나보다.

    // fun removeAll(element: Collection<E>):Boolean -- 지정 컬랙션에 포함된 모든항목을 제거
    list2.removeAll(listOf("Two", "Three"))
    println(list) // []

    val list3 = arrayListOf("One", "Two", "Three")
    // fun retainAll(element: Collection<E>) : Boolean -- 지정 컬랙션에 포함되지 않은 모든 항목을 제거 
    list3.retainAll(listOf("One"))

}

// 각함수는 List, Set, Map에 따라 사용할 수 없거나 인자가 조금씩 다를 수 있음 
// 참고 https://kotlinlang.org/docs/reference/collections-overview.html