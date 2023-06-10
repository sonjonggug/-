package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 서버 소켓은 말그대로 서버프로그램에서만 사용되는 소켓이다. 
 * 서버소켓은 클라이언트로부터 연결요청이 오기를 기다렸다가 연결 요청이 오면 클라이언트와 연결을 맺고 다른 소켓을 만드는 일을 한다. 
 */
public class ClientSocketTest {
	
	
		public static void main(String[] args) throws IOException {
				
			Socket socket = null;
			
			try {
				socket = new Socket("localhost", 9500);
				System.out.println("연결성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
				//클라이언트 -> 소켓
				String msg= "안녕하세요!";
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); // outputStream ( 출력 , 쓰기 )
				writer.println(msg);  //서버로 데이터를 전송한다. 
				writer.flush();   //버퍼 안에 있는 값들을 전부 비워준다. 
				System.out.println("데이터 전송 완료!");
				
				//소켓 -> 클라이언트
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // inputStream ( 입력 , 읽기 )
				String line = reader.readLine();
				System.out.println("데이터 받기 성공! :"+line);  //서버와 통신이 완료되어 "안녕하세요"라는 값을 가지고 온다.
				
				writer.close();
				reader.close();
						
		}
}
