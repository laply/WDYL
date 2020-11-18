//List
// array 




// 코틀린 리스트는 기본적으로 변경 불가능한 방식이다다다
fun Listlist(){
    val list: List<Int> = List(5, {i -> i}) 
    println(list)
    // 생성자에 리스트의 길이와 초기화를 위한 람다식을 넣어주는 것으로 객체를 생성할 수 있다. 
    // 출력 : {0, 1, 2, 3, 4}
    
    val list2 = listOf(1, 2, 3, 4, 5) // 또한 리스트of 함수를 이용해 생성가능하다.
    // 리스트의 요소는 get() 메서드 없이 대괄호로 "[]" 접근가능하다
    println("$list2[2]")
    
    // Immutable 타입이기 때문에 대입은 불가능 하다. -- 처음 초기화 후 변경 불가능 
    // 변경 가능한(mutable) 리스트를 만들기 위해서는 ArrayList, MutableList를 사용하면된다. 
    // 생성자 초기화나 mutablelistof(), ArrayListOf() 함수를 통해 초기화 할 수 있다. 
    val array1 = MutableList<Int>(5, {i -> i})
    array[0] = 10 // -- 가능!
    val array2 = MutableListof(1, 2, 3)

}

// List와 달리 중복을 허용하지 않으며 순차적이지 않은 데이터의 집합 
// Mutalbe type과 immutable type을 이용한다. 
fun Setset(){

    //기본적인 set class 는 immutable 타입
    val set: Set<Int> = setOf<Int>(3, 3, 1, 2) // 3 하나만 들어감 

    // Mutable 타입의 set은 mutableSetOf, hashSetOf, linkedSetOf, sortedSetOf 등의 함수를 이용해서 만듬 
    // 각 함수는 MutableSet<T>, HashSet<T>.. 의 객체를 만들어 반환
    val set1: MutalbeSet<Int> = mutableSetOf(3, 3, 1, 2) // 3 하나만 들어감 
    set1.remove(2)
    set1.add(5)

    val set2 =hashSetOf(3, 1, 2) // 은 해시코드 순으로 검색됨 
    println(set2) // [1, 2, 3] 요렇게 출력 
}


fun Mapmap(){
    // 키, 값으로 이루어진 한쌍의 데이터를 관리하는 집합, 순차적이지 않으며 키는 중복될 수 없고, 값은 중복될수 있다.
    // Immutable 타입, mapOf() 함수로 생성된다.  

    val map1: Map<String, Int> = mapOf("one" to 1, "two" to 2)
    val map2: Map<String, Int> = mapOf(Pair("Four", 4))

    // Mutable타입의 map은 mutableMapOf, hashMapOf, linkedMapOf, sortedMapOf 등의 함수에 의해 생성
    // 각각                MutableMap<K, V>, HashMapOf<K, V>.. 등의 객체를 만들어 반환한다.

    val mapMul1 = mutableMapOf("One" to 1)
    val mapMul2 = hashMapOf("One" to 1, "Two" to 2)

    mapMul1.put("Ten", 10)
    mapMul2.set("Two", 20)
    map2.remove("One") 


}

