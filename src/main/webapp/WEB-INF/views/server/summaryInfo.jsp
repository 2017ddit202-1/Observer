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
#container{
margin-left:8%;
}
	}
</style>
<article>

	<h1>요약 페이지</h1>
	<form id="formm" name="formm">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
	</form>
<div id="serverInfo"></div>
<div id="container"></div>
<script type="text/javascript">
var inter="";
var inter2="";
$(function(){
// 	inter  = setInterval("tt()",3000);
	 $("#loader").show();
	 $("#btnZxc").hide();
	 $("#btntotal").hide();
	tt();
	serverInfo();
	
});

function serverInfo(){
		$.ajax({
			url:"<%=request.getContextPath()%>/server/serverInfo",
			type:'post',
			dataType:'json',
			success:function(data){
				var tb = 	'<div id="summaryTb">'
							+'<table>'
							+'<tr style="border:1px solid red;">'
							+'<td style="border:1px solid red;">운영체제</td>'
							+'<td style="border:1px solid red;">서버명</td>'
							+'<td style="border:1px solid red;">IP 주소 </td>'
							+'<td style="border:1px solid red;">BIT</td>'
							+'</tr>'
							+'<tr style="border:1px solid red;">'
							+'<td style="border:1px solid red;">'+data.server_host+'</td>'
							+'<td style="border:1px solid red;">'+data.server_os_name+'</td>'
							+'<td style="border:1px solid red;">'+data.server_ip+'</td>'
							+'<td style="border:1px solid red;">'+data.server_os_support+'</td>'
							+'</tr>'
							+'</table>'
							+'</div>'
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
	$('#container').empty();
	$.ajax({
		url:"<%=request.getContextPath()%>/server/summaryPage",
		type:'post',
		dataType:'json',
		success:function(data){
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
