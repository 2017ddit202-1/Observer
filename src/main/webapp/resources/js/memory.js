var cpu_total_pcnt = "";
var inter="";
var inter2="";
var pp = 0;

/* 처음 로딩 시 tt 호출 후 setInterval */
$(function(){
    inter = setInterval("tt()",5000);
   $("#loader").show();
   $("#btnZxc").hide();
   $("#btntotal").hide();
   $('#page-wrapper8').hide();
   $('#page-wrapper9').hide();
   $('#page-wrapper0').hide();
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
            url:"memoryListHours",
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
        inter = setInterval("tt()",5000);
       pp = 0;
    }
}

/* 처음 리스트 */
function tt(){
   $.ajax({
	   url:"memoryList",
      type : "post",
      dataType : 'json',
      success : function(data) {
    	  $("#loader").hide();
    	  $("#btnZxc").show();
    	  $("#btntotal").show();
    	  $('#page-wrapper8').show();
    	  $('#page-wrapper9').show();
    	  $('#page-wrapper0').show();
    	  $('#foot').show();
            HighCharts(data);
            HighCharts2(data);
            HighCharts3(data);
      }
   });
};
	/*total Memory*/
function HighCharts(data) {
	   var total =[window.parseInt(data[0].memory_total)];
    
    var date = new Date(data[0].memory_date);
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var FullDate = hours +":"+minutes;
    var time = [FullDate];
 
    $.each(data,function(i){
    if(i > 0){
    	total.push(parseInt(data[i].memory_total));
       
       date = new Date(data[i].memory_date);
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
         width:1200,
     },
     title: {
     	 text: 'MEMORY TOTAL',
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
         	text: 'Gigabyte (GB)'
         },
         labels: {
             formatter: function () {
                 return this.value + 'GB';
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
         name: 'MEMORY TOTAL',
         data: total,
         color:'#619141'
     }]
 });
};

	/*Memory_using , Memory_Idle*/
   function HighCharts2(data) {
	   var using =[window.parseInt(data[0].memory_using)];
	   var idle = [window.parseInt(data[0].memory_idle)];
       
       var date = new Date(data[0].memory_date);
       var hours = date.getHours();
       var minutes = date.getMinutes();
       var FullDate = hours +":"+minutes;
       var time = [FullDate];
    
       $.each(data,function(i){
       if(i > 0){
    	   using.push(parseInt(data[i].memory_using));
    	   idle.push(parseInt(data[i].memory_idle));
          
          
          date = new Date(data[i].memory_date);
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
        	 text: 'MEMORY 사용량',
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
            	text: 'Gigabyte (GB)'
            },
            labels: {
                formatter: function () {
                    return this.value + 'GB';
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
            name: 'MEMORY USER',
            data: using
        }, {
            name: 'MEMORY IDLE',
            data: idle,
            color:'#686b70'	
        }]
    });
};
/*Memory 전체 사용량 (%)*/
function HighCharts3(data) {
	   var total_used =[window.parseInt(data[0].memory_total_used)];
 
 var date = new Date(data[0].memory_date);
 var hours = date.getHours();
 var minutes = date.getMinutes();
 var FullDate = hours +":"+minutes;
 var time = [FullDate];

 $.each(data,function(i){
 if(i > 0){
	   total_used.push(parseInt(data[i].memory_total_used));
    
    date = new Date(data[i].memory_date);
    hours = date.getHours();
    minutes = date.getMinutes();
    FullDate = hours +":"+minutes;
    
    time.push(FullDate);
 }
})
Highcharts.chart('container3', {
  chart: {
      type: 'area',
      height:350,
      width:1200,
  },
  title: {
  	 text: 'MEMORY 전체 사용량 (%)',
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
      	text: 'Percent (%)'
      },
      labels: {
          formatter: function () {
              return this.value + '%';
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
      name: 'MEMORY 전체 사용량(%)',
      data: total_used,
  }]
});
};