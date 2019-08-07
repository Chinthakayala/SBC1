function ValidateIPaddress(inputText1="", inputText2="", inputText="" )
 {
	var s1= "You have entered an invalid pattern for";
	var isValid = true;
 var ipformat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
 var k= /^\d{3},\d{3}/;
 		if(inputText1.value.match(ipformat)) {
			console.log("success ip");
		} else {
			s1 = s1+" IP Field";
			isValid = false;
		}
 
		if(inputText.value.match(ipformat)) {
			console.log("success BMC");
		} else {
			s1 =s1+" bmcIP";
			isValid = false;
		}
		 
		if(inputText2.value.match(k)) {
			console.log("success vlan");
		} else {
			s1 =s1+" Vlan field";
			isValid = false;
		}

		if(!isValid) {
			alert(s1);
			return false;
		} else {
			statusCheck();
			
		}
 }

function statusCheck() {
	$.ajax({
        type: "GET",
        url: "/SBC/JsonWriting",
        data: {
            ts: $.now(),
            sino: $('#fn1').val(), BoxName:$('#fn2').val(), Ip:$('#fn3').val(),
            UserName:$('#fn4').val(), password:$('#fn5').val(), BmcIp:$('#fn6').val(),
            BmcIpusername:$('#fn7').val(), BmcPass:$('#fn8').val(), SoftwareLoad:$('#fn9').val(),
            Assign:$('#fn10').val(), ReversedBy:$('#fn11').val(), Reserved:$('#fn12').val(),
            Vlan:$('#fn13').val(), Cmts:$('#fn14').val()
        }
	});
}