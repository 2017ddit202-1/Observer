function fbList_go(page){

	document.formm.action = "fbList?tpage="+page;
	document.formm.submit();
}

function go_fbWrite(page){
	document.formm.action = "fbUpdate?tpage="+page;
    document.formm.submit();
}
function go_fbDelete(page){
	document.formm.action = "fbDelete?tpage="+page;
    document.formm.submit();
}
