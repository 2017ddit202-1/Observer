package com.ddit.handler;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ddit.dto.MessageVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.AuthorityServiceImpl;
import com.google.gson.Gson;



public class AutorityHandler extends TextWebSocketHandler{
	
	@Autowired
	private AuthorityServiceImpl authorityService;
	
	@Autowired
	private AlertServiceImpl alertService;
	
	
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	public Map<String, WebSocketSession> getUsers() {
		return users;
	}

	@Override  //접속관련이벤트 메소드, WebSocketSession접속한 사용자
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {

		super.afterConnectionEstablished(session);
		log(session.getId() + " 연결 됨");

		Map<String, Object> map = session.getAttributes();  //세션값이 Map형태->attributes.put("loginUser", loginUser): 세션값은 object
		String id = (String) map.get("loginUser");

		users.put(id, session); //웹소켓 세션으로 저장
	}

	
	
	  /*클라이언트가 서버와 연결 종료
    WebSocketSession 연결을 끊은 클라이언트
    CloseStatus 연결 상태 (확인필요)*/
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료됨");
		
		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("userId");
		
		//users.remove(id);
	}

	
	
	
	/*	2가지이벤트처리
	** Send-> 클라이언트가 서버에게 메세지 보냄
	** Emit-> 서버에 연결되어 있는 클라이언트에게 메시지 보냄
	WebSocketSession 메시지를 보낸 클라이언트
	TextMessage 메세지의 내용*/
	
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		System.out.println(message+"&&&&&&&&&&&&&&&&&&&&");
		
		MessageVO messageVO = MessageVO.converMessage(message.getPayload());
		String id = messageVO.getId();
		
		
		Map<String, Object> map = session.getAttributes(); // <키,오브젝트>
		if(id==map.get("loginUer")){
			System.out.println(map.get("loginUser")+")))))))))))))))))))))))");
		}else{
			System.out.println("없습니당다아다다아아아!!!!~~~");
		}
		
/*		String[] chkbox =  (String[]) map.get("chkbox"); //체크 스트링 배열
		
		
		for(int i=0; i<chkbox.length; i++){
			if(chkbox[i]==map.get("loginUser")){
				System.out.println("있다있다있어!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			
			}
		}
		*/
		
		
		
		
		log(session.getId() + "로부터 메시지 수신: " + message.getPayload());
		String fromUser = "";
		for(String commUser : users.keySet()) {
			if(users.get(commUser).equals(session)) {
				fromUser = commUser;
			}
		}
		
		/*MessageVO messageVO = MessageVO.converMessage(message.getPayload());
		String user = messageVO.getTo();
		System.err.println(users.get(user));
		users.get(user).sendMessage(
				new TextMessage("회원 " +fromUser +"가 회원님이 작성하신 게시물에 댓글을 작성했습니다."
						+ "\n" + messageVO.getMessage()));*/

	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		log(session.getId() + " 익셉션 발생: " + exception.getMessage());
	}

	private void log(String logmsg) {
		System.out.println(new Date() + " : " + logmsg);
	}

}
