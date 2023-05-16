package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 소켓(socket)은 프로세스 간 통신에 사용되는 양쪽 끝 단을 의미한다.
 * 쉽게 말해서 프로그램은 다른컴퓨터에 있는 프로그램과 통신하기 위해 바로 이 소켓을 이용하는데,
 * 프로그램이 통신하기 위해 소프트웨어로 작성된 통신의 접속점이라고 할 수 있다. 
 */
public class ServerSocketTest {
	
	
	public static void main(String[] args) {
			
			try {
				
				// 서버소켓은 클라이언트로부터 연결요청이 오기를 기다렸다가 연결 요청이 오면 클라이언트와 연결을 맺고 다른 소켓을 만드는 일을 한다.
				ServerSocket serverSocket = new ServerSocket(9500); // 포트번호를 9500번으로 지정
				
				// while문으로 돌려주어야지 계속 접속을 받을수 있다.
				while (true) {
					System.out.println("연결을 기다리는 중...");
					
					/* 클라이언트로부터 연결요청이 오면 연결을 맺고 클라이언트 소켓을 생성해 리턴한다.
					accept()메소드는 클라이언트가 연결 요청하기 전까지 블로킹 되는데, 블로킹이란 스레드가 대기상태가 된다는 뜻이다. */ 
					Socket socket = serverSocket.accept();
					
					InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
					
					System.out.println("연결 수락됨 : " + isa.getHostName());
					
					// 소켓 -> 서버
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// 데이터를 읽어옴
					String line = reader.readLine(); 
					System.out.println("넘어온 데이터 :" + line);
					
					// 서버 -> 소켓
					PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); // 소켓으로 데이터를 바깥으로 보냄

					writer.println(line);
					writer.flush();
				}
				
			} catch (IOException e) {
				System.out.println("1");
			}
	
	}
}
