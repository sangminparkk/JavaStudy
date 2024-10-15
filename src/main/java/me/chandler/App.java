package me.chandler;

import me.chandler.ch7.Time;
import me.chandler.ch7._interface.A;
import me.chandler.ch7._interface.B;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Time time = new Time(12, 35, 50);
//        time.hour // 같은 클래스가 아님으로 필드 직접 접근을 할 수가 없음 >> 그래서 메서드로 접근을 하는구나
        System.out.println(time.getHour());

        time.setHour(time.getHour() + 1);
        System.out.println(time.getHour());

        A a = new A();
        a.methodA(new B());
        a.methodC();

        System.out.println("메인");
        a.methodD();
    }
}
