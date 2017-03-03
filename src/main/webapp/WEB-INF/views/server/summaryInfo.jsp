<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<h1>요약 페이지</h1>
	<form id="formm" name="formm">
      <input type="button" id="btnZxc" class="btnZxc" value="30분" onclick="vv()">
      <input type="button" id="btntotal" class="btnAsd" value="1시간" onclick="ss()">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
	</form>
<div id="container"></div>
<script type="text/javascript">
var inter="";
var inter2="";
$(function(){
	inter  = setInterval("tt()",3000);
	 $("#loader").show();
	 $("#btnZxc").hide();
	 $("#btntotal").hide();
// 	tt();
	
});

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
					$('<div class="chart">').appendTo('#container').highcharts(
							{
								chart : {
									marginLeft : 40, // Keep all charts left aligned
									spacingTop : 20,
									spacingBottom : 20,
									height:200,
						            width:300,
						            borderColor: '#EBBA95',
						            borderRadius: 20,
						            borderWidth: 5
								},
								title : {
									text : dataset.name,
									align : 'left',
									margin : 0,
									x : 30
								},
								credits : {
									enabled : false
								},
								legend : {
									enabled : false
								},
								xAxis : {
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
</body>
</html>
