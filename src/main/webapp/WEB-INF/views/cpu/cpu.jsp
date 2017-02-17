<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<style type="text/css">
#formm{
	margin-top:-14%
}
#btnZxc{
	margin-left: 85%;
}	
</style>

<script>
var cpu_pcnt = "";
var inter="";
var inter2="";
var pp = 0;

/* 새로고침 막기 */
function LockF5(){
    if (event.keyCode == 116) {
     event.keyCode = 0;
     return false;
    }
   }
   document.onkeydown = LockF5;

/* 처음 로딩 시 tt 호출 후 setInterval */
$(function(){
//    inter = setInterval("tt()",5000);
tt();
   
});

/* 1시간 버튼 클릭 시 */
var dd = 0;
function ss(){
    clearInterval(inter);
    if(dd==0){
       dd++;
       ff();
//        inter2 = setInterval("ff()",5000);
       dd = 0;
    }
}

/* 1시간 리스트*/
function ff(){
       $.ajax({
            url:"<%=request.getContextPath()%>/cpu/cpuPcntHours",
            type : "post",
            dataType : 'json',
            success : function(data) {
               FusionCharts1(data);
            }
    })
}

/* 30분 버튼 클릭 시 */
function vv(){
    clearInterval(inter2);
    if(pp==0){
       pp++;
       tt();
//        inter = setInterval("tt()",5000);
       pp = 0;
    }
}

/* 처음 리스트 */
function tt(){
   $.ajax({
      url:"<%=request.getContextPath()%>/cpu/cpuPcnt",
      type : "post",
      dataType : 'json',
      success : function(data) {
            FusionCharts1(data);
      }
   });
}

/* 퓨전차트 */
   function FusionCharts1(data) {
         var asd =[{value:data[0].cpu_pcnt}];
         
         var date = new Date(data[0].cpu_date);
         var hours = date.getHours();
         var minutes = date.getMinutes();
         var FullDate = hours +":"+minutes;
         var time = [{label:FullDate}];
      
         $.each(data,function(i){
         if(i > 0){
            asd.push({value:data[i].cpu_pcnt});
            
            
            date = new Date(data[i].cpu_date);
            hours = date.getHours();
            minutes = date.getMinutes();
            FullDate = hours +":"+minutes;
            
            time.push({label:FullDate});
         }
      })
      var visitChart = new FusionCharts({
         type : 'zoomline',
         renderAt : 'chart-container',
         width : '600',
         height : '400',
         dataFormat : 'json',
         dataSource : {
            "chart" : {
               "caption": "Real-time stock price monitor",
                   "subCaption": "Harry's SuperMart",
                   "xAxisName": "Time",
                   "yAxisName": "Stock Price",
                   "numberSuffix": "%",
                   "refreshinterval": "5",
                   "yaxisminvalue": "0",
                   "yaxismaxvalue": "100",
                   "displayStartIndex":"0",
                   "numdisplaysets": "0",
                   "showValues": "0",
                   "showRealTimeValue": "0",
                   "theme": "fint"

            },
            "categories" : [ {
               "category" : time
            } ],
            "dataset" : [ {
               "seriesname" : "CPU_PCNT",

               "data" : asd
            }, ]
         }
      });
      visitChart.render();
   };
</script>
</head>
<body onload="myFunction()" style="margin:0;">
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <br />
   <form id="formm" name="formm">
      <input type="button" id="btnZxc" class="btnZxc" value="30분" onclick="vv()">
      <input type="button" id="btnAsd" class="btnAsd" value="1시간" onclick="ss()">
      <div id="loader"></div>
      <div id="chart-container"></div>
   </form>
</body>
</html>