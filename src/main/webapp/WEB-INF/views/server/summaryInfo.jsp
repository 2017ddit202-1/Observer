<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<style>
   .chart{
      width: 30%;
       height: 335px;
       display: inline-block;
       margin-left: 10%;
   }
   #summaryTb{
          width: 15%;
          margin-left: 9%;
   }
   #page-wrapper6{
      text-align:center;
       position: inherit;
       margin: 0 0 0 250px;
       padding: 65px 30px;
        box-shadow: 5px 5px 5px lightgray;
        border-radius: 10px; 
       padding: 0 15px;
       background-color: white;
       margin-left: 2%;
       width: 630px;
       height: 305px;
       margin-bottom: 1.5%;
}

   #page-wrapper7{
      text-align:center;
       position: inherit;
       margin: 0 0 0 250px;
       padding: 65px 30px;
        box-shadow: 5px 5px 5px lightgray;
        border-radius: 10px; 
       padding: 0 15px;
       background-color: white;
       margin-left: 4%;
       width: 1300px;
       height: 252px;
       margin-bottom: 1.5%;
}


#container{
margin-left:8%;
}
   }
</style>
<article>
   <form id="formm" name="formm">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
   </form>
<div id="serverInfo"></div>
<div id="container"></div>
<script type="text/javascript">
var inter="";
var inter2="";
$(function(){
   inter  = setInterval("tt()",5000);
    $("#loader").show();
    $("#btnZxc").hide();
    $("#btntotal").hide();
//    tt();
   serverInfo();
   
});

function serverInfo(){
      $.ajax({
         url:"<%=request.getContextPath()%>/server/serverInfo",
         type:'post',
         dataType:'json',
         success:function(data){
            var tb =      '<div id="page-wrapper7">'
            
            	+'<br>'
            	+'<div class="media">'
            	+'<div class="media-left">'
            	+'<img src="<%=request.getContextPath()%>/resources/img/analysis .png" class="media-object" style="width:60px;margin-left: 39%;">'
            	+'</div>'
            	+'<div class="media-body">'
            	+'<h4 class="media-heading" style="margin-left: 3%; margin-top: 1%; "><strong>요약정보</strong></h4>'
            	+'<p style="margin-left: 3%;">SERVER의 CPU, 메모리의 과다사용 내역을 실시간으로 안내해주는 서비스.</p>'
            	+'</div>'
            	+'</div>'
            	+'<hr>'
            	+'<br>'
                   
                     +'<br/>'
                     +'<table  style="width: 1000px;">'
                     +'<tr>'
                     +'<td>운영체제</td>'
                     +'<td>'+data.server_host+'</td>'
                     +'<td>서버명</td>'
                     +'<td>'+data.server_os_name+'</td>'
                     +'<td>IP 주소 </td>'
                     +'<td>'+data.server_ip+'</td>'
                     +'<td>BIT</td>'
                     +'<td>'+data.server_os_support+'</td>'
                     +'</tr>'
                     +'</table>'
                    
                     +'</div>'
                     +'<br/>'
               $('#serverInfo').html(tb);
         }
   });
};


$('#container').bind('mousemove touchmove touchstart', function (e) {
    var chart,
        point,
        i,
        event;

    for (i = 0; i < Highcharts.charts.length; i = i + 1) {
        chart = Highcharts.charts[i];
        event = chart.pointer.normalize(e.originalEvent); // Find coordinates within the chart
        point = chart.series[0].searchPoint(event, true); // Get the hovered point

        if (point) {
            point.highlight(e);
        }
    }
});
Highcharts.Pointer.prototype.reset = function () {
    return undefined;
};

Highcharts.Point.prototype.highlight = function (event) {
    this.onMouseOver(); // Show the hover marker
    this.series.chart.tooltip.refresh(this); // Show the tooltip
    this.series.chart.xAxis[0].drawCrosshair(event, this); // Show the crosshair
};

function syncExtremes(e) {
    var thisChart = this.chart;

    if (e.trigger !== 'syncExtremes') { // Prevent feedback loop
        Highcharts.each(Highcharts.charts, function (chart) {
            if (chart !== thisChart) {
                if (chart.xAxis[0].setExtremes) { // It is null while updating
                    chart.xAxis[0].setExtremes(e.min, e.max, undefined, false, { trigger: 'syncExtremes' });
                }
            }
        });
    }
}

function tt() {
   $.ajax({
      url:"<%=request.getContextPath()%>/server/summaryPage",
      type:'post',
      dataType:'json',
      success:function(data){
         $('#container').empty();
          $("#loader").hide();
          $("#btnZxc").show();
          $("#btntotal").show();
         var time = "";
            $.each(data.xData,function(i,date){
               var dat = new Date(data.xData[i]);
               var hours = dat.getHours();
                 var minutes = dat.getMinutes();
                 var FullDate = hours +":"+minutes;
                 if(i == 0){
                    time = [FullDate];
                 }
                 
                 if(i > 0){
                    time.push(FullDate);
                 }
               
            });
         
            $.each(data.datasets, function(i, dataset) {
               $.each(dataset.data, function(j, ff) {
                  if (j == 0) {
                     total = [ window.parseInt(ff) ];
                  }
                  if (j > 0) {
                     total.push(parseInt(ff));
                  }
               });
               $('<div class="chart" id="page-wrapper6">').appendTo('#container').highcharts(
                     {
                        chart : {
                           marginLeft : 40, // Keep all charts left aligned
                           spacingTop : 20,
                           spacingBottom : 20,
                           height:300,
                              width:600,
                              marginTop:60,
                              marginLeft: 50
                        },
                        title : {
                           text : dataset.name,
                           align : 'left',
                           margin : 0,
                           x : 30,
                           style:{
                              fontSize:'20px',
                              
                           }
                        },
                        credits : {
                           enabled : false
                        },
                        legend : {
                           enabled : false
                        },
                        xAxis : {
                           gridLineColor:'#ffffff',
                           crosshair : true,
                           categories:time,
                           tickInterval: 4,
                           labels: {
                                     rotation: 0,
                                     align: 'center'
                                }
                        },
                         plotOptions: {
                             series: {
                                 marker: {
                                     enabled: false
                                 }
                             }
                         },
                        yAxis : {
                             minorGridLineColor:'#ffffff',
                           title : {
                              text : null
                           },
                             labels: {
                                      formatter: function () {
                                          return this.value + '%';
                                      }
                                  }
                        },

                        series : [ {
                           data : total,
                           name : dataset.name,
                           type : dataset.type,
                           color : Highcharts.getOptions().colors[i],
                           fillOpacity : 0.3,
                           tooltip : {
                              valueSuffix : ' ' + dataset.unit
                           }
                        } ]
                     });
            });
         }
      });
   };
</script>
</article>