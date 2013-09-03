
function error(){
    alert("error");
};
    	
function myAlert(){
    alert("myAlert");
};
//解析json字符串成对象
function parseJson( data ) {
	if ( !data || typeof data !== "string") {
		return null;
	}

	// Make sure leading/trailing whitespace is removed (IE can't handle it)
	data = jQuery.trim( data );

	// Attempt to parse using the native JSON parser first
	if ( window.JSON && window.JSON.parse ) {
		return window.JSON.parse( data );
	}

	// Make sure the incoming data is actual JSON
	// Logic borrowed from http://json.org/json2.js
	if ( rvalidchars.test( data.replace( rvalidescape, "@" )
		.replace( rvalidtokens, "]" )
		.replace( rvalidbraces, "")) ) {

		return ( new Function( "return " + data ) )();

	}
	jQuery.error( "Invalid JSON: " + data );
};



	