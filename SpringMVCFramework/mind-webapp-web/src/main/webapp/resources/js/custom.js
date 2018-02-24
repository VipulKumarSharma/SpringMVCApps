/**
 * 
 */


   function getWidth(id){

		var tabrtele = document.getElementById(id);
		//alert(tabrtele.offsetLeft);
		//alert(tabrtele.offsetTop);
		var xy = getXYpos(tabrtele);
		//alert(xy.x);
		return xy.x;
	}
   
   function getXYpos(elem) {
	   if (!elem) {
	      return {"x":0,"y":0};
	   }
	   var xy={"x":elem.offsetLeft,"y":elem.offsetTop}
	   var par=getXYpos(elem.offsetParent);
	   for (var key in par) {
	      xy[key]+=par[key];
	   }
	   return xy;
	}