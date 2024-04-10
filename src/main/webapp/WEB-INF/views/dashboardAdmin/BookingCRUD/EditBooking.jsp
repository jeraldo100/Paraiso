<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paraiso Hotel | Add New Booking</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<link rel="stylesheet" href="/styles/dashboardAdmin/CRUD.css">
</head>
<body>
<div class="container-fluid">
  <div class="row justify-content-center vertical-center">
    <div class="col-lg-6 col-md-6">
      <div class="card">
        <h1 class="text-center p-3">Edit Booking</h1>
        <div class="card-body">
          <form action="/admin/updateBooking/${booking.booking_id }" method="post">
            <div class="form-group">
              <label>User ID :</label>
              <input type="number" name="user_id" id="user_id" placeholder="Enter User ID" class="form-control" />
            </div>
            <div class="form-group">
              <label>Check In :</label>
              <input type="date" name="checkin_date" id="checkin_date" placeholder="Enter Check In date" class="form-control" />
            </div>
            <div class="form-group">
              <label>Check Out :</label>
              <input type="date" name="checkout_date" id="checkout_date" placeholder="Enter Check Out date" class="form-control" />
            </div>
            <div class="form-group">
              <label>Total Price :</label>
              <input type="number" name="total_price" id="total_price" placeholder="Enter Total price" class="form-control" />
            </div>
             <div class="form-group">
              <label>Arrival Time :</label>
              <input type="text" name="arrival_time" id="arrival_time" placeholder="Enter Arrival Time" class="form-control" />
            </div>
            <div class="form-group">
              <label>Adults :</label>
              <input type="number" name="adults" id="adults" placeholder="Enter Number of Adults" class="form-control" />
            </div>
            <div class="form-group">
              <label>Children :</label>
              <input type="number" name="children" id="children" placeholder="Enter Number of Children" class="form-control" />
            </div>
            <div class="form-group">
              <label>Status :</label>
              <input type="text" name="status" id="status" placeholder="Enter Status" class="form-control" />
            </div>
            <div class="box-footer">
              <a type="button" href="/AdminBooking" class="btn btn-danger float-end m-3">Back</a>
              <input type="submit" class="btn btn-success float-end m-3" value="Submit">
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>