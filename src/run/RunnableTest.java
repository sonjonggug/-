package run;

import java.util.ArrayList;

/**
 * 보통 쓰레드 객체를 만들 때 위의 예처럼 Thread 클래스를 상속하여 만들기도 하지만
 * 보통은 Runnable 인터페이스를 구현하도록 하는 방법을 주로 사용한다.
 * 왜냐하면 Thread 클래스를 상속하면 다른 클래스를 상속할 수 없기 때문이다.
 * @author user
 *
 */
public class RunnableTest implements Runnable{ // Thread를 extends 하던 것에서 Runnable을 implements 하도록 변경되었다.
	
	int seq;
    
	
	public RunnableTest() {
        
    }
	
    public RunnableTest(int seq) {
        this.seq = seq;
    }
    
    
    /**
     * 쓰레드는 순서에 상관없이 동시에 실행된다. ( 그래서 0~9번 순차적이 아닌 뒤죽박죽 )
     * 더욱 재밌는 사실은 쓰레드가 종료되기 전에 main 메서드가 종료되었다는 사실이다.
     */
    public void run() { // 스레드 실행 메서드
        System.out.println(this.seq + " thread start.");  // 쓰레드 시작
        try {
            Thread.sleep(1000);  // 1초 대기한다.
    	} catch (Exception e) {
    		System.out.println(this.seq + " thread error.");  // 쓰레드 에러
        }
        	System.out.println(this.seq + " thread end.");  // 쓰레드 종료 
    }
	   		
	
    /**
     *  쓰레드가 종료되기 전에 main 메서드가 종료된다.
     */
	public void RunnableTest1() {
		
		 for (int i = 0; i < 10; i++) {  // 총 10개의 쓰레드를 생성하여 실행한다.			 
			 Thread t = new Thread(new RunnableTest(i)); 
	            t.start();
	        }	        
	    }
	
	
	 /**
	   * main 메서드가 종료되기 전에 threads에 담긴 각각의 thread에 join 메서드를 호출하여 쓰레드가 종료될 때까지 대기한다.
	   * 쓰레드 프로그래밍시 가장 많이 실수하는 부분이 바로 쓰레드가 종료되지 않았는데 쓰레드가 종료된 줄 알고 그 다음 로직을 수행하게 만드는 일이다.
	   * 쓰레드가 종료된 후 그 다음 로직을 수행해야 할 때 꼭 필요한 join 메서드를 꼭 기억하자.
	   */
	public void RunnableTest2() {
		
		ArrayList<Thread> threads = new ArrayList<>(); // 생성된 쓰레드를 담기 위해서 ArrayList 객체인 threads를 만든 후 쓰레드 생성시 생성된 객체를 threads에 저장
		
		  for (int i = 0; i < 10; i++) {  // 총 10개의 쓰레드를 생성하여 실행한다.			  
			  Thread thread = new Thread(new RunnableTest(i)); 
			  thread.start();
			  threads.add(thread);
	        }
		  		 
		  for(int i=0; i < threads.size(); i++) {
	            Thread t = threads.get(i);
	            try {
	                t.join(); // 쓰레드의 join 메서드는 쓰레드가 종료될 때까지 기다리게 하는 메서드
	            }catch(Exception e) {
	            }
	        }
		  
	        System.out.println("main end.");  // main 메서드 종료
		}	
}
