<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Registration Module</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 container	justify-content-center card">
                    <h1>Register New User</h1>
                    <div class="card-body">
                        <form action="adduser/save" method="post">
                            <div class="form-group">
                                <label>User ID:</label>
                                <input type="number" name="userid" id="userid" placeholder="Enter User ID" />
                            </div>

                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" name="username" id="username" placeholder="Enter username" />
                            </div>

                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" name="password" id="password" placeholder="Enter password" />
                            </div>

                            <div class="form-group">
                                <label>Account Type:</label>
                                <input type="text" name="account_type" id="account_type"
                                    placeholder="Enter Account Type" />
                            </div>

                            <div class="form-group">
                                <label>First Name:</label>
                                <input type="text" name="first_name" id="first_name" placeholder="Enter First Name" />
                            </div>

                            <div class="form-group">
                                <label>Last Name:</label>
                                <input type="text" name="last_name" id="last_name" placeholder="Enter Last Name" />
                            </div>

                            <div class="form-group">
                                <label>Date of Birth:</label>
                                <input type="date" name="date_of_birth" id="date_of_birth" />
                            </div>

                            <div class="form-group">
                                <label>Address:</label>
                                <input type="text" name="address" id="address" placeholder="Enter Address" />
                            </div>

                            <div class="form-group">
                                <label>Phone:</label>
                                <input type="number" name="phone" id="phone" placeholder="Enter Phone Number" />
                            </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input type="email" name="email" id="email" placeholder="Enter Email" />
                            </div>
                            <div class="box-footer">
                                <input type="submit" class="btn btn-primary" value="Submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>