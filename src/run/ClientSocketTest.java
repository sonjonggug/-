package run;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버 소켓은 말그대로 서버프로그램에서만 사용되는 소켓이다. 
 * 서버소켓은 클라이언트로부터 연결요청이 오기를 기다렸다가 연결 요청이 오면 클라이언트와 연결을 맺고 다른 소켓을 만드는 일을 한다. 
 */
public class ClientSocketTest {
	
	
		public static void main(String[] args) {
				
			try {
				Socket socket = new Socket("localhost", 9500);
				System.out.println("연결성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
}
