
<!DOCTYPE html>

<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Business Recommendation</title>

  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>

  

  <!-- nanoScroller -->
  <link rel="stylesheet" type="text/css" href="assets/nanoScroller/nanoscroller.css" />


  <!-- FontAwesome -->
  <link rel="stylesheet" type="text/css" href="assets/font-awesome/css/font-awesome.min.css" />

  <!-- Material Design Icons -->
  <link rel="stylesheet" type="text/css" href="assets/material-design-icons/css/material-design-icons.min.css" />

  <!-- IonIcons -->
  <link rel="stylesheet" type="text/css" href="assets/ionicons/css/ionicons.min.css" />

  <!-- WeatherIcons -->
  <link rel="stylesheet" type="text/css" href="assets/weatherIcons/css/weather-icons.min.css" />
  <!-- Main -->
  <link rel="stylesheet" type="text/css" href="assets/_con/css/_con.min.css" />
      <link rel="stylesheet" type="text/css" href="assets/jquery-clockpicker/jquery-clockpicker.min.css">

</head>

<body class="yay-hide">
  
  <nav class="navbar-top navbar-dark">
    <div class="nav-wrapper">

      <!-- Sidebar toggle -->
      <a href="#" class="yay-toggle">
        <div class="burg1"></div>
        <div class="burg2"></div>
        <div class="burg3"></div>
      </a>
      <!-- Sidebar toggle -->

      <!-- Logo -->
      <a href="#!" class="brand-logo">
        <h2 class="thin center" style="margin:0px;">Business Recommendation</h2>
      </a>
      <!-- /Logo -->

      <!-- Menu -->
      <ul>
        <li><a href="#!" class="search-bar-toggle"><i class="mdi-action-search"></i></a>
        </li>
        <li class="user">
          <a class="dropdown-button" href="#!" data-activates="user-dropdown">
            <img src="assets/_con/images/user.jpg" alt="John Doe" class="circle">Deep Mehta<i class="mdi-navigation-expand-more right"></i>
          </a>

          <ul id="user-dropdown" class="dropdown-content">
            <li><a href="page-profile.html"><i class="fa fa-user"></i> Profile</a>
            </li>
            <li><a href="mail-inbox.html"><i class="fa fa-envelope"></i> Messages <span class="badge new">2</span></a>
            </li>
            
            <li class="divider"></li>
            <li><a href="page-sign-in.html"><i class="fa fa-sign-out"></i> Logout</a>
            </li>
          </ul>
        </li>
      </ul>
      <!-- /Menu -->

    </div>
  </nav>
  <!-- /Top Navbar -->


  
  <aside class="yaybar yay-shrink yay-hide-to-small yay-gestures">

    <div class="top">
      <div>
        <!-- Sidebar toggle -->
        <a href="#" class="yay-toggle">
          <div class="burg1"></div>
          <div class="burg2"></div>
          <div class="burg3"></div>
        </a>
        <!-- Sidebar toggle -->

        <!-- Logo -->
        <a href="#!" class="brand-logo">
          <img src="assets/_con/images/logo-white.png" alt="Con">
        </a>
        <!-- /Logo -->
      </div>
    </div>


    <div class="nano">
      <div class="nano-content">

        <ul>
          
          <li class="label">Menu</li>
          <li>
            <a class="yay-sub-toggle waves-effect waves-blue"><i class="fa fa-dashboard"></i> Dashboards<span class="yay-collapse-icon mdi-navigation-expand-more"></span></a>
            <ul>
              <li>
                <a href="dashboard.html" class="waves-effect waves-blue"> Dashboard</a>
              </li>
              <li>
                <a href="dashboard-v1.html" class="waves-effect waves-blue"> Dashboard v1</a>
              </li>
            </ul>
          </li>

          <li>
            <a href="widgets.html" class="waves-effect waves-blue"><i class="fa fa-magic"></i> Widgets</a>
          </li>

          <li>
            <a href="layouts.html" class="waves-effect waves-blue"><i class="mdi mdi-av-web"></i> Layouts</a>
          </li>
                   
        </ul>

      </div>
    </div>
  </aside>
  <!-- /Yay Sidebar -->


  <!-- Main Content -->
  <section class="content-wrap">


    <!-- Breadcrumb -->
    <div class="page-title">

      <div class="row">
        <div class="col s12 m9 l10">
          <h1>Business Recommendation</h1>

          
        </div>
         </div>

    </div>
    <!-- /Breadcrumb -->


    <br/>

    <div class="row">
    <!-- form -->
    <div class="col s12 l5">
    <div class="card-panel"> 
    <form id="businessFormID">
    <!-- Business Name -->
            <div class="input-field">
              <input name="businessName" id="input-name" type="text" required>
              <label for="input-name">Business Name</label>
            </div>
            <!-- /Business Name -->
            <!-- Business Category  -->
            <select name="businessType" required id="businessType" onchange="getServices();">
              <option value="" disabled selected>Which business you want to open?</option>
              <option value="restaurants">Restaurants</option>
              <option value="pubandbar">Pubs & Bar</option>
              <option value="shoppingmall">Shopping Mall</option>
              <option value="healthcare">Health Care</option>
            </select>
            <!-- /Business Category  -->
    <!-- -->
            <label class="pull-left">Types (2 minimum):</label>
            <p>Services</p>
  <p id="serviceSelect">
    
  </p>
            
    
    <!-- Zip Code -->
            <select name="zipcode" required>
              <option value="" disabled selected>Zip Code</option>
              <option value="95112">95112</option>
              <option value="95113">95113</option>
              <option value="95114">95114</option>
              <option value="95116">95116</option>
            </select>
            <!-- /Zip Code -->
    
            
            
<div class="input-field">
Open Hours Mon-Fri: 
              <input id="timet1"class="clockpicker" style="width:20%;" type="text" value="08:00" data-donetext="OK"> to  
                <input id="timet1"class="clockpicker" style="width:20%;" type="text" value="00:00" data-donetext="OK">
              <label for="input-name">Open Hours Mon-Fri</label>
            </div>
            <!--/ open mon-fri-->
            <!-- open sat sun-->
            <div class="input-field">
Open Hours Sat-Sun: 
              <input id="timet1"class="clockpicker" style="width:20%;" type="text" value="08:10" data-donetext="OK"> to  
                <input id="timet1"class="clockpicker" style="width:20%;" type="text" value="23:10" data-donetext="OK">
              <label for="input-name">Open Hours Sat Sun</label>
            </div>

<!-- /open sat sun-->
<!-- Comments -->
            <div class="input-field">
              <textarea id="textarea-msg" class="materialize-textarea"  data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
              required></textarea>
              <label for="textarea-msg">Comment:</label>
            </div>
            <!-- /Comments -->
            

    <button class="btn" type="submit" name="submitbtn" onclick="businessSubmitForm();">
      Submit <i class="mdi-content-send right"></i>
    </button>


    </form>
    </div>
    </div>
    <div class="col s12 l7">
    <div class="card-panel">
    <h4>Line</h4>
          <div id="rickshawLine" ></div>
    </div>
    <div class="card-panel center-align">
    
        <h4>Pie Chart</h4>
          <div id="flotPieChart" style="height: 400px"></div>
    </div>
    </div>
    <div class="col s12 l7">
    <div class="card-panel center-align">
    <h4>Map</h4>
          <div class="map" id="map2"></div>
    </div>
    </div>
    
    </div>
  </section>
      
  <!-- /Main Content -->

 



 
  


  <footer>&copy; 2015 <strong>Business Recommendation</strong>. All rights reserved.
  </footer>
  

  <!-- jQuery -->
  <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

  <!-- jQuery RAF (improved animation performance) -->
  <script type="text/javascript" src="assets/jqueryRAF/jquery.requestAnimationFrame.min.js"></script>

  <!-- nanoScroller -->
  <script type="text/javascript" src="assets/nanoScroller/jquery.nanoscroller.min.js"></script>

  <!-- Materialize -->
  <script type="text/javascript" src="assets/materialize/js/materialize.min.js"></script>

  <!-- Sortable -->
  <script type="text/javascript" src="assets/sortable/Sortable.min.js"></script>

  <!-- Main -->
  <script type="text/javascript" src="assets/_con/js/_con.min.js"></script>
    <script type="text/javascript" src="assets/jquery-clockpicker/jquery-clockpicker.min.js"></script>
     <!-- Flot -->
  <script type="text/javascript" src="assets/flot/jquery.flot.min.js"></script>
  <script type="text/javascript" src="assets/flot/jquery.flot.time.min.js"></script>
  <script type="text/javascript" src="assets/flot/jquery.flot.pie.min.js"></script>
  <script type="text/javascript" src="assets/flot/jquery.flot.tooltip.min.js"></script>
  <script type="text/javascript" src="assets/flot/jquery.flot.categories.min.js"></script>
    <script type="text/javascript" src="assets/d3/d3.min.js"></script>
    <script type="text/javascript" src="assets/rickshaw/rickshaw.min.js"></script>
      <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="assets/gmaps/gmaps.min.js"></script>
    <script>
	function makestars(y){
		var inty=Math.floor(y);

		switch(inty) {
    case 1:
var htmlstar="<div class='rating'>"+
              "<input id='rating-star-5' name='rating-star' value='5' type='radio'>"+
              "<label for='rating-star-5'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-4' name='rating-star' value='4'  type='radio'>"+
              "<label for='rating-star-4'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-3' name='rating-star' value='3'   type='radio'>"+
              "<label for='rating-star-3'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-2' name='rating-star' value='2' type='radio'>"+
              "<label for='rating-star-2'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-1' name='rating-star' value='1' checked=''  type='radio'>"+
              "<label for='rating-star-1'><i class='ion-star'></i>"+
              "</label>"+
            "</div>";
						return htmlstar;
        break;
    case 2:
var htmlstar="<div class='rating'>"+
              "<input id='rating-star-5' name='rating-star' value='5' type='radio'>"+
              "<label for='rating-star-5'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-4' name='rating-star' value='4'  type='radio'>"+
              "<label for='rating-star-4'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-3' name='rating-star' value='3'   type='radio'>"+
              "<label for='rating-star-3'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-2' name='rating-star' value='2' checked='' type='radio'>"+
              "<label for='rating-star-2'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-1' name='rating-star' value='1'  type='radio'>"+
              "<label for='rating-star-1'><i class='ion-star'></i>"+
              "</label>"+
            "</div>";
						return htmlstar;
        break;
		case 3:
var htmlstar="<div class='rating'>"+
              "<input id='rating-star-5' name='rating-star' value='5' type='radio'>"+
              "<label for='rating-star-5'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-4' name='rating-star' value='4'  type='radio'>"+
              "<label for='rating-star-4'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-3' name='rating-star' value='3' checked=''  type='radio'>"+
              "<label for='rating-star-3'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-2' name='rating-star' value='2' type='radio'>"+
              "<label for='rating-star-2'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-1' name='rating-star' value='1'  type='radio'>"+
              "<label for='rating-star-1'><i class='ion-star'></i>"+
              "</label>"+
            "</div>";
						return htmlstar;
        break;
		case 4:
        var htmlstar="<div class='rating'>"+
              "<input id='rating-star-5' name='rating-star' value='5' type='radio'>"+
              "<label for='rating-star-5'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-4' name='rating-star' value='4' checked='' type='radio'>"+
              "<label for='rating-star-4'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-3' name='rating-star' value='3'   type='radio'>"+
              "<label for='rating-star-3'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-2' name='rating-star' value='2' type='radio'>"+
              "<label for='rating-star-2'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-1' name='rating-star' value='1'  type='radio'>"+
              "<label for='rating-star-1'><i class='ion-star'></i>"+
              "</label>"+
            "</div>";
						return htmlstar;
        break;
		case 5:
       var htmlstar="<div class='rating'>"+
              "<input id='rating-star-5' name='rating-star' value='5' checked='' type='radio'>"+
              "<label for='rating-star-5'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-4' name='rating-star' value='4'  type='radio'>"+
              "<label for='rating-star-4'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-3' name='rating-star' value='3'   type='radio'>"+
              "<label for='rating-star-3'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-2' name='rating-star' value='2' type='radio'>"+
              "<label for='rating-star-2'><i class='ion-star'></i>"+
              "</label>"+
              "<input id='rating-star-1' name='rating-star' value='1'  type='radio'>"+
              "<label for='rating-star-1'><i class='ion-star'></i>"+
              "</label>"+
            "</div>";
			return htmlstar;
        break;
    default:
        return "";
} 
		
		}
	var rickshawLine1 = [ { x: 0, y: 3.5 }, { x: 1, y: 3 }, { x: 2, y: 5.0 }, { x: 3, y: 4.7 }, { x: 4, y: 2 },{ x: 5, y: 3.5 }, { x: 6, y: 3 }, { x: 7, y: 5.0 }, { x: 8, y: 4.7 }, { x: 9, y: 2 },{ x: 10, y: 3.5 }, { x: 11, y: 3 }, { x: 12, y: 5 }, { x: 13, y: 4.7 }, { x: 14, y: 5.0 } ];
    
	(function() {
      var element = $("#rickshawLine");
      var graph = new Rickshaw.Graph( {
        element: element[0],
        renderer: 'line',
        stroke: true,
        series: [ {
          data: rickshawLine1,
          color: '#673ab7',
          name: 'Business Rating'
        },{
			data:[{ x: 0, y: 5.1 }],
			color:'#ffffff',
			
			}]
      } );
      graph.render();
    
      var hoverDetail = new Rickshaw.Graph.HoverDetail({
        graph: graph,
        xFormatter: function(x) { return "" },
        yFormatter: function(y) { var stars=makestars(y)
		return stars; }
      });
    
      // responsive
      $(window).on('resize', function() {
        graph.configure({
          width: element.width()
        });
        graph.render();
      });
    }());
    
    
    (function() {
      var chart = $("#flotPieChart");
      /*var data = [
          { label: "5",  data: 19.5, color: "#90a4ae"},
          { label: "4",  data: 4.5, color: "#7986cb"},
          { label: "3",  data: 36.6, color: "#9575cd"},
          { label: "2",  data: 2.3, color: "#4db6ac"},
          { label: "1",  data: 36.3, color: "#64b5f6"}
      ];*/
      var data=[{"data":0,"color":"#90a4ae","label":1.0},{"data":0,"color":"#7986cb","label":2.0},{"data":0,"color":"#9575cd","label":4.0},{"data":0,"color":"#4db6ac","label":4.5},{"data":0,"color":"#64b5f6","label":2.5},{"data":0,"color":"#CC3399","label":5.0},{"data":0,"color":"#990099","label":1.5},{"data":0,"color":"#FF0066","label":3.0},{"data":0,"color":"#FFFF99","label":3.5}];
      var options = {
        series: {
          pie: {
            innerRadius: 0.5,
            show: true
          }
        },
        grid: {
          hoverable: true
        },
        legend: {
          backgroundOpacity: 0,
          labelBoxBorderColor: "none"
        },
        tooltip: true,
        tooltipOpts: {
          content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
          shifts: {
            x: 20,
            y: 0
          },
          defaultTheme: false
        }
      };
    
      function initFlot() {
        $.plot(chart, data, options);
        chart.find('.legend table').css('width', 'auto')
             .find('td').css('padding', 5);
      }
      initFlot();
      $(window).on('resize', initFlot);
    
    }());
	
	 /*
     * MAP 2
     */
    (function($) {
      "use strict";
    
      // init map
      var map = new GMaps({
          div: '#map2',
          lat: 34.9365255,
          lng: -85.4373943,
          zoom: 4
      });
    
      // add New York marker
      map.addMarker({
        lat: 40.706086,
        lng: -73.996864,
        title: 'New York',
        infoWindow: {
          content: '<b>New York</b> is a state in the Northeastern and Mid-Atlantic regions of the <i>United States</i>.'
        }
      });
    
      // add Chicago marker
      map.addMarker({
        lat: 41.8337329,
        lng: -87.7321554,
        title: 'Chicago',
        infoWindow: {
          content: '<b>Chicago</b> is the third most populous city in the <i>United States</i>, after <i>New York City</i> and <i>Los Angeles</i>.'
        }
      });
    
      // add Miami marker
      map.addMarker({
        lat: 25.782324,
        lng: -80.2310801,
        title: 'Miami',
        infoWindow: {
          content: '<b>Miami</b> is a city located on the Atlantic coast in southeastern <i>Florida</i> and the county seat of Miami-Dade County.'
        }
      });
    
      // add Dallas marker
      map.addMarker({
        lat: 32.8206645,
        lng: -96.7313396,
        title: 'Dallas',
        infoWindow: {
          content: '<b>Dallas</b> is a major city in Texas and is the largest urban center of the fourth most populous metropolitan area in the <i>United States</i>.'
        }
      });
    
    }(jQuery));
    
    
	 function businessSubmitForm(){
		 var data=$("#businessFormID").serializeArray();
			//alert(data);
			var o = {};
			  // o["email_id"].push(query[1]);
			  // var a = this.serializeArray();
			   $.each(data, function() {
			       if (o[this.name] !== undefined) {
			           if (!o[this.name].push) {
			               o[this.name] = [o[this.name]];
			           }
			           o[this.name].push(this.value || '');
			       } else {
			           o[this.name] = this.value || '';
			       }
			   });
			   alert(JSON.stringify(o));
	 }
	 
	 
	 
   function getServices(){
	   var selectedopt=$("#businessType").val();
	   switch(selectedopt) {
	    case "restaurants":
	var htmlstar='<input name="services" type="checkbox" id="check-take" value="takeout" />'+
	'<label for="check-take">Take out</label>'+
	'<input name="services" type="checkbox" id="check-wifi" value="wifi" />'+
	'<label for="check-wifi">wifi</label>'+
	'<input name="services" type="checkbox" id="check-alcohol" value="alcohol" />'+
	'<label for="check-alcohol">alcohol</label>'+
	'<input name="services" type="checkbox" id="check-parking" value="parking" />'+
	'<label for="check-parking">parking</label>'+
	'<input name="services" type="checkbox" id="check-dinner" value="dinner" />'+
	'<label for="check-dinner">dinner</label>';
				$("#serviceSelect").empty();
				$("#serviceSelect").append(htmlstar);
	        break;
	    case "pubandbar":
	    	var htmlstar='<input name="services" type="checkbox" id="check-alcohol1" value="alcohol" />'+
	    	'<label for="check-alcohol1">alcohol</label>'+
	    	'<input name="services" type="checkbox" id="check-dancing" value="dancing" />'+
	    	'<label for="check-dancing">Dancing Floor</label>'+
	    	'<input name="services" type="checkbox" id="check-noiselevel" value="noiselevel" />'+
	    	'<label for="check-noiselevel">noise level</label>';
	    				$("#serviceSelect").empty();
	    				$("#serviceSelect").append(htmlstar);
	    	        break;
	   }
   }
    
    </script>
</body>
</html>