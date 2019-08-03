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
		}
 }