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
.raphael-group-124-creditgroup, .raphael-group-30-toolbar-group10{
display:none;
}

/* Center the loader */
#loader {
   position: absolute; 
   left: 50%; 
   top: 50%; 
   z-index: 1; 
   width: 150px; 
   height: 150px; 
   margin: -75px 0 0 -75px; 
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* Add animation to "page content" */
.animate-bottom {
  position: relative;
  -webkit-animation-name: animatebottom;
  -webkit-animation-duration: 1s;
  animation-name: animatebottom;
  animation-duration: 1s
}

@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}

#myDiv {
  display: none;
  text-align: center;
}
</style>

<script>
var cpu_total_pcnt = "";
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
   inter = setInterval("tt()",5000);
   $("#loader").show();
   $("#btnZxc").hide();
   $("#btntotal").hide();
});

/* 1시간 버튼 클릭 시 */
var dd = 0;
function ss(){
    clearInterval(inter);
    if(dd==0){
       dd++;
       ff();
       inter2 = setInterval("ff()",5000);
       dd = 0;
    }
}

/* 1시간 리스트*/
function ff(){
       $.ajax({
            url:"<%=request.getContextPath()%>/cpu/cpuListHours",
            type : "post",
            dataType : 'json',
            success : function(data) {
               FusionCharts1(data);
               FusionCharts2(data);
               FusionCharts3(data);
            }
    })
}

/* 30분 버튼 클릭 시 */
function vv(){
    clearInterval(inter2);
    if(pp==0){
       pp++;
       tt();
       inter = setInterval("tt()",5000);
       pp = 0;
    }
}

/* 처음 리스트 */
function tt(){
   $.ajax({
	   url:"<%=request.getContextPath()%>/cpu/cpuList",
      type : "post",
      dataType : 'json',
      success : function(data) {
    	  $("#loader").hide();
    	  $("#btnZxc").show();
    	  $("#btntotal").show();
            FusionCharts1(data);
            FusionCharts2(data);
            FusionCharts3(data);
      }
   });
};

/* 퓨전차트 cpu_total_pcnt */
   function FusionCharts1(data) {
         var total =[{value:data[0].cpu_total_pcnt}];
         
         var date = new Date(data[0].cpu_date);
         var hours = date.getHours();
         var minutes = date.getMinutes();
         var FullDate = hours +":"+minutes;
         var time = [{label:FullDate}];
      
         $.each(data,function(i){
         if(i > 0){
            total.push({value:data[i].cpu_total_pcnt});
            
            
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
               "seriesname" : "CPU Total",

               "data" : total
            }, ]
         }
      });
      visitChart.render();
   };
   

   function FusionCharts2(data) {
	   var pcnt =[{value:data[0].cpu_pcnt}];
	   var userPcnt = [{value:data[0].cpu_cpu_user_pcnt}];
       
       var date = new Date(data[0].cpu_date);
       var hours = date.getHours();
       var minutes = date.getMinutes();
       var FullDate = hours +":"+minutes;
       var time = [{label:FullDate}];
    
       $.each(data,function(i){
       if(i > 0){
    	   pcnt.push({value:data[i].cpu_pcnt});
    	   userPcnt.push({value:data[i].cpu_user_pcnt});
          
          
          date = new Date(data[i].cpu_date);
          hours = date.getHours();
          minutes = date.getMinutes();
          FullDate = hours +":"+minutes;
          
          time.push({label:FullDate});
       }
    })
    var visitChart = new FusionCharts({
        type: 'zoomline',
        renderAt: 'chart-container2',
        width: '600',
        height: '400',
        dataFormat: 'json',
        dataSource: {
            "chart": {
                "numberSuffix": "%",
                "refreshinterval": "5",
                "yaxisminvalue": "0",
                "yaxismaxvalue": "100",
                "usePlotGradientColor": "0",
                "displayStartIndex":"0",
                "theme": "fint"
                
            },
            "categories": [
                {
                    "category":  time
                }
            ],
            "dataset": [
                {
                    "seriesname": "CPU System",
                    "data": pcnt
                    
                }, 
                {
                    "seriesname": "CPU User",
                    "data": userPcnt
                }
            ]
        }
    });
    visitChart.render();
};

function FusionCharts3(data) {
    var idle =[{value:data[0].cpu_idle}];
    
    var date = new Date(data[0].cpu_date);
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var FullDate = hours +":"+minutes;
    var time = [{label:FullDate}];
 
    $.each(data,function(i){
    if(i > 0){
    	idle.push({value:data[i].cpu_idle});
       
       
       date = new Date(data[i].cpu_date);
       hours = date.getHours();
       minutes = date.getMinutes();
       FullDate = hours +":"+minutes;
       
       time.push({label:FullDate});
    }
 })
 var visitChart = new FusionCharts({
    type : 'zoomline',
    renderAt : 'chart-container3',
    width : '600',
    height : '400',
    dataFormat : 'json',
    dataSource : {
       "chart" : {
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
          "seriesname" : "CPU Idle",

          "data" : idle
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
      <input type="button" id="btntotal" class="btnAsd" value="1시간" onclick="ss()">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
      
      <table border="1">
        <tr><th><div id="chart-containerHeader">CPU Total</div></th></tr>
      	<tr><td><div id="chart-container"></div></td></tr>
      </table>
       <table border="1">
        <tr><th><div id="chart-containerHeader">CPU 사용량</div></th></tr>
      	<tr><td><div id="chart-container2"></div></td></tr>
      </table>
       <table border="1">
        <tr><th><div id="chart-containerHeader">CPU Idle</div></th></tr>
      	<tr><td><div id="chart-container3"></div></td></tr>
      </table>
   </form>
</body>
</html>