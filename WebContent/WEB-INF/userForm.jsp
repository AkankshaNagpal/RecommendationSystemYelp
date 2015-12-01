
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
          <h1>New User</h1>
          
        </div>
         </div>

    </div>
    <!-- /Breadcrumb -->

<div class="row">
<div class="col l3"></div>
<div class="card-panel col l6"> 
    <form id="userformsub" onsubmit="return false;" name="userformsub">
	<!-- Location -->
    <select name="city" id="city" >
              <option value="" disabled selected>Which City?</option>
              <option value="Pittsburgh">Pittsburgh</option>
              <option value="Charlotte">Charlotte</option>
              <option value="Anthem">Anthem</option>
              <option value="Phoenix">Phoenix</option>
              <option value="Edinburgh">Edinburgh</option>
              <option value="Las Vegas">Las Vegas</option>
              <option value="Tempe">Tempe</option>
              <option value="Madison">Madison</option>
              
              
            </select>
    <!-- /location -->
    <!-- Gender -->
  <p>
    <input name="gender" type="radio" id="radio-gender-1" value="male" />
    <label for="radio-gender-1">Male</label>
    <input name="gender" type="radio" id="radio-gender-2" value="female"/>
    <label for="radio-gender-2">Female</label>
  </p>
  <!-- /Gender -->
    <!-- Age -->
            <div class="input-field">
              <input id="age" type="text" name="age">
              <label for="input-name">Age</label>
            </div>
            <!-- /Age -->
    <!-- Zip Code -->
            <div class="input-field">
              <input id="input-name" type="text" name="zipcode">
              <label for="input-name">Zip Code</label>
            </div>
            <!-- /Zip Code -->
              <!-- Hobbies -->
  
  <select name="preferences" id="preferences" >
              <option value="" disabled selected>Select Preferences</option>
              <option value="Restaurants">Restaurants</option>
              <option value="Italian">Italian</option>
              <option value="Food">Food</option>
              <option value="Shopping">Shopping</option>
              <option value="Bakery">Bakery</option>
              
              
              
            </select>
 
  <!-- /Hobbies -->
    
    <button class="btn"  onclick="signUP();">
      Submit <i class="mdi-content-send right"></i>
    </button>


    </form>

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

</body>
<script>
function signUP(){
	var city=$("#city").val();
	var pref=$("#preferences").val();
	localStorage.city=city;
	localStorage.pref=pref;
	  // alert("City "+localStorage.city+" pref-"+localStorage.pref);
	   window.location.href="UserDashboard";
	   
	  /*$.ajax({
		     type: "POST",
		     contentType: 'application/json',
		     url: "newUserForm",
		     dataType: 'json',
		     data: JSON.stringify(o),
		     async: false,
		     crossDomain: true,
		     success: function(data) {
		         alert('success-'+JSON.stringify(data));
		         window.location.href="UserDashboard";
		         
		     },
		     error: function(response, text, err) {
		         alert("r "+JSON.stringify(response)+" text -"+text+" error"+err);
		     }
		 });*/
	   
	
}
</script>
</html>