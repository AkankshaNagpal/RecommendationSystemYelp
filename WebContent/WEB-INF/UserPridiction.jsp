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
            <img src="assets/_con/images/user.jpg" alt="UserImg" class="circle"><span id="topUserName">Deep Mehta</span><i class="mdi-navigation-expand-more right"></i>
          </a>

          <ul id="user-dropdown" class="dropdown-content">
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
                <a href="#" class="waves-effect waves-blue"> Dashboard</a>
              </li>
              <li>
                <a href="#" class="waves-effect waves-blue"> Dashboard v1</a>
              </li>
            </ul>
          </li>

          <li>
            <a href="#" class="waves-effect waves-blue"><i class="fa fa-magic"></i> Widgets</a>
          </li>

          <li>
            <a href="#" class="waves-effect waves-blue"><i class="mdi mdi-av-web"></i> Layouts</a>
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
                <img src="assets/_con/images/user2.jpg" alt="Felecia Castro" class="circle photo">
                <div class="title" ><h4 id="userName">Random Girl</h4></div>
                <div class="label" ><h5>Yelping Since:</h5><h5 id="Yelping">Random Manager</h5></div>
                

    <div class="card-panel stats-card blue blue-text text-lighten-5">
      <i class="ion-fireball red-text"></i>
      <span class="count" id="fanCount">145</span>
      <div class="name">Fans</div>
    </div>

                
                
              </div>
    </div>
    <div class="card-panel"> 
    <form >
    <!-- Business Name -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Name</label>
            </div>
            <!-- /Business Name -->
    <!-- Business Category -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Category</label>
            </div>
            <!-- /Business Category -->
    <!-- Location -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Location</label>
            </div>
            <!-- /Location -->
    <!-- Zip Code -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Zip Code</label>
            </div>
            <!-- /Zip Code -->
    <!-- Heard -->
            <select name="heard" required>
              <option value="" disabled selected>Which Services Do You Provide</option>
              <option value="press">Food</option>
              <option value="internet">Internet</option>
              <option value="mouth">Mobile</option>
              <option value="other">Other...</option>
            </select>
            <!-- /Heard -->
            
            
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
              <textarea id="textarea-msg" class="materialize-textarea" name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
              required></textarea>
              <label for="textarea-msg">Comment:</label>
            </div>
            <!-- /Comments -->
            

    <button class="btn" type="submit" name="action">
      Submit <i class="mdi-content-send right"></i>
    </button>


    </form>
    </div>
    </div>
    <!-- Center Main -->
    <div class="col s12 l6">
    <div class="card-panel center-align">
    

    <div class="card">
      <div class="title blue white-text">
        <h5>Business Name</h5>
      </div>
      <div class="content left-align">Business Data
      <p>Place:</p>
      <p>Type:</p></div>
    </div>
    <div class="card">
      <div class="title blue white-text">
        <h5>Business Name</h5>
      </div>
      <div class="content left-align">Business Data
      <p>Place:</p>
      <p>Type:</p></div>
    </div>
   
    <div class="card">
      <div class="title blue white-text">
        <h5>Business Name</h5>
      </div>
      <div class="content left-align">Business Data
      <p>Place:</p>
      <p>Type:</p></div>
    </div>
   
   

    </div>
    </div>
    <!-- Right Main Results -->
    <div class="col s12 l3">
    <div class="card-panel"> 
    <form >
    <!-- Business Name -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Name</label>
            </div>
            <!-- /Business Name -->
    <!-- Business Category -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Category</label>
            </div>
            <!-- /Business Category -->
    <!-- Location -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Location</label>
            </div>
            <!-- /Location -->
    <!-- Zip Code -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Zip Code</label>
            </div>
            <!-- /Zip Code -->
    <!-- Heard -->
            <select name="heard" required>
              <option value="" disabled selected>Which Services Do You Provide</option>
              <option value="press">Food</option>
              <option value="internet">Internet</option>
              <option value="mouth">Mobile</option>
              <option value="other">Other...</option>
            </select>
            <!-- /Heard -->
            
            
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
              <textarea id="textarea-msg" class="materialize-textarea" name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
              required></textarea>
              <label for="textarea-msg">Comment:</label>
            </div>
            <!-- /Comments -->
            

    <button class="btn" type="submit" name="action">
      Submit <i class="mdi-content-send right"></i>
    </button>


    </form>
    </div>
    <div class="card-panel"> 
    <form >
    <!-- Business Name -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Name</label>
            </div>
            <!-- /Business Name -->
    <!-- Business Category -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Business Category</label>
            </div>
            <!-- /Business Category -->
    <!-- Location -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Location</label>
            </div>
            <!-- /Location -->
    <!-- Zip Code -->
            <div class="input-field">
              <input id="input-name" type="text" required>
              <label for="input-name">Zip Code</label>
            </div>
            <!-- /Zip Code -->
    <!-- Heard -->
            <select name="heard" required>
              <option value="" disabled selected>Which Services Do You Provide</option>
              <option value="press">Food</option>
              <option value="internet">Internet</option>
              <option value="mouth">Mobile</option>
              <option value="other">Other...</option>
            </select>
            <!-- /Heard -->
            
            
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
              <textarea id="textarea-msg" class="materialize-textarea" name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
              required></textarea>
              <label for="textarea-msg">Comment:</label>
            </div>
            <!-- /Comments -->
            

    <button class="btn" type="submit" name="action">
      Submit <i class="mdi-content-send right"></i>
    </button>


    </form>
    </div>
    </div>
    
    </div>
  </section>
      
  <!-- /Main Content -->

  <!-- Search Bar -->
  <div class="search-bar">
    <div class="layer-overlay"></div>
    <div class="layer-content">
      <form action="#!">
        <!-- Header -->
        <a class="search-bar-toggle grey-text text-darken-2" href="#!"><i class="mdi-navigation-close"></i></a>

        <!-- Search Input -->
        <div class="input-field">
          <i class="mdi-action-search prefix"></i>
          <input type="text" name="con-search" placeholder="Search...">
        </div>

        <!-- Search Results -->
        <div class="search-results">

          <div class="row">
            <div class="col s12 l4">
              <h4>Users</h4>

              <div class="each-result">
                <img src="assets/_con/images/user2.jpg" alt="Felecia Castro" class="circle photo">
                <div class="title">Felecia Castro</div>
                <div class="label">Content Manager</div>
              </div>

              <div class="each-result">
                <img src="assets/_con/images/user3.jpg" alt="Max Brooks" class="circle photo">
                <div class="title">Max Brooks</div>
                <div class="label">Programmer</div>
              </div>

              <div class="each-result">
                <img src="assets/_con/images/user4.jpg" alt="Patsy Griffin" class="circle photo">
                <div class="title">Patsy Griffin</div>
                <div class="label">Support</div>
              </div>

              <div class="each-result">
                <img src="assets/_con/images/user6.jpg" alt="Vernon Garrett" class="circle photo">
                <div class="title">Vernon Garrett</div>
                <div class="label">Photographer</div>
              </div>
            </div>
            <div class="col s12 l4">
              <h4>Articles</h4>

              <div class="each-result">
                <div class="icon circle blue white-text">MD</div>
                <div class="title">Material Design</div>
                <div class="label nowrap">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi consequatur debitis veritatis dolorum, enim libero!</div>
              </div>

              <div class="each-result">
                <div class="icon circle teal white-text">
                  <i class="fa fa-dashboard"></i>
                </div>
                <div class="title">Admin Dashboard</div>
                <div class="label nowrap">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi consequatur debitis veritatis dolorum, enim libero!</div>
              </div>

              <div class="each-result">
                <div class="icon circle orange white-text">RD</div>
                <div class="title">Responsive Design</div>
                <div class="label nowrap">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi consequatur debitis veritatis dolorum, enim libero!</div>
              </div>

              <div class="each-result">
                <div class="icon circle red white-text">
                  <i class="fa fa-tablet"></i>
                </div>
                <div class="title">Mobile First</div>
                <div class="label nowrap">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi consequatur debitis veritatis dolorum, enim libero!</div>
              </div>
            </div>
            <div class="col s12 l4">
              <h4>Posts</h4>

              <div class="no-result">No results were found ;(</div>
            </div>
          </div>

        </div>

      </form>
    </div>
  </div>
  <!-- /Search Bar -->



 
  


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
      <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="assets/gmaps/gmaps.min.js"></script>
    <script>
    $( document ).ready(function() {
    	var username=localStorage.userName;
    	$.ajax({
		     type: "GET",
		     contentType: 'application/json',
		     url: "userProfile/"+username,
		     dataType: 'json',
		     data: "",
		     async: false,
		     crossDomain: true,
		     success: function(data) {
		         //alert('success-'+JSON.stringify(data));
		         
		         $('#topUserName').text(data.userProfile.useremail);
		         $('#userName').text(data.userProfile.useremail);
		         $('#Yelping').text(data.userProfile.yelpingSince);
		         $('#fanCount').text(data.userProfile.fans);
		         
		     },
		     error: function(response, text, err) {
		         alert("r "+JSON.stringify(response)+" text -"+text+" error"+err);
		     }
		 });
    }); 
   
    </script>
</body>
</html>