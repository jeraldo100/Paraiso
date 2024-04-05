<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 container	justify-content-center card">
                    <c:if test="${message != null}">
                    <div class="message">${message}</div>
                    </c:if>
                    <h1>Register New User</h1>
                    <div class="card-body">
                        <form 
                        action="${pageContext.request.contextPath}/user/registration" 
                        method="post"
                        role="form"
                        >
                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" name="username" id="username" placeholder="Enter username" value="${user.username}" /> </div>

                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" name="password" id="password" placeholder="Enter password" />
                            </div>

                            <div class="form-group">
                                <label>Account Type:</label>
                                <input type="text" name="accountType" id="accountType"
                                    placeholder="Enter Account Type" value="${user.accountType}" /> </div>

                            <div class="form-group">
                                <label>First Name:</label>
                                <input type="text" name="firstName" id="firstName" placeholder="Enter First Name" value="${user.firstName}" /> </div>

                            <div class="form-group">
                                <label>Last Name:</label>
                                <input type="text" name="lastName" id="lastName" placeholder="Enter Last Name" value="${user.lastName}" /> </div>

                            <div class="form-group">
                                <label>Date of Birth:</label>
                                <input type="date" name="dateOfBirth" id="dateOfBirth" />
                            </div>

                            <div class="form-group">
                                <label>Address:</label>
                                <input type="text" name="address" id="address" placeholder="Enter Address" value="${user.address}" /> </div>

                            <div class="form-group">
                                <label>Phone:</label>
                                <input type="number" name="phone" id="phone" placeholder="Enter Phone Number" value="${user.phone}" /> </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input type="email" name="email" id="email" placeholder="Enter Email" value="${user.email}" /> </div>
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
