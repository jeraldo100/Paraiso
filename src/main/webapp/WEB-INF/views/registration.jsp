<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 container	justify-content-center card">
                    <div class="message" th:if="{message != null">
                    [${message}]
                    </div>
                    <h1>Register New User</h1>
                    <div class="card-body">
                        <form 
                        th:action="@{/registration}" 
                        method="post"
                        role="form"
                        th:object="${user}"
                        
                        >
                            <div class="form-group">
                                <label>Username:</label>
                                <input th:field="*{username}" type="text" name="username" id="username" placeholder="Enter username" />
                            </div>

                            <div class="form-group">
                                <label>Password:</label>
                                <input th:field="*{password}" type="password" name="password" id="password" placeholder="Enter password" />
                            </div>

                            <div class="form-group">
                                <label>Account Type:</label>
                                <input th:field="*{accountType}" type="text" name="accountType" id="accountType"
                                    placeholder="Enter Account Type" />
                            </div>

                            <div class="form-group">
                                <label>First Name:</label>
                                <input th:field="*{firstName}" type="text" name="firstName" id="firstName" placeholder="Enter First Name" />
                            </div>

                            <div class="form-group">
                                <label>Last Name:</label>
                                <input th:field="*{lastName} type="text" name="lastName" id="lastName" placeholder="Enter Last Name" />
                            </div>

                            <div class="form-group">
                                <label>Date of Birth:</label>
                                <input type="date" name="dateOfBirth" id="dateOfBirth" />
                            </div>

                            <div class="form-group">
                                <label>Address:</label>
                                <input th:field="*{address} type="text" name="address" id="address" placeholder="Enter Address" />
                            </div>

                            <div class="form-group">
                                <label>Phone:</label>
                                <input th:field="*{phone} type="number" name="phone" id="phone" placeholder="Enter Phone Number" />
                            </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input th:field="*{email} type="email" name="email" id="email" placeholder="Enter Email" />
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