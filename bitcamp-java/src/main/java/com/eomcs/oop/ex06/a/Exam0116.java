// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0116 {

  public static void main(String[] args) {
    Car c = new Car();

    c.model = "티코";  // Vehicle의 인스턴스 변수
    c.capacity = 5;    // Vehicle의 인스턴스 변수
    c.cc = 890;        // Car의 인스턴스 변수
    c.valve = 16;      // Car의 인스턴스 변수
    
    Sedan s = (Sedan)c; // 실행할 때 오류 발생 - java.lang.ClassCastException
    s.sunroof = true;
    s.auto = true;
  }
}
