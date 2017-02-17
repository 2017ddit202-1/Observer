package com.ddit.handler;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ddit.dto.MessageVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.AuthorityServiceImpl;



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

		//Map<String, Object> attributes
		super.afterConnectionEstablished(session);
		log(session.getId() + " 연결 됨");

		Map<String, Object> map = session.getAttributes();  //세션값이 Map형태->attributes.put("loginUser", 아이디값): 세션값은 object
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
		
		MessageVO messageVO = MessageVO.converMessage(message.getPayload()); //json형태의 데이터를 String으로 변환하는 메소드
		String id = messageVO.getId();
		
		
		Map<String, Object> map = session.getAttributes(); // <키,오브젝트>
		System.out.println("맵맵맵: "+map.toString());
		if(users.get(id) != null){
			//아이디값을 가지고 권한을 가져오고 if 아이디가 user-> admin으로 변경
			
			String authority = authorityService.authoritySelect1(id); //아이디값의 권한을 가져옴
			if(authority.equals("ROLE_USER")){
				
			}
			
			
			users.get(id).sendMessage(
					new TextMessage("회원 가 회원님이 작성하신 게시물에 댓글을 작성했습니다."));
			System.out.println(map.get("loginUser")+")))))))))))))))))))))))");
		}else{
			System.out.println("없습니당다아다다아아아!!!!~~~");
		}
				
		
		
		log(session.getId() + "로부터 메시지 수신: " + message.getPayload());
		String fromUser = "";
		for(String commUser : users.keySet()) {
			if(users.get(commUser).equals(session)) {
				fromUser = commUser;
			}
		}
	

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
