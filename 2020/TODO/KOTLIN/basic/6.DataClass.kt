// 데이터 클래스 -- 클래스가 메서드 없이 프로퍼티만 가질 때 사용할 수 있는 class 

// class 키워드 앞에 data를 붙혀서 사용 
// - 데이터 클래스가 아니더라도 프로퍼티만 가질 수 있지만 
// - 필수 메서드 자동 생성이 가능 하다. 

// toString(), equals(), hashCode() 
// override 하지 않는다고 컴파일 에러가 나지는 않지만 용도를 보면 구현 필수 


// toString() 
// -- 인스턴스를 문자열로 변환해서 반환하는 역활을 한다.
// override fun toString() = "Client (name: $name, postalCode: $postalcode)" 이렇게 출력 

// equals()
// -- 같은 값을 갖고 있는지 확인 // (Any == 코틀린 최상위 클래스) ? == null 값을 가질 수 있다.
//  override fun equals(other: Any?) : Boolean {
//      if(other == null ||  other !is Client) return false
//      return name == other.name && postalCode == other.postalCode  
//  }

// hashCode()
// overrid fun hashCode(): Int = name.hashCode()*31 + postalcode 

// copy()
// 데이터 클레스가 포함하는 프로퍼티는 val 타입으로 설정 하면 편함  
// 불변 클래스로 사용해야함 
// 데이터를 수정해야할 경우 copy() 메서드를 제공한다. 이거 사용
 

data class Client(val name: String, val postalCode: Int)

fun main(){

    val client = Client("이름", 0010)
    val client2 = Client("이름", 0010)
    val clientSet = hashSetOf(Client("이름", 0010))
    val client3 = client2.copy(postalCode = 1236) // 이런 식으로 변경가능 

    println(client) //"Client (name: $name, postalCode: $postalcode)" 출력 
    println(client.equals(client2))
    println(clientSet.contains(Client("이름", 0010)))
}



