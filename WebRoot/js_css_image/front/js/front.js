function listRdxw(){
    $.post(ctx+"/front/front_listRdxw.do?","channelPath=rdxw",function(data){
 	   $("#listRdxwDiv").html(data);
    });
}
function listTzgg(){
    $.post(ctx+"/front/front_listTzgg.do?","channelPath=tzgg",function(data){
 	   $("#listTzggDiv").html(data);
    });
}