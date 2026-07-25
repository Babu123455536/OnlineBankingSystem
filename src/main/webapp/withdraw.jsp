<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Money</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header bg-danger text-white">
                    <h3>Withdraw Money</h3>
                </div>

                <div class="card-body">

                    <form action="WithdrawServlet" method="post">

                        <div class="mb-3">
                            <label class="form-label">Account ID</label>
                            <input type="number"
                                   name="accountId"
                                   class="form-control"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Amount</label>
                            <input type="number"
                                   step="0.01"
                                   name="amount"
                                   class="form-control"
                                   required>
                        </div>

                        <button type="submit" class="btn btn-danger">
                            Withdraw
                        </button>

                        <a href="dashboard.jsp" class="btn btn-secondary">
                            Back
                        </a>

                    </form>

                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>