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
#container, #container2, #container3{
width:70%;
}
.highcharts-credits{
display:none;
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
//    inter = setInterval("tt()",5000);
   $("#loader").show();
   $("#btnZxc").hide();
   $("#btntotal").hide();
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
            url:"<%=request.getContextPath()%>/cpu/cpuListHours",
            type : "post",
            dataType : 'json',
            success : function(data) {
            	HighCharts(data);
            	HighCharts2(data);
            	HighCharts3(data);
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
	   url:"<%=request.getContextPath()%>/cpu/cpuList",
      type : "post",
      dataType : 'json',
      success : function(data) {
    	  $("#loader").hide();
    	  $("#btnZxc").show();
    	  $("#btntotal").show();
            HighCharts(data);
            HighCharts2(data);
            HighCharts3(data);
      }
   });
};
	/* CPU Total Pcnt */
	function HighCharts(data){
        var total =[window.parseInt(data[0].cpu_total_pcnt)];
        var date = new Date(data[0].cpu_date);
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var FullDate = hours +":"+minutes;
        var time = [FullDate];
        
     
        $.each(data,function(i){
        if(i > 0){
           total.push(parseInt(data[i].cpu_total_pcnt));
           
           date = new Date(data[i].cpu_date);
           hours = date.getHours();
           minutes = date.getMinutes();
           FullDate = hours +":"+minutes;
           
           time.push(FullDate);
        }
     });
        Highcharts.chart('container', {
            chart: {
                type: 'spline'
            },
            title: {
                text: 'CPU Total'
            },
            xAxis: {
            	categories:time
            },
            yAxis: {
                title: {
                    text: 'Percent (%)'
                },
                labels: {
                    formatter: function () {
                        return this.value + '%';
                    }
                }
        },
            series: [{
                name: 'CPU TOTAL',
                data: total
            }],
            navigation: {
                menuItemStyle: {
                    fontSize: '10px'
                }
            }
        })
	};

	/* Cpu_pcnt , Cpu_pcnt */
   function HighCharts2(data) {
	   var pcnt =[window.parseInt(data[0].cpu_pcnt)];
	   var userPcnt = [window.parseInt(data[0].cpu_user_pcnt)];
       
       var date = new Date(data[0].cpu_date);
       var hours = date.getHours();
       var minutes = date.getMinutes();
       var FullDate = hours +":"+minutes;
       var time = [FullDate];
    
       $.each(data,function(i){
       if(i > 0){
    	   pcnt.push(parseInt(data[i].cpu_pcnt));
    	   userPcnt.push(parseInt(data[i].cpu_user_pcnt));
          
          
          date = new Date(data[i].cpu_date);
          hours = date.getHours();
          minutes = date.getMinutes();
          FullDate = hours +":"+minutes;
          
          time.push(FullDate);
       }
    })
    Highcharts.chart('container2', {
        chart: {
            type: 'area'
        },
        title: {
            text: 'CPU 사용량'
        },
        xAxis: {
        	categories:time
        },
        yAxis: {
            title: {
                text: 'Percent'
            },
            labels: {
                formatter: function () {
                    return this.value + '%';
                }
            }
        },
        plotOptions: {
            area: {
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                }
            }
        },
        series: [{
            name: 'CPU USER',
            data: userPcnt
        }, {
            name: 'CPU System',
            data: pcnt
        }]
    });
};
/* Cpu_Idle */
function HighCharts3(data) {
	  var idle =[window.parseInt(data[0].cpu_idle)];
      var date = new Date(data[0].cpu_date);
      var hours = date.getHours();
      var minutes = date.getMinutes();
      var FullDate = hours +":"+minutes;
      var time = [FullDate];
      
   
      $.each(data,function(i){
      if(i > 0){
    	  idle.push(parseInt(data[i].cpu_idle));
         
         date = new Date(data[i].cpu_date);
         hours = date.getHours();
         minutes = date.getMinutes();
         FullDate = hours +":"+minutes;
         
         time.push(FullDate);
      }
   });
      Highcharts.chart('container3', {
          chart: {
              type: 'spline'
          },
          title: {
              text: 'CPU Idle'
          },
          xAxis: {
          	categories:time
          },
          yAxis: {
              title: {
                  text: 'Percent (%)'
              },
              labels: {
                  formatter: function () {
                      return this.value + '%';
                  }
              }
      },
          series: [{
              name: 'CPU Idle',
              data: idle
          }],
          navigation: {
              menuItemStyle: {
                  fontSize: '10px'
              }
          }
      })
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
      <tr><th><div id="container"></div></th></tr>
      </table>
      <table border="1">
      <tr><th><div id="container2"></div></th></tr>
      </table>
       <table border="1">
      <tr><th><div id="container3"></div></th></tr>
      </table>
   </form>
</body>
</html>