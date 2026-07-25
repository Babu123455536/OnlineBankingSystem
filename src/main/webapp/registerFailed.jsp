<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Registration Failed</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-danger-subtle">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow-lg border-danger">

                <div class="card-header bg-danger text-white text-center">

                    <h3>
                        <i class="bi bi-x-circle-fill"></i>
                        Registration Failed
                    </h3>

                </div>

                <div class="card-body text-center">

                    <i class="bi bi-exclamation-triangle-fill text-danger"
                       style="font-size:70px;"></i>

                    <h4 class="mt-3 text-danger">
                        Registration Failed!
                    </h4>

                    <p class="text-muted">
                        Unable to create your account.
                        <br>
                        Please check your details and try again.
                    </p>

                    <a href="register.jsp"
                       class="btn btn-danger w-100 mt-3">

                        <i class="bi bi-arrow-counterclockwise"></i>
                        Try Again

                    </a>

                    <a href="login.jsp"
                       class="btn btn-outline-primary w-100 mt-2">

                        <i class="bi bi-box-arrow-in-right"></i>
                        Go to Login

                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>