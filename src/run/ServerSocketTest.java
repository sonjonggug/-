package run;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버 소켓은 말그대로 서버프로그램에서만 사용되는 소켓이다. 
 * 서버소켓은 클라이언트로부터 연결요청이 오기를 기다렸다가 연결 요청이 오면 클라이언트와 연결을 맺고 다른 소켓을 만드는 일을 한다. 
 */
public class ServerSocketTest {
	
	
	public static void main(String[] args) {
			
			try {
				
				ServerSocket serverSocket = new ServerSocket(9500); // 포트번호를 9500번으로 지정
										
				while (true) {
					System.out.println("연결을 기다리는 중...");
					
					/*클라이언트로부터 연결요청이 오면 연결을 맺고 클라이언트 소켓을 생성해 리턴한다.
					accept()메소드는 클라이언트가 연결 요청하기 전까지 블로킹 되는데, 블로킹이란 스레드가 대기상태가 된다는 뜻이다. */ 
					Socket socket = serverSocket.accept();
					
					InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
					
					System.out.println("연결 수락됨" + isa.getHostName());
				}
				
			} catch (IOException e) {
				System.out.println("1");
			}
	
	}
}
