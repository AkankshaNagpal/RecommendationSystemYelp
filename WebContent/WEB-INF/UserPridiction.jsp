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
          <a class="dropdown-button" href="#!" data-activates="user-dropdown" >
            <img src="assets/_con/images/img30.png" alt="UserImg" class="circle"><span id="topUserName"></span><i class="mdi-navigation-expand-more right"></i>
          </a>

          <ul id="user-dropdown" class="dropdown-content">
            <li class="divider"></li>
            <li><a onclick="LogOut();"><i class="fa fa-sign-out"></i> Logout</a>
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
                <a href="businessDashboard" class="waves-effect waves-blue"> Business Recommendation</a>
              </li>
              
            </ul>
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
          <h1>User Recommendation</h1>

          
        </div>
         </div>

    </div>
    <!-- /Breadcrumb -->



    <br/>
    
    <div class="row">
    <!-- form -->
    <!-- Left Main Profile -->
    <div class="col s12 l3">
    <div class="card-panel"> 
    <div class="each-result">
                <img src="assets/_con/images/img.png" alt="Felecia Castro" class="circle photo">
                <div class="title" ><h4 id="userName"></h4></div>
                <div class="label" ><h5>Yelping Since:</h5><h5 id="Yelping"></h5></div>
                

    <div class="card-panel stats-card blue blue-text text-lighten-5">
      <i class="ion-fireball red-text"></i>
      <span class="count" id="fanCount">0</span>
      <div class="name">Fans</div>
    </div>

                
                
              </div>
    </div>
    
    </div>
    <!-- Center Main -->
    <div class="col s12 l9">
    <div class="card-panel center-align" id="businessData">
    </div>
    </div>
    <!-- Right Main Results -->
    
    
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
   
    <script>
    function LogOut(){
    	//alert("called");
    	localStorage.userName=null;
   	 localStorage.isNewUser=null;
    	window.location.href="RecommendationSystemYelp";
    }
    $( document ).ready(function() {
    	var username=localStorage.userName;
    	var URL;
    	if(localStorage.isNewUser=="true"){
    		URL="newuserProfile/"+username+"/"+localStorage.city+"/"+localStorage.pref;
    	}else{
    		URL="userProfile/"+username
    	}
    	$.ajax({
		     type: "GET",
		     contentType: 'application/json',
		     url: URL,
		     dataType: 'json',
		     data: "",
		     async: false,
		     crossDomain: true,
		     success: function(data) {
		        //alert('success-'+JSON.stringify(data));
		         
		         $('#topUserName').text(data.user.email);
		         $('#userName').text(data.user.email);
		         $('#Yelping').text(data.user.yelping_since);
		         $('#fanCount').text(data.user.fans);
		         var length=data.user.recommdationList.length;
		         //alert(length);
		         $("#businessData").empty();
		         var businesshtml="";
		         for(var i=0;i<length;i++){
		        	 
		        		 businesshtml+='<div class="card">'+
		        		 '<div class="title blue white-text">'+
		        		 '<h5>'+data.user.recommdationList[i].name+'</h5>'+
		        		 '</div>'+
		        		 '<div class="content left-align">'+
		        		 '<p>Address:'+data.user.recommdationList[i].address+'</p>'+
		        		 '<p>User Ratings:'+data.user.recommdationList[i].rating+'</p>'+
		        		 '<p>Stars:'+data.user.recommdationList[i].stars+'</p></div>'+
		        		 '</div>';	 
		        	 
		        	
		         }
		         
		         $("#businessData").html(businesshtml);
		     
		         
		         
		     },
		     error: function(response, text, err) {
		         alert("r "+JSON.stringify(response)+" text -"+text+" error"+err);
		     }
		 });
    }); 
   
    </script>
</body>
</html>