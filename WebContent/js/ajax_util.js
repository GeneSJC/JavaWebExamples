

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


