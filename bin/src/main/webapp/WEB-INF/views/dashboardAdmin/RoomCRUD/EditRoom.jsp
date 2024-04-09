<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paraiso Hotel | Edit Room</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<link rel="stylesheet" href="/styles/dashboardAdmin/CRUD.css">
</head>
<body>
<div class="container-fluid">
  <div class="row justify-content-center vertical-center">
    <div class="col-lg-6 col-md-6">
      <div class="card">
        <h1 class="text-center p-3">Edit Room</h1>
        <div class="card-body">
          <form action="/update/${room.room_id}" method="post">
            <div class="form-group">
              <label>Hotel ID :</label>
              <input type="number" name="hotel_id" id="hotel_id" value="1" readonly placeholder="Enter Hotel ID" class="form-control" />
            </div>
            <div class="form-group">
              <label>Type ID :</label>
              <input type="number" name="type_id" id="type_id" placeholder="Enter Type ID" class="form-control" />
            </div>
            <div class="form-group">
              <label>Status :</label>
              <input type="text" name="status" id="status" placeholder="Enter Status" class="form-control" />
            </div>
            <div class="box-footer">
              <a type="button" href="/AdminRooms" class="btn btn-danger float-end m-3">Back</a>
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