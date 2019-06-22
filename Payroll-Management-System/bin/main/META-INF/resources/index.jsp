<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.debug.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>



<div>
<p>hiii friends</p>
	<button onclick="sub()">hello</button>
</div>
<script>
	function sub(){
		alert('hii');
		pdfdoc.fromHTML($("‘#PDFcontent"’).html(), 10, 10, { '‘width’':110 };
		pdfdoc.save(‘"First.pdf");
	}

</script>
<!-- <div id="PDFcontent"“>
<h3>First PDF</h3>

 

<p>Content to be written in PDF can be placed in this DIV!</p>

</div>

<div id="ignoreContent">

<p>Only for display and not in pdf</p>

</div>
<a href="#" onclick="fun()">click me</a>
<button type="button" class="call-btn">Generate PDF</button>


<script>
function fun(){
	alert('inside');
}
$(document).ready(function(){
$.fn.myFunction = function(){ 
    alert('You have successfully defined the function!'); 
}
$(".call-btn").click(function(){
    $.fn.myFunction();
});
});
var pdfdoc = new jsPDF ();
var specialElementHandlers = {'#ignoreContent'‘’: function (element,renderer ) {
	return true;
}
};
$(document ).ready (function(){
	$(“"gpdf"”).click(function(){
alert('came');
	pdfdoc.fromHTML($("‘#PDFcontent"’).html(), 10, 10, { '‘width’':110,
	‘'elementHandlers’' : specialElementHandlers
	
});
pdfdoc.save(‘"First.pdf");
});
}
);
</script> -->