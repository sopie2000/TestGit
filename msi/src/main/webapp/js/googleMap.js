var JsonData;
var map;
var latlngArr = new Array();
var marker = new Array();
var flightPathObj;
var flightPathArr = new Array();
var circleMap;
var customControlDiv;

function initMap() {
	
	$.getJSON("./sampleMapJson.do", function (data) {
		for (var i = 0; i < data.length; i++) {
			
			var lat = data[i].lat;
			var lng = data[i].lng;
			
 			map = new google.maps.Map(document.getElementById('map'), {
	    		center: new google.maps.LatLng(lat, lng),
	    		zoom: 16,
	    		mapTypeId: google.maps.MapTypeId.ROADMAP
			});
			latlngArr.push(data[i]);
		}
		addMarker();
	});
}

//초기화
function init() {
	$("#map").css("width", "100%");
	$("#pano").css("width", "0%");
	$("#controlUiId").css("text-align", "center");
	latlngArr = [];
	marker = [];
	flightPathArr = [];
	circleMap = null;
	map = null;
	customControlDiv = null;
	initMap();
}

//마커추가
function addMarker() {
	
	for (var i = 0; i < latlngArr.length; i++) {
		var myIcon = new google.maps.MarkerImage("/images/map-158493_960_720.png", null, null, null, new google.maps.Size(20,20));
	 	var marker = new google.maps.Marker({ 
		      position:  new google.maps.LatLng(latlngArr[i].lat, latlngArr[i].lng), 
		      map: map,
		      icon: myIcon,
		      title: "<div>" + latlngArr[i].title + "</div>",
		      draggable: true,
		      streetViewControl: true,
		      animation: google.maps.Animation.DROP
		}); 
	 	
	 	flightPathObj = new Object();
	 	flightPathObj.lat = latlngArr[i].lat;
	 	flightPathObj.lng = latlngArr[i].lng;
	 	flightPathArr.push(flightPathObj);
	 	
	 	flightPath(map, new google.maps.LatLng(latlngArr[i].lat, latlngArr[i].lng));
	 	addWindow(map, marker, latlngArr[i].title, latlngArr[i].lat, latlngArr[i].lng);
	}
}

//말풍선추가
function addWindow(map, marker, title, lat, lng) {
	
	var infowindow = new google.maps.InfoWindow({
		content: title,
		size: new google.maps.Size(100,100)
	});	
	
	google.maps.event.addListener(marker, 'click', function() { 
		mapCircle(map, new google.maps.LatLng(lat, lng));
		infowindow.open(map, marker);
		findAddress(lat+","+lng);
		
		//Custom button 생성
		$("#customerId").remove();
		var customControlDiv = document.createElement('div');
		customControlDiv.setAttribute("id","customerId");
		new customControl(customControlDiv, map, title, lat, lng);
		customControlDiv.index = 1;
		map.controls[google.maps.ControlPosition.TOP_CENTER].push(customControlDiv);
	});
	infowindow.open(map, marker);
}

//반경그리기
function mapCircle(map, center) {
	
    var covered = {
            strokeColor: '#499CB8',
            strokeOpacity: 0.2,
            strokeWeight: 1,
            fillColor: 'B4D2DB',
            fillOpacity: 0.35,
            map: map,
            center: center,
            radius: 200
        };
    
	if (circleMap != null) {
		circleMap.setMap(null);
		circleMap = null;
	} else {
		circleMap = new google.maps.Circle(covered);
		circleMap.setMap(map);
	}
}

//선그리기
function flightPath(){
	var flightPath = new google.maps.Polyline({
		path: flightPathArr,
		geodesic: true,
		strokeColor: '#000000',
		strokeOpacity: 0.2,
		strokeWeight: 2
	});
	flightPath.setMap(map);	
}

//위도 경도로 주소 찾기
function findAddress(latlng) {
	var url = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&language=ko&latlng="+latlng;
	$.getJSON(url, function (data) {
		var jsonData = data.results;
		if (data.results != null) {
			$("#address").val(jsonData[0].formatted_address);
		}
	});
}

function customControl(controlDiv, map, title, lat, lng) {
	  // Set CSS for the control border.
	  var controlUI = document.createElement('div');
	  controlUI.setAttribute("id","controlUiId");
	  controlUI.style.backgroundColor = '#fff';
	  controlUI.style.border = '2px solid #fff';
	  controlUI.style.borderRadius = '3px';
	  controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
	  controlUI.style.cursor = 'pointer';
	  controlUI.style.marginBottom = '22px';
	  controlUI.style.textAlign = 'center';
	  controlUI.title = title;
	  controlDiv.appendChild(controlUI);

	  // Set CSS for the control interior.
	  var controlText = document.createElement('div');
	  controlText.setAttribute("id","controlTextId");
	  controlText.style.color = 'rgb(25,25,25)';
	  controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
	  controlText.style.fontSize = '16px';
	  controlText.style.lineHeight = '38px';
	  controlText.style.paddingLeft = '5px';
	  controlText.style.paddingRight = '5px';
	  controlText.innerHTML = title +'-Street View';
	  controlUI.appendChild(controlText);
	  
	  // Setup the click event listeners: simply set the map to Chicago.
	  controlUI.addEventListener('click', function() {
		  $("#map").css("width", "50%");
		  $("#pano").css("width", "50%");
		  $("#controlUiId").css("text-align", "center");
		  map.setZoom(16);
		  var obj = new Object();
		  obj.lat = lat;
		  obj.lng = lng;
		  
		  var fenway = obj;
		  var panorama = new google.maps.StreetViewPanorama(
				  document.getElementById('pano'), {
					  position: fenway,
					  pov: {
			          heading: 34,
			          pitch: 10
			        }
			      });
		  map.setStreetView(panorama);
	  });
}