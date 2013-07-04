

// =====================
// AJAX

var AJAX_REQUEST;

function doAjaxRequest(url, showResultFunction) 
{
	if (window.ActiveXObject) 
	{
		AJAX_REQUEST = new ActiveXObject("Microsoft.XMLHTTP");
	} 
	else if (window.XMLHttpRequest) 
	{
		AJAX_REQUEST = new XMLHttpRequest();
	}
	
	AJAX_REQUEST.onreadystatechange = showResultFunction;
	AJAX_REQUEST.open("POST", url, true);
	AJAX_REQUEST.send();
}

function getAjaxResponse()
{
		// has to == 4 in order for SUCCESS - all other values, we do nothing
	if (AJAX_REQUEST.readyState != 4) 
		return null;

	var response = AJAX_REQUEST.responseXML;

	return response;
}


// =====================
// MISC

var MAX_DUMP_DEPTH = 10;

function dumpObj(obj, name, indent, depth) {
	if (depth > MAX_DUMP_DEPTH) {
		return indent + name + ": <Maximum Depth Reached>\n";
	}
	if (typeof obj == "object") {
		var child = null;
		var output = indent + name + "\n";
		indent += "\t";
		for ( var item in obj) {
			try {
				child = obj[item];
			} catch (e) {
				child = "<Unable to Evaluate>";
			}
			if (typeof child == "object") {
				output += dumpObj(child, item, indent, depth + 1);
			} else {
				output += indent + item + ": " + child + "\n";
			}
		}
		return output;
	} else {
		return obj;
	}
}

