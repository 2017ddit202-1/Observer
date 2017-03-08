var cpu_total_pcnt = "";
var inter="";
var inter2="";
var inter3="";
var pp = 0;
/* 처음 로딩 시 tt 호출 후 setInterval */
$(function(){
    inter = setInterval("tt()",5000);
   $("#loader").show();
   $("#btnZxc").hide();
   $("#btntotal").hide();
   $("#diskTb").hide();
   $('#page-wrapper10').hide();
   $('#page-wrapper11').hide();
   $('#page-wrapper12').hide();
   $('#trafficNet').hide();
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
    clearInterval(inter3);
    if(dd==0){
       dd++;
       ff();
        inter2 = setInterval("ff()",5000);
       dd = 0;
    }
}

/* 1시간 리스트*/
function ff(){
	var aa = "";
	$('tr').find('input[type="hidden"]').each(function(i,e){
		aa += $(this).val()+",";
	})
       $.ajax({
            url:"diskListHo",
            type : "post",
            dataType : 'json',
            contentType:'application/json',
            data:JSON.stringify({"aa":aa}),
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
    clearInterval(inter3);
    if(pp==0){
       pp++;
       tt();
        inter = setInterval("tt()",5000);
       pp = 0;
    }
};

/* 처음 리스트 */
function tt(){
	var aa = "";
	$('tr').find('input[type="hidden"]').each(function(i,e){
		aa += $(this).val()+",";
	})
   $.ajax({
	   url:"diskList",
      type : "post",
      dataType : 'json',
      contentType:'application/json',
      data:JSON.stringify({"aa":aa}),
      success : function(data) {
    	  $("#loader").hide();
    	  $("#btnZxc").show();
    	  $("#btntotal").show();
    	  $("#diskTb").show(); 
    	  $('#page-wrapper10').show();
    	  $('#page-wrapper11').show();
    	  $('#page-wrapper12').show();
    	  $('#trafficNet').show();
    	  $('#foot').show();
            HighCharts(data);
            HighCharts2(data);
            HighCharts3(data);
      }
   });
};
	/* Disk Total */
function HighCharts(data) {
	var total = [ window.parseInt(data[0].disk_total) ];

	var date = new Date(data[0].disk_date);
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var FullDate = hours + ":" + minutes;
	var time = [ FullDate ];

	$.each(data, function(i) {
		if (i > 0) {
			total.push(parseInt(data[i].disk_total));

			date = new Date(data[i].disk_date);
			hours = date.getHours();
			minutes = date.getMinutes();
			FullDate = hours + ":" + minutes;

			time.push(FullDate);
		}
	})
	Highcharts.chart('container', {
		chart : {
			type : 'area',
			  height:350,
		         width:1200
		},
		title : {
			text : 'Disk TOTAL',
            style:{
      			 fontSize:'20px'
      		 }

		},
		xAxis : {
			categories : time,
			gridLineColor : '#ffffff',
			tickLength : 10,
			tickInterval : 4,
			labels : {
				rotation : 0,
				align : 'center'
			}
		},
		yAxis : {
			title : {
				text : 'Gigabyte (GB)'
			},
			labels : {
				formatter : function() {
					return this.value + 'GB';
				}
			},
			minorGridLineColor : '#ffffff'
		},
		plotOptions : {
			area : {
				marker : {
					enabled : false,
					symbol : 'circle',
					radius : 2,
				}
			}
		},
		series : [ {
			name : 'MEMORY TOTAL',
			data : total
		} ]
	});
};

 /* Disk_Using , Disk_idle */
 function HighCharts2(data) {
	   var diUser =[window.parseInt(data[0].disk_using)];
	   var diIdle = [window.parseInt(data[0].disk_idle)];
       
       var date = new Date(data[0].disk_date);
       var hours = date.getHours();
       var minutes = date.getMinutes();
       var FullDate = hours +":"+minutes;
       var time = [FullDate];
    
       $.each(data,function(i){
       if(i > 0){
    	   diUser.push(parseInt(data[i].disk_using));
    	   diIdle.push(parseInt(data[i].disk_idle));
          
          
          date = new Date(data[i].disk_date);
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
            text: 'DISK 사용량',
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
                text: 'Percent'
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
            name: 'DISK USER',
            data: diUser
        }, {
            name: 'DISK IDLE',
            data: diIdle
        }]
    });
};
/* DISK_PCNT */
function HighCharts3(data) {
	  var pcnt =[window.parseInt(data[0].disk_pcnt)];
      var date = new Date(data[0].disk_date);
      var hours = date.getHours();
      var minutes = date.getMinutes();
      var FullDate = hours +":"+minutes;
      var time = [FullDate];
      
   
      $.each(data,function(i){
      if(i > 0){
    	  pcnt.push(parseInt(data[i].disk_pcnt));
         
         date = new Date(data[i].disk_date);
         hours = date.getHours();
         minutes = date.getMinutes();
         FullDate = hours +":"+minutes;
         
         time.push(FullDate);
      }
   });
      Highcharts.chart('container3', {
          chart: {
              type: 'spline',
              height:350,
              width:1200,
          },
          title: {
              text: 'DISK 사용률',
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
          series: {
              marker: {
                  enabled: false
              }
          }
      },
          series: [{
              name: 'DISK PCNT',
              data: pcnt
          }],
          navigation: {
              menuItemStyle: {
                  fontSize: '10px'
              }
          }
      })
	};
