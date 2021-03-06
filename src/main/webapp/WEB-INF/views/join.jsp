<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<%=request.getContextPath()%>/resources/css/join.css"rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/join.js"></script>

<article>
   <br> <br>
   <div id="contract">
      <h2><img id="joinLogo" src = "<%=request.getContextPath()%>/resources/img/observer1.png" style="width:7%;float:left">&nbsp;OBSERVER</h2>
      <h3 style="margin-left: -13.9%; color: #707070">간편한 회원가입을 통해 모니터링 하세요</h3><br>
   </div>

   <form class="form-horizontal" id="formm" name="formm" method="post">
         <!-- Text input-->
         <div class="form-group">
            <div class="col-md-1">
               <label class="col-md-4 control-label" for="id">ID</label>
               <span id="idCheck" class="col-md-4 control-label" style="color: #ff6459"></span>
               <input id="fn" type="text" name="mem_id" class="form-control input-md" onkeyup="checkDepulicateId()">
               <!-- <span id="idCheck"></span> -->
            </div>
               <!-- <button class="btn btn-primary" onclick="idcheck()" id="check">중복 체크</button><br/> -->
         </div>
         <br>

         <div class="form-group">
            <div class="col-md-1">
               <label class="col-md-4 control-label" for="id">Name</label>
               <span id="nameCheck" class="col-md-4 control-label" style="color: #ff6459"></span>
               <input id="id_mem" type="text" name="mem_nm" 
                  class="form-control input-md" onkeyup="nameCheck()" style="border-radius:5px;"><br/>
            </div>
         </div>
         <!-- Text input-->
         <div class="form-group">
            <div class="col-md-2">
               <label class="col-md-4 control-label" for="id">Password</label>
               <input id="pwd_mem" name="mem_pwd" type="password"
                   class="form-control input-md" onkeyup="pwdCheck()" style="border-radius:5px;"><br/>

            </div>
         </div>
         
            <div class="form-group">
            <div class="col-md-2">
               <label class="col-md-4 control-label" for="id">Password 확인</label>
               <input id="fn" type="password" name="mem_pwd2"
                   class="form-control input-md"><br/>

            </div>
         </div>

         <!-- Text input-->
         <div class="form-group">
            <div class="col-md-2">
               <label class="col-md-4 control-label" for="id">E-Mail</label>
               <input id="fn" type="text" name="mem_email"
                  class="form-control input-md"><br/>

            </div>
         </div>
         
         <div class="form-group">
            <div class="col-md-2">
               <label class="col-md-4 control-label" for="id">Phone</label>
               <input id="fn" type="text" name="mem_phone"
                  class="form-control input-md"><br/>

            </div>
         </div>
      <div>
      
         <input type="checkbox" name="check1" value="동의">이용약관에
         동의합니다.(필수)
         <!-- Trigger the modal with a button -->
         <a href="#" data-toggle="modal" data-target="#myModal1">[ 이용약관보기 ]</a>

         <!-- Modal -->
         <div class="modal fade" id="myModal1" role="dialog">
            <div class="modal-dialog">

               <!-- Modal content-->
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal">&times;</button>
                     <h4 class="modal-title">이용약관 [필수]</h4>
                  </div>
                  <div class="modal-body">
                  
                  <textarea name="textarea" style="width: 520px; height: 300px;">이용약관 제 1 장 총칙 제1조 (목적) 본 약관은 ㈜와탭랩스(이하 “갑”이라 합니다)이 제공하는 각종 서비스에 대한 고객(이하 “을”이라 합니다) 간의 이용조건 및 절차에 관한 제반사항의 규정을 목적으로 합니다.
                  제2조 (약관의 효력 및 개정) 1. 본 약관은 전기통신사업법 규정에 의하여 제정한 것이며, 공시 함으로서 효력을 발생합니다. 본 약관의 공시는 “갑”의 홈페이지를 통해 공시됩니다. (홈페이지 : http://www.whatap.io) 2. 본 약관은 “갑”의 서비스를 “을”이 이용 신청한 시점부터 서비스가
                        종료된 후 이용 요금 정산이 완료된 시점까지 효력을 가집니다. 3. "갑”은 합리적인 사유가 발생할 경우 본 약관을
                        변경할 수 있으며, 약관이 변경된 경우에는 이를 즉시 공시합니다. 단, 요금 등 고객의 권리 또는 의무에 관련된
                        중요사항의 변경은 공시 후 7일이 경과한 후에 그 효력이 있습니다. 제3조 (약관의 적용) 본 약관에 명시되지
                        아니한 사항에 대해서는 관계 법령, 본 약관의 취지 및 동종업계의 관행에 따라 해석 적용됩니다. 제 2 장 계약의
                        체결 제4조 (계약의 성립) 서비스의 이용 계약은 “갑”의 서비스에 대한 이용약관에 대한 “을”의 동의 및 이용
                        신청과 “갑”의 이용 승낙에 의하여 성립됩니다. 1. 계약기간은 홈페이지에 게시된 상품 중 고객이 선택한 상품의
                        서비스 개시일로부터 선택한 기간에 따라 서비스를 받을 수 있습니다. 2. 서비스 개시일은 “을”이 서비스 이용을
                        시작한 날짜로 합니다. 단, 유료서비스는 무료에서 유료서비스로 변경한 날짜로 합니다. 3. 서비스 신청은 “갑”의
                        홈페이지에서 온라인으로 신청합니다. 제5조 (이용 신청의 승낙) 1. "갑"은 "을"에 대하여 업무상 또는 기술상
                        특별한 사유가 없는 한 접수 순서에 따라 서비스 이용을 승낙합니다. 2. "갑"은 "을"의 서비스 이용 신청을
                        승낙한 때에는 다음 각 호의 사항을 “을”에게 mail, 서면 또는 유선 등의 방법으로 통보합니다. ① 서비스
                        시작일 ② 요금 등에 관한 사항 ③ 고객의 권익보호 및 의무 등에 관한 사항 ④ 기타 "갑"이 필요하다고 인정하는
                        사항 3. "갑" 이 "을" 또는 기존 서비스를 이용 중인 "을"의 신규 계약 및 재 계약에 대해 승낙하지 아니할
                        경우 계약은 성립되지 아니합니다. 4. "갑"은 다음 각 호에 해당하는 경우에 "을"의 서비스 신청 및 재 계약에
                        대하여 이를 승낙하지 아니할 수 있습니다. 이 경우에는 그 사유를 "을"에게 즉시 통보합니다. ① 타인의 명의를
                        사용하여 서비스 이용을 신청하였을 때 ② 신청서의 내용을 허위로 기재하였거나 허위의 서류를 첨부하여 신청하였을 때

                        ③ 기타 “을”의 귀책사유로 승낙이 곤란한 경우와 "갑"의 서비스 제공에 지장을 초래하였거나, 초래할 가능성이 있는
                        "을"의 신규 계약의 경우 제 3 장 계약의 변경 및 해지 제6조 (계약 내용의 변경) 1. "을"이 서비스 이용에
                        관한 내용 중 다음 각 호에 해당하는 사항이 변경된 경우에는 "갑"의 홈페이지를 통해 온라인 이용 변경을 하여야
                        합니다. (http://www.whatap.io) ① "을"의 상호, 성명, 주소 또는 연락처의 변경 ② 서비스
                        내용의 변경 ③ 요금납부방식 및 결제계좌번호 변경 2. 제1항 제2호에 의하여 서비스 내용이 변경된 경우에는 새로운
                        서비스 이용 신청에 의한 요금이 적용됩니다. 제7조 (계약의 갱신) 서비스 이용 기간은 매월 서비스 이용 시작일부터
                        매월 말일까지로 합니다. 서비스 이용 기간 내에 “갑”과 “을” 상호간에 별도의 의사표시가 없을 경우 이전의 계약
                        내용과 동일한 조건으로 1개월씩 자동 연장됩니다. 제8조 (양도) 1. “갑”과 “을”은 사전 승인 없이는 계약상의
                        권리와 의무를 제3자에게 양도할 수 없습니다. 2. “을”의 지위 승계 및 양도를 원할 경우 기존의 미납된 서비스
                        이용 요금 납입이 되어야 승계가 가능합니다. “을”의 지위의 승계는 사명의 변경, 대표자의 변경, 요금납입책임자의
                        변경(서비스 이용고객과 요금납입책임자가 다른 경우)등 고객의 동일성을 판단할 수 있는 주요 사항이 변경된 경우를
                        말합니다 3. 합병, 분할, 영업양수 등으로 “을”의 지위 승계 사유가 발생한 경우에는 그 사유 발생일로부터 30일
                        이내에 사업자등록증사본(법인에 한함)과 지위 승계를 입증할 수 있는 관련 서류를 첨부하여 “갑”에게 통보하여야
                        합니다 제9조 (계약의 해지) 1. 서비스 이용 계약을 해지한 경우에는 해당 월 서비스 시작일로부터 사용일까지 월
                        이용요금을 일할 계산하여 청구합니다. 2. “갑”이나 “을” 중 어느 일방이 파산신청, 압류, 가압류, 부도,
                        경매, 회사정리 등의 사유에 해당하는 경우에는 즉시 계약을 해지 할 수 있습니다. 3. “을”이 서비스 해지를 원할
                        경우 “갑”은 해지 신청서를 접수한 후 정산절차를 거쳐 “을”의 요청일 까지 해지를 완료합니다. 단, 미납요금
                        정산이 완료되지 않을 경우 해지를 할 수 없습니다. 4. “갑”은 “을”의 서비스 이용 내용이 본 약관에 따른
                        서비스 이용의 제한사항에 해당하는 경우, 고객이 일정기간(5일) 내에 그 원인된 사유를 해소하지 않거나, 정당한
                        사유 없이 회사의 의견 진술 요청에 응하지 않는 경우 직권에 의하여 계약을 해지할 수 있습니다. 5. "갑"은
                        서비스 제공에 있어 "을"이 영업적 손실을 입혔을 경우와 서비스 제공에 합당하지 아니하다고 판단하였을 경우 그
                        사유를 서면 통보 후 해지할 수 있습니다. 6. 계약 해지가 완료되면 “갑”은 “을”의 서버 모니터링 데이터를 즉시
                        삭제합니다. 7. "을"이 청구일을 기준으로 30일 내에 사용료를 정산하지 않은 경우 “갑”은 “을”의 서버
                        모니터링 데이터를 삭제합니다. 8. 전자상거래법 17조에 의하여 단순변심 착오구매로 인한 철회는 상품신청 30일이
                        경과한 경우에는 청약철회가 불가능합니다. 단, 이용 상의 중대한 오류가 있는 경우 전자상거래법 및
                        소비자분쟁해결기준(공정거래위원회 고시)에 따라 처리됩니다. 제10조 (이용자격의 박탈) 다음의 경우에 “을”이
                        해당되는 경우 “갑”은 “을”의 서비스를 정지 할 수 있습니다. 1. 미풍양속에 어긋난 정보를 제공한 경우 2.
                        소프트웨어 보호법에 저촉된 행위를 한 경우 3. 법률에 반하는 행위를 한 경우 4. "을"이 가입 신청 시 허위로
                        계약 신청을 하였을 경우 5. "을"이 "갑"의 서비스를 이용하며 "갑"의 다른 서비스 이용자들에게 피해를 입힌
                        경우 6. "을"이 "갑"의 영업 및 관리 상의 손실을 발생하였거나, 또는 발생할 가능성이 있을 경우 7. 타인의
                        회원정보 및 비밀번호를 도용한 경우 8. 부정한 상거래 행위로 서비스 이용을 제한 당한 이용자가 재등록을 신청한
                        경우 제 4 장 서비스 종류 및 요금 제11조 (이용요금) 서비스 이용요금의 세부 내역은 “갑”의 홈페이지에
                        명기합니다. (http://www.whatap.io) 제12조 (이용요금 변경) ① 이용요금 변경이란 요금이 인상
                        또는 인하되는 것을 말하며, "갑"이 "을”에게 통지한 달의 다음달부터 변경된 이용요금을 적용합니다. 단,
                        계약기간이 사전에 정해진 경우나 선납의 경우, 요금인하를 제외하고는 해당계약 기간이 종료할 때까지 요금을 변경할 수
                        없습니다. ② “갑”은 ①의 이용요금 변경 사유를 홈페이지에 게시하여야 합니다. 제13조 (손해배상) ① “갑”의
                        과실로 3일 이상 서비스를 제공하지 못한 경우 “을”의 최근 1개월 이용 요금의 일 평균 금액에 이용불가 일수를
                        곱한 금액을 기준으로 요금을 할인하여 제공합니다. ② “을”의 손해배상 청구권은 그 사유가 발생한 날로부터 1개월이
                        경과한 후에 소멸됩니다. 제14조 (면책) ① “갑”은 “을”이 “갑”의 서비스를 이용하여 행한 모든 행위의 결과에
                        따른 손해 및 불법행위에 대한 모든 민, 형사상 책임 및 배상의 책임을 지지 않으며 그 책임은 “을”에게 있습니다.

                        ② “갑”이 의무를 다했을 경우에 발생하는 피해에 대해서는 일체의 책임을 지지 않습니다. ③ 외부 침입에 의한
                        “을”의 정보자료의 유출과 훼손에 대해 “갑”은 책임이 없습니다. 제15조(약관의 효력) “을”이 서비스 이용
                        신청을 하고, “갑”이 “을”에게 사용권한을 부여하면 본 약관은 효력이 발생합니다. 제16조 (관할법원) ① 본
                        약관에 별도로 규정한 것을 제외하고는 일반 상관례 및 약관법에 따르며, 약관의 해석이나 이행에 관한 분쟁은 “갑”과
                        “을”의 합의에 의하여 해결합니다. ② ①의 합의가 성립되지 못할 때의 관할 법원은 “갑” 주소지 관할 지방
                        법원으로 합니다. ο 본 약관은 : 2015년 4월 1일부터 시행됩니다.</textarea>
                  </div>
                  <div class="modal-footer" style="text-align: center;">
                     <button type="button" class="btn btn-default"
                        data-dismiss="modal">Close</button>
                  </div>
               </div>

            </div>
         </div>

      </div>
      <input type="checkbox" name="check2" value="비동의">개인정보 보호정책에
      동의합니다.(필수)
      <!-- Trigger the modal with a button -->
      <a href="#" data-toggle="modal" data-target="#myModal">[ 개인정보 보호정책
         보기 ]</a>

      <!-- Modal -->
      <div id="myModal" class="modal fade" role="dialog">
         <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">개인정보 보호정책 [필수]</h4>
               </div>
               <div class="modal-body">
                   <textarea name="textarea" style="width: 520px; height: 300px;">개인정보 취급방침 “㈜와탭랩스”는(이하 “회사”는) 고객님의 개인정보를 중요시하며, “정보통신망 이용촉진
                     및 정보보호”에 관한 법률을 준수하고 있습니다. 회사는 개인정보 취급방침을 통하여 고객님께서 제공하시는 개인정보가
                     어떠한 용도와 방식으로 이용되고 있으며, 개인정보 보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다. 회사는
                     개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다. 본 방침은 : 2015년
                     4월 1일부터 시행됩니다. *수집하는 개인정보 항목 회사는 회원가입, 상담, 서비스 신청 등등을 위해 아래와 같은
                     개인정보를 수집하고 있습니다. - 수집항목 : 이름, 이메일 ID, 암호화 된 비밀번호, 휴대전화번호, 회사명,
                     서비스 이용기록, 결제기록 - 개인정보 수집방법 : 홈페이지(회원가입, 서비스 신청), 세미나 등 행사 응모



                     *개인정보의 수집 및 이용목적 회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다. - 서비스 제공에 관한 계약
                     이행 및 서비스 제공에 따른 요금정산 콘텐츠 제공, 구매 및 요금 결제 - 회원 관리 회원제 서비스 이용에 따른 본인
                     확인, 개인 식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 불만처리 등 민원처리, 고지사항 전달 - 마케팅
                     및 광고에 활용 이벤트 등 광고성 정보 전달, 접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계 *개인정보의 보유
                     및 이용기간 원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단,
                     관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를
                     보관합니다. - 보존 항목 : 서비스 이용기록 - 보존 근거 : 전자상거래 등에서의 소비자보호에 관한 법률 - 보존
                     기간 : 3년 - 계약 또는 청약철회 등에 관한 기록 : 5년 (전자상거래 등에서의 소비자보호에 관한 법률) -
                     대금결제 및 재화 등의 공급에 관한 기록 : 5년 (전자상거래 등에서의 소비자보호에 관한 법률) *개인정보 자동수집
                     장치의 설치, 운영 및 그 거부에 관한 사항 회사는 귀하의 정보를 수시로 저장하고 찾아내는 “쿠키(cookie)”를
                     자동 로그인 등의 목적으로 사용합니다. *개인정보의 취급위탁 회사는 다음과 같이 개인정보 취급업무를 외부 전문업체에
                     위탁하여 운영하고 있습니다. 아래 각 수탁업자는 계약기간 동안 필요한 범위 내에서 회원의 개인정보를 보유하는 것을
                     원칙으로 하며, 수탁업자에 대하여 관계법령에서 법정 보유기간을 명시하고 있는 경우는 해당 업체업체는 해당 기간 동안
                     보유합니다. - 수탁업체명 : 주식회사 케이지이니시스 - 위탁업무 : 신용카드, 계좌이체 결제 대행 - 위탁기간 :
                     위탁계약 종료시까지 위탁업무계약서 내지 별도의 정보보호서약(특약) 등을 통하여 개인정보보호 관련 법규의 준수,
                     개인정보에 관한 비밀유지, 제3자 제공에 대한 금지, 사고시의 책임부담, 위탁기간, 처리 종료 후의 개인정보의 반환
                     또는 파기 의무 등을 규정하고, 이를 준수하도록 관리하고 있습니다. *개인정보의 파기절차 및 방법 회사는 원칙적으로
                     개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 파기절차 및 방법은 다음과 같습니다.

                     - 파기절차 회원님이 회원가입 등을 위해 입력하신 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의
                     서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된 후
                     파기됩니다. 별도 DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 보유 이외의 다른 목적으로 이용되지
                     않습니다. - 파기방법 전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다.


                     *개인정보에 관한 민원서비스 회사는 고객의 개인정보를 보호하고 원활한 운영을 위하여 아래와 책임자를 지정하고
                     있습니다. 개인정보관리 책임자 : 조창현 전화번호 : 070-7151-1803 이메일 :
                     support@whatap.io 귀하께서는 회사의 서비스를 이용하시며 발생하는 모든 개인정보보호 관련 민원을
                     개인정보관리 책임자에게 신고하실 수 있습니다. 회사는 이용자들의 신고사항에 대해 신속하게 충분한 답변을 드릴
                     것입니다. 기타 개인정보침해에 대한 신고나 상담이 필요하신 경우에는 아래 기관에 문의하시기 바랍니다. 1. KISA
                     개인정보보호 (http://www.1336.or.kr) 2. 정보보호마크인증제도
                     (http://www.eprivacy.or.kr) 3. 경찰청 사이버테러대응센터
                     (http://www.ctrc.go.kr)</textarea>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal" style="text-align: center;">Close</button>
               </div>
            </div>

         </div>
      </div>
      <br><br>
      <div style="margin-left:26%;">
     <button class="btn btn-primary" id="btnContactUs" onclick="go_save()">계정생성</button>
      <button class="btn btn-primary" id="btnContactUs" onclick="history.go(-1);" style="margin-left:8%">취소</button>
      </div>
   </form>
   <br><br><br><br>

</article>