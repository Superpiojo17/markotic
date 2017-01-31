<!DOCTYPE HTML>
<!--
	Retrospect by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Contact Us</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
</head>
<style> 
input[type=text2] {
    width: 130px;
    float: right;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: #1e2832;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text2]:focus {
    width:30%;
}
</style>
<body>

	<!-- Header -->
	<header id="header" class="skel-layers-fixed">
		<h1>
			<a href="index.html">Rate & Review</a>
		</h1>
		<a href="#nav">Menu</a>
		<form>
  <input type="text2" name="search" placeholder="Search..">
</form>
	</header>

	<!-- Nav -->
	<nav id="nav">
		<ul class="links">
			<li><a href="index.html">Home</a></li>
			<li><a href="generic.html">Generic</a></li>
			<li><a href="ServLogin">Login</a></li>
		</ul>
	</nav>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="container">

			<!-- Form -->
			<section>
				<h3>Contact Us</h3>
				<form method="post" action="#">
					<div class="row uniform 50%">
						<div class="6u 12u$(xsmall)">
							<input type="text" name="name" id="name" value=""
								placeholder="Name" />
						</div>
						
						
						<div class="6u$ 12u$(xsmall)">
							<input type="email" name="email" id="email" value=""
								placeholder="Email" />
						</div>
						<div class="12u$">
							<div class="select-wrapper">
								<select name="category" id="category">
									<option value="">- Category -</option>
									<option value="1">Manufacturing</option>
									<option value="1">Shipping</option>
									<option value="1">Administration</option>
									<option value="1">Human Resources</option>
								</select>
							</div>
						</div>
						<div class="4u 12u$(xsmall)">
							<input type="radio" id="priority-low" name="priority" checked>
							<label for="priority-low">Low Priority</label>
						</div>
						<div class="4u 12u$(xsmall)">
							<input type="radio" id="priority-normal" name="priority">
							<label for="priority-normal">Normal Priority</label>
						</div>
						<div class="4u$ 12u$(xsmall)">
							<input type="radio" id="priority-high" name="priority"> <label
								for="priority-high">High Priority</label>
						</div>
						
						<div class="6u$ 12u$(small)">
							<input type="checkbox" id="human" name="human" checked> <label
								for="human">I am a human and not a robot</label>
						</div>
						<div class="12u$">
							<textarea name="message" id="message"
								placeholder="Enter your message" rows="6"></textarea>
						</div>
						<div class="12u$">
							<ul class="actions">
								<li><input type="submit" value="Send Message"
									class="special" /></li>
								<li><input type="reset" value="Reset" /></li>
							</ul>
						</div>
					</div>
				</form>
			</section>



		</div>
	</section>

	<!-- Footer -->
	<footer id="footer">
		<div class="inner">
			<ul class="icons">
				<li><a href="#" class="icon fa-facebook"> <span
						class="label">Facebook</span>
				</a></li>
				<li><a href="#" class="icon fa-twitter"> <span
						class="label">Twitter</span>
				</a></li>
				<li><a href="#" class="icon fa-instagram"> <span
						class="label">Instagram</span>
				</a></li>
				<li><a href="#" class="icon fa-linkedin"> <span
						class="label">LinkedIn</span>
				</a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Untitled.</li>
				<li>Images: <a href="http://unsplash.com">Unsplash</a>.
				</li>
				<li>Design: <a href="http://templated.co">TEMPLATED</a>.
				</li>
			</ul>
		</div>
	</footer>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>