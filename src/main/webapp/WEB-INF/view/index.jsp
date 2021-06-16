<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap and bootstrap icons -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">

    <link rel="stylesheet" href="css/main.css">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@400;700&display=swap"
        rel="stylesheet">



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>


    <title>RIMS</title>
</head>

<body>
    <div class="container-fluid">
        <section class="title">
            <!-- NAVIGATION BAR -->
            <nav class="navbar navbar-expand-lg navbar-dark ">
                <a class="navbar-brand" href="/">RIMS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
                    aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarToggler">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#feature">Features</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#pricing">Pricing</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#footer">Contact</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </section>
        <!--HERO -->
        <section class="hero">
            <div class="row">
                <div class="col-lg-6">
                    <h1>Take control of your Inventory</h1>
                    <article>
                        <p>Simple & Intuitive design. Efficient & Persistent Storage </p>
                        <p> Are you ready for the ultimate tool to manage your inventory?</p>
                    </article>
                </div>
                <div class="col-lg-6 hero-button-container">
                    <a href="/login" role="button" class="btn btn-outline-light btn-lg hero-button"><i
                            class="bi bi-door-open-fill"></i>Login</a>
                    <a href="/register" role="button"  class="btn btn-dark btn-lg hero-button"><i
                            class="bi bi-person-plus" ></i>Register</a>
                </div>
            </div>
        </section>
    </div>
    <!-- Features -->


    <section id="feature">
        <div class="row">
            <div class="feature-box col-lg-4">
                <h3><i class="bi bi-emoji-laughing"></i></h3>
                <h3>Easy to Use</h3>
                <p>Simple to add and update inventory and menu items</p>
            </div>
            <div class="feature-box col-lg-4">
                <h3><i class="bi bi-bookmark-check-fill"></i></h3>
                <h3>Robust Tracking</h3>
                <p>Keep tabs on all of your items purchased and sold</p>
            </div>
            <div class="feature-box col-lg-4">
                <h3><i class="bi bi-alarm-fill"></i></h3>
                <h3>Stay Informed</h3>
                <p>Set individual re-order notifications on any item </p>
            </div>
        </div>
    </section>

    <!-- Pricing -->
    <section id="pricing">
        <h1>Pricing models to choose from</h1>
        <p>Multiple plans to fit your business needs</p>
        <div class="row">
            <div class="pricing-card col-lg-4 col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2>Free</h2>
                    </div>
                    <div class="card-body">
                        <p>$0 / mo </p>
                        <p>One User</p>
                        <p>1 GB storage</p>
                        <p>limited features</p>
                        <button class="btn btn-lg btn-block btn-outline-light cta-button" type="button">Sign
                            Up Free</button>
                    </div>
                </div>
            </div>
            <div class="pricing-card col-lg-4  col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2>Enterprise</h2>
                    </div>
                    <div class="card-body">
                        <p>$5 / mo </p>
                        <p>Three Users</p>
                        <p>10 GB storage</p>
                        <p>email support</p>
                        <button class="btn btn-lg btn-block btn-dark" type="button">Join Now</button>
                    </div>
                </div>
            </div>
            <div class="pricing-card col-lg-4">
                <div class="card">
                    <div class="card-header">
                        <h2>Ultimate</h2>
                    </div>
                    <div class="card-body">
                        <p>$20 / mo </p>
                        <p>Unlimited Users</p>
                        <p>100 GB storage</p>
                        <p>phone and email support</p>
                        <button class="btn btn-lg btn-block btn-dark" type="button">Get Started</button>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Call To Action -->
    <section id="cta">
        <h2>Get Organized. Get Notified. Get Started Today</h2>
        <a href="/login" role="button"  class="btn btn-outline-light btn-lg hero-button cta-button"><i class="bi bi-door-open-fill"></i>Login</a>
        <a href="/register" role="button"  class="btn btn-dark btn-lg hero-button"><i class="bi bi-person-plus"></i>Register</a>
    </section>

    <!-- Footer -->
    <footer id="footer">
        <i class="social-icon bi bi-twitter"></i>
        <i class="social-icon bi bi-facebook"></i>
        <i class="social-icon bi bi-linkedin"></i>
        <i class="social-icon bi bi-envelope"></i>
        <p><span>&#169;</span> Copyright 2021 LumpysLounge</p>
    </footer>






</body>

</html>