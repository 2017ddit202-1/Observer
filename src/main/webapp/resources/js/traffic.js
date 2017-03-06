var cpu_total_pcnt = "";
var inter="";
var inter2="";
var pp = 0;

/* 처음 로딩 시 tt 호출 후 setInterval */
$(function(){
    inter = setInterval("tt()",5000);
   $("#loader").show();
   $("#card").hide();
   $("#btnZxc").hide();
   $("#btntotal").hide();
   $('#page-wrapper88').hide();
   $('#page-wrapper99').hide();
   $('#page-wrapper00').hide();
   $('#foot').hide();
//   tt();
   	
});

/* 새로고침 막기 */
function LockF5(){
    if (event.keyCode == 116) {
     event.keyCode = 0;
     return false;
    }
   }
   document.onkeydown = LockF5;

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
            url:"trafficListHours",
            type : "post",
            dataType : 'json',
            success : function(data) {
            	HighCharts(data);
            	HighCharts2(data);
            	$("#net").html(data[0].traffic_net);
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
	   url:"trafficList",
      type : "post",
      dataType : 'json',
      success : function(data) {
    	  var aa = [data];
    	  $("#loader").hide();
    	  $("#card").show();
    	  $("#btnZxc").show();
    	  $("#btntotal").show(); 
    	  $('#page-wrapper88').show();
    	  $('#page-wrapper99').show();
    	  $('#page-wrapper00').show();
    	  $('#foot').show();
            HighCharts(data);
            HighCharts2(data);
            $("#net").html(data[0].traffic_net);
      }
   });
};
	/*Traffic Total*/
function HighCharts(data) {
	var total =[window.parseInt(data[0].traffic_use)];
    
    var date = new Date(data[0].traffic_date);
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var FullDate = hours +":"+minutes;
    var time = [FullDate];
 
    $.each(data,function(i){
    if(i > 0){
    	total.push(parseInt(data[i].traffic_use));
       
       date = new Date(data[i].traffic_date);
       hours = date.getHours();
       minutes = date.getMinutes();
       FullDate = hours +":"+minutes;
       
       time.push(FullDate);
    }
 })
 Highcharts.chart('container', {
     chart: {
         type: 'area',
         height:350,
         width:1200
     },
     title: {
     	 text: 'TRAFFIC TOTAL',
     	 style:{
     		 fontSize:'20px'
     	 }
     		
     },
     xAxis: {
     	categories:time,
     	gridLineColor:'#ffffff',
     	tickLength: 10,
     	tickInterval: 4,
   	  	labels: {
             rotation: 0,
             align: 'center'
   	  }
     },
     yAxis: {
         title: {
         	text: 'Kilobytes (K)',
         },
         labels: {
             formatter: function () {
                 return this.value + 'K';
             }
         },
         minorGridLineColor:'#ffffff'
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
         name: 'TRAFFIC TOTAL',
         data: total
     }]
 });
};

	/* traffic_trans , traffic_rece*/
   function HighCharts2(data) {
	   var rece =[window.parseInt(data[0].traffic_rece)];
	   var trans = [window.parseInt(data[0].traffic_trans)];
       
       var date = new Date(data[0].traffic_date);
       var hours = date.getHours();
       var minutes = date.getMinutes();
       var FullDate = hours +":"+minutes;
       var time = [FullDate];
    
       $.each(data,function(i){
       if(i > 0){
    	   rece.push(parseInt(data[i].traffic_rece));
    	   trans.push(parseInt(data[i].traffic_trans));
          
          
          date = new Date(data[i].traffic_date);
          hours = date.getHours();
          minutes = date.getMinutes();
          FullDate = hours +":"+minutes;
          
          time.push(FullDate);
       }
    })
    Highcharts.chart('container2', {
        chart: {
            type: 'area',
            height:350,
	         width:1200
        },
        title: {
        	 text: 'TRAFFIC I/O',
        	 style:{
      			 fontSize:'20px'
      		 }
        },
        xAxis: {
        	categories:time,
        	gridLineColor:'#ffffff',
        	tickLength: 10,
        	tickInterval: 4,
      	  	labels: {
                rotation: 0,
                align: 'center'
      	  }
        },
        yAxis: {
            title: {
            	text: 'Kilobytes (K)'
            },
            labels: {
                formatter: function () {
                    return this.value + 'K';
                }
            },
            minorGridLineColor:'#ffffff'
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
            name: 'Received',
            data: rece
        }, {
            name: 'Transmitted',
            data: trans
        }]
    });
};
