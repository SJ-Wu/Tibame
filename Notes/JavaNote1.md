# Java Programming Notes

## 基本語法
### 變數使用

|          | 區域變數  | 實體變數 |
| -------- | -------- | -------- |
| 宣告 | 宣告在方法裡面, 或是流程控制的區域裡面| 宣告在方法外, 類別裡面, 而且沒有static關鍵字|
| 初始值 | 沒有預設初始值, 存取之前, 程式設計師要主動給予初始值。可以先宣告後再給值| 宣告後, Java會自動給予預設初始值, 根據資料型別有不同的初始值。若是想要指定自己的初始值，只能在宣告的同時指定。|
| 存取 | 只能在自己所宣告的區域內使用, 不能跨區直接使用| 只要在同個類別裡, 可以跨不同方法使用(該方法不可以有static關鍵字), 透過物件參考變數存取|
| 生命週期(Scope)| 如同名稱, 跟著自己所屬的區域或方法, 執行時存活, 當該區域或方法執行完畢, 此變數即被釋放| 如同名稱, 跟著所屬的物件實體創建而存在, 只要該物件實體還在, 此實體變數就會隨著物件存活著, 直到該物件消失才結束|

### Label語法使用
1. 只能搭配迴圈使用
2. 常搭配if語法使用
    1. break 用法
    ```java=
    label: //標籤
    while(i < m){
        while (j < n){
            if (j > p){
                break label; //直接跳出label
            }
        }
    }
    ```
    2. continue 用法
    ```java=
    label: //標籤
    while(i < m){
        while (j < n){
            if (j > p){
                continue label; //回到label開始
            }
        }
    }
    ```
### 陣列(Matrix)
1. 宣告方式
```java=
int[] scores1 = {100, 100, 98, 97, 80};
int[] scores2 = new int[5]; //先宣吿>0的陣列數量
Pen[] myPens = {new Pen(), new Pen(), new Pen(), new Pen(), new Pen()}; //類別陣列的宣告
Pen[] myPens = new Pen[5]; //類別陣列的宣告

int xx[][] = {
    {1,2,3},
    {4,5,6}
};
int xx[][] = new int[3][3];
```
2. 陣列長度： {matrix}.length, {matrix2d}[x].length
```java=
int[][] intArray = { 
// {intArray[0][0], intArray[0][1], intArray[0][2], intArray[0][3], intArray[0][4]}
    { 1, 2, 3, 4, 5 }, // intArray[0]
    { 6, 7, 8, 9, 10 } // intArray[1]
};
int sum = 0;
for (int i = 0; i < intArray.length; i++) {
    for (int j = 0; j < intArray[i].length; j++)
        sum += intArray[i][j];
}
```
3. 非矩形的多維陣列
```java=
int xx[][] = new int[4][]; 
xx[0] = new int [3]; 
xx[1] = new int [4]; 
xx[2] = new int [5]; 
xx[3] = new int [5];
```
4. 陣列的指定運算(=)
```java=
int[] array1 = {1,2,3,4,5};
int[] array2 = array1; // 將array1的位址指定給array2
for (int i = 0; i < array2.length; i++){
    array2[i] = 0; // 將array2的值清0
}
for (int i = 0; i < array2.length; i++){
    System.out.print(array[i]); //array1的值也變成0
}
```
5. 陣列的排序搜尋與複製
    - 匯入(import)
    ```java=
    import java.util.Arrays
    ```
    - 排序(Sorting) 
    ```java=
    Arrays.sort(array_name);
    ```
    - 複製(Copy of)
        1. 複製出的陣列不用預先初始化(不用new)
        2. 一維陣列使用
        3. 指定範圍複製：copyOfRange(array_name, from, to)
        ```java=
        new_array_name = Arrays.copyof(array_name, array_name.length);
        ```
    - 搜尋(binary search)
        1. 搜尋前需要將陣列先排序
        2. 回傳索引值
        3. 回傳值<0, 不存在陣列中(最後的陣列位置取負值再減1)。
        ```java=
        Arrays.sort(array_name);
        return_index = Arrays.binarySearch(array_name, search_value);
        ```
### 字串(String)
1. 字串的不可變性:
    - String一旦宣告後，即不能在原所在記憶體位置改變字串內容
    - 程式裡若有多個變數，都使用相同的字串常數(如=“Hello”)，則均會使用相同的記憶體空間(即字串池String Pool)
    - 使用String類別任何方法時，==傳回的字串==都會放在新的記憶體空間。
2. 字串池
```java=
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");
```
![](https://i.imgur.com/ztiYJeV.png)

3. 字串的比較方式(==, equals)
    - "==": 比較的是記憶體位址，而非內容。
    - ==比較內容: s1.equals(s2)==
4. 常用字串方法：
    - charAt(index)：==索引從0開始==
    - length(): 包含空白字元
    - isEmpty(): 是否是空字串 ==(null)==
    ```java=
    String s4 = ""; // 空字串, isEmpty() = true
    String s4 = " "; // 空白字元, isEmpty() = false
    System.out.println(s4.isEmpty());
    ```
    - trim(): 去除頭尾的空白
    - substring(beginIndex)
    - substring(beginIndex, endIndex): //不選取結束索引值的字元
    - compareTo(): 由左至右比較字元ASCII的大小
### 不固定參數機制(varargs)
1. 在方法內使用"..."，宣告為可變數目的參數。
2. 可變參數必須放在參數列的==最後面==
3. 方法中==只能有1個==不固定參數的宣告
4. 在方法內部當作方法使用。
```java=
public int varArgTest(int data, int... c) {
    for (int i = 0; i < c.length; i++) {
        System.out.print(c[i] + " ");
    }
}
```
### 標註(Annotation)
* "@"關鍵字(JDK 5 Annotation(標註)): 給Java編譯器或相關工具/框架看的資訊
1. @Override: 強制編譯器以override規則編譯。
## 方法(Method)
### 方法的呼叫(Calling method)
1. 同一類別：可直接呼叫方法。
2. 不同類別：利用[.]運算子來呼叫不同類別的方法。

### 方法的負載(Overloading)
1. 根據參數的數目及資料型態呼叫對應的方法。
2. 無法根據回傳值型態的不同而區別，以下是重複宣告錯誤：
    - void method(int i) 
    - int method(int i) ==//重複宣告==
    - String method(int i) ==//重複宣告==
3. JAVA會盡可能選取適合的負載方法
```java=
public class Calculator {
	
    public void testCalculator(){
        sum(3, 5); // Call method-1
        sum(3.3f, 1.8f) // Call method-2
        sum(3, 3.0f); // Call method-2
    }
    
    public int sum(int x, int y){
        System.out.println("method-1");
        return x + y;
    }
	  
    public float sum(float x, float y) {
        System.out.println("method-2");
        return x + y;
    }
	  
    // public float sum(int x, float y) {
    // 	System.out.println("method-3");
    // 	return x + y;
    // }
}
```
## 物件(Object)
- 一個物件透過某類別(Class)產生的實體(Instance)。
- OOP使用訊息傳遞(Message Passing)機制
1. Class: 類別
    1. attribute(屬性): variables(變數)
    2. behavior(行為): methods(方法)
```java=
public class Pen {
	//實體變數(成員變數，屬性變數)，需透過物件參考變數進行操作
	String brand; // 初始值為null
	double price; // 初始值為0
	//方法成員，需透過物件參考變數進行呼叫
	public void showInfo() {
		System.out.println("牌子為：" + brand);
		System.out.println("價格為：" + price);
	}
}
public static void main (String[] args) {
    Pen myPen = new Pen();
    myPen.brand = "SKB";
    myPen.price = 30;
    myPen.showInfo();
}
```
2. 傳值傳址:
Java只有傳值呼叫(Call by value)
![](https://i.imgur.com/9jBXRfh.png)
![](https://i.imgur.com/7MVH6p2.png)
```java=
public class CallByValue {
    public static void main(String[] args) {
        Customer c1 = new Customer("Justin");
        some(c1);
        System.out.println(c1.name); // 輸出John
        
        Customer c2 = new Customer("Justin");
        other(c2);
        System.out.println(c2.name); // 輸出Justin, other裡面的Bill不會輸出
    }

    static void some(Customer c) {
        c.name = "John";
    }
    
    static void other(Customer c) {
        c = new Customer("Bill"); 
    }
}

class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
```
### 封裝
Java資料封裝的基本就是==類別==
### 存取修飾子
1. 取用級別

|          | the same class | same package | subclass(子類別) | universe(所有類別) |
| -------- | -------- | -------- | -------- | -------- |
| public   | V     | V     | V     | V     |
| protectd | V     | V     | V     |       |
| defualt  | V     | V     |       |       |
| private  | V     |      |       |       |

2. 可用場合

|          | 類別 | 實體變數 | 方法 | 建構子 |
| -------- | -------- | -------- | -------- | -------- |
| public   | V     | V     | V     | V     |
| protectd |       | V     | V     | V     |
| defualt  | V     | V     | V     | V     |
| private  |       | V     | V     | V     |

==區域變數不能使用存取修飾子==

3. 建議實體變數(instance variable)設定為private權限，再透過方法來存取資料: getter, setter方法

### 建構子(Constructor)
1. 建構子的名稱需要和類別相同
2. 使用new呼叫建構子產生物件，並==初始化實體變數==
3. 多載(Overloading): 一個類別可以有多個建構子
4. 沒有回傳型別
5. Java會自動給一個不帶參數的建構子，若有宣告其他建構子，JAVA會刪除預設。
```java=
public class_name() {
    //1. 保留給無參數的建構子
    //2. 給日後搭配的工具／框架使用，他們會利用此建構子幫我們產生物件
}
```
#### this關鍵字
- 用來代表執行時的當前物件
- 若沒有使用this關鍵字，實體變數與區域變數名稱相同時，方法內的變數都採用區域變數。
#### 建構子覆載(Overloading)
* 藉由 this 關鍵字呼叫同類別底下的另一個建構子
1. 對類別的使用者來說：建立物件的彈性更好，選項變多了。
2. 對類別設計者來說：對物件的預設初始資料定義的彈性也變好了。
```java=
private String brand;
private double price;

public PenConstOverload(String brand, double price) {
    this.brand = brand;
    this.price = price;
}

public PenConstOverload(double price) {
    this("SKB", price);
}

public PenConstOverload(String brand) {
    this(brand, 10);
}

public PenConstOverload() {
    this("SKB", 10);
}
```
#### static 關鍵字
1. 實體變數和方法若是宣告為 static，則此變數和方法即成為類別變數(或稱靜態變數)和類別方法(或稱靜態方法)
2. 屬於此類別的所有物件共同擁有, 記憶體空間為global。
3. ==經由類別的名稱來呼叫==
##### static機制
1. 載入JVM時，在任何實體被建構之前，靜態的變數與方法就會先被載入
2. 不可被覆寫(override)為非static方法
3. 宣告為靜態static方法，==不可以==存取該類別中non-static的變數和方法，==只可以==存取該類別中static 的變數和方法
4. 宣告為non-static的方法，==可以==存取該類別中non-static的變數和方法，也==可以==存取該類別中static 的變數和方法
5. 可用==出現在記憶體裡的先後關係==來理解這兩點。
6. static 區塊: static程式區塊裡的程式在載入類別時 會先執行一次
```java=
static {
    ...
    statement...
    ...
}
```
#### final關鍵字
1. 類別宣告為final，該類別不能再被繼承。
2. 方法宣告為final，該方法不能被覆寫。
3. 變數宣告為final，成為常數(Constant)。
4. 物件參考宣告為final，變數初始化後，不得在指向另一個物件(固定門牌)。
#### final, finally, finalize比較
#### 使用Static方法
1. 只要該方法沒有直接存取同類別的實體變數或一般方法的呼叫，宣告為static方法是可以的。
2. 常數很適合宣告為static: public static final double PI = 3.14;

### 繼承
* 提高程式的重複使用性
    * 為了維護容易，不支援多重繼承，採用替代方案
    * 建構子(Constructor)無法繼承，因為建構子的命名要和所屬類別同名。
    * java.lang.Object為所有類別的父類別。
* 父類別(superclass)
    - 具有共同成員的類別
    - 一般化
* 子類別(subclass)
    - 繼承自父類別的類別
    - 特別化
```java=
class SubClassName extends SuperClassName
```
* 當Ｂ繼承自A，以B ==is a== A表示

#### 方法改寫(Overriding)
1. 規則：子類別宣告覆寫方法時，==方法名稱，參數個數，參數型別，回傳值== 皆需要與父類別被覆寫的方法相同
2. 限制：
    - 存取修飾子的等級不可小於被覆寫的方法(可以更寬鬆)
    - 覆寫throw方法時，不可比父類別的Exception還要高階。
    - Final關鍵字：Final宣告的方法，不能被覆寫。
    - Static: Static 方法不探討override因為override是對物件設計的操作，但static的項目並非是物件的內容。
#### super關鍵字
* 子類別透過 super. 可以呼叫==上一層==類別的方法
* 無法越級呼叫
1. 方法
拿掉super關鍵字就成為呼叫自己的遞迴。
```java=
public void function() {
    super.function();
}
```
2. 建構子
    - 若有super(...)，一定要放在第一個敘述位置
    - 若沒有super(...)，Java會預設super()
    - super()和this()都只能放在第一個敘述，二擇一。

#### @Override 
* 讓編譯器對此方法以override的規則檢查，讓我們的程式撰寫更為安全。

### 多型(Polymorphism)
1. 多型是利用繼承關係使父類別(superclass)可以當成子類別(subclass)的通用型態
2. 只要符合類別間的繼承關係，在宣告參考變數時，子類別(位階低)物件實體可以升級成父類別(位階高)
3. 實現資料操作的一致性，用共同父類別代表各種子類別物件方便聚合後續處理
4. instanceof運算子：判斷父類別參考變數指向何種子類別的物件實體
5. 動態繫節(dynamic binding)：編譯器其實不曉得呼叫的方法是哪個，而是需要等到執行時期，物件產生後才能得知。
6. Object就是最基本的多型。

### 抽象(abstract)機制與目的
1. 抽象方法沒有方法主體，且必須加上abstract修飾子
```java=
public abstract void myMethod();
```
2. 抽象類別不一定要有抽象方法，==但==有抽象方法的類別一定要用抽象關鍵字宣告。
```java=
public abstract class MyClass(){...}
```
3. 抽象類別無法產生實體，只能透過繼承建立子類別，該子類別要產生實體要實作所有抽象方法。
4. static 方法在抽象類別實作後仍可以執行

### 介面(Interface)
```java=
{public/default} interface interface_name {
    // public static final constant
    int num1 = 100;
    // public abstract method
    void methods();
}
class subclass extends superclass implements interface1, interface2,...{}
class className implements interface1, interface2, ...{}
```
#### 避免濫用繼承
1. 資料關係與現實生活邏輯不相符
2. 資類別得到錯誤或是不必要的項目
#### 預先定義規格
1. 所有方法皆為抽象方法的抽象類別
2. 介面之間可以再繼承(extends)
3. 宣告方法: 公開抽象方法(public abstract)
4. 宣告資料: 公開靜態常數(public static final)
- 五大特性：
    1. 多重繼承
    2. 定義規格
    3. 貼標籤(空介面): 讓Java做行前確認的動作
    4. 型別轉換
    5. 降低相依性

## PACKAGE設定
javac -d . -cp .:/path/* HelloWorld.java
java -cp .:/path/* package_name.HelloWorld

sudo vi ~/.bash_profile //Mac的環境變數
at bash_profile
export CLASSPATH=${CLASSPATH}:.:/path/*

javac -d . HelloWorld.java
java package_name.HelloWorld

## Object 方法

library path: /Library/Java/JavaVirtualMachines/jdk-18.jdk/Contents/Home/lib/src.zip
```java=
	public boolean equals(Object obj) {
		// 仍要使用==來判斷，因為(也許)要比較的"物件參考變數"，其實指的是同一個實體(指向同一個記憶體空間)
		if (this == obj)
			return true;
		// 用(Object類別的)getClass()來確定是否隸屬於同一個class的物件
		if (obj != null && getClass() == obj.getClass()) {
			if (obj instanceof Employee) { // 為了讓所有物件都能傳入進來，型別先晉升為Object，使用時再轉回Employee型別才能存取empno/ename
				Employee e = (Employee) obj;
				// 選擇該類別的必要成員變數(實體變數)來加以判斷是否有相等(相同)
				if (empno == e.empno && ename.equals(e.ename)) {
					return true;
				}
			}
		}
		return false;
	}
```

1. clone
```java=
native: JVM使用C對記憶體操作
implements cloneable
```

## Integer
```java=
Integer i1 = new Integer(10);
Integer i2 = new Integer(10);
System.out.println(i1 == i2); // false
System.out.println(i1.equals(i2)); // true

Integer i3 = Integer.valueOf(10);
Integer i4 = Integer.valueOf(10);
System.out.println(i3 == i4); // true, 指向同一個物件位址

String s1 = "100";
System.out.println(s1 + 100); //100100
int i5 = Integer.parseInt(s1);//將字串轉為int, 注意內容要為數字
System.out.println(i5 + 100); // 200

/*

 說明:
 int 包裝成 Integer 稱之為 Autoboxing，反之則是 Auto-unboxing。

 在 Java 中的八種基本型別，分別是 byte, short, int, long, 
 float, double, char 和 boolean。
 理論上來說，真正的物件導向中的型別應該都必須是類別定義，
 像是 Short, Integer 等等類別。
 不過為了我們使用上的方便，Java 提供了基本型別。
 同時存在這兩種型別常常會造成我們在設計上要加上許多額外的程式碼，
 例如在做數字運算時，使用 int 或 double 型別來處理，
 但是要將數字存入容器時，必須要將其轉換成 Integer 或 Double 型別，
 才能使用 add(new Integer(i))，
 在使用容器或多型處理時常常要多一道轉型手續。 
 Java 1.5 中，已經增加了這方面的處理，
 稱之為 Autoboxing 和 Auto-unboxing，
 編譯器會自動幫我們在 int 和 Integer 之中轉換。 
 */

public class TestAutoboxing {

	public static void main(String[] args) {
		Integer i1 = 1; // boxing
		int i2 = i1; // unboxing

		int sum1 = i1 + i2; // 把i1拆箱，取值和i2做運算
		Integer sum2 = i1 + i2; // 把i1拆箱，取值和i2做運算再把結果裝箱指定給sum2
		System.out.println(sum1);
		System.out.println(sum2);
	}
}

```

###### tags: `JAVA` `Tibame`