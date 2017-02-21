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
            url:"cpuListHours",
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
	   url:"cpuList",
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
