<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paraiso Hotel | Add New Room Type</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<link rel="stylesheet" href="/styles/dashboardAdmin/CRUD.css">
</head>
<body>
<div class="container-fluid">
  <div class="row justify-content-center vertical-center">
    <div class="col-lg-6 col-md-6">
      <div class="card">
        <h1 class="text-center p-3">Add New Room Type</h1>
        <div class="card-body">
          <form action="addRoomTypes/save" method="post">
            <div class="form-group">
              <label>Name :</label>
              <input type="text" name="hotel_id" id="name" placeholder="Enter Name of Room" class="form-control" />
            </div>
            <div class="form-group">
              <label>Description :</label>
              <input type="text" name="type_id" id="description" placeholder="Enter Description" class="form-control" />
            </div>
            <div class="form-group">
              <label>Price per Night :</label>
              <input type="text" name="status" id="price_per_night" placeholder="Enter Price per night" class="form-control" />
            </div>
            <div class="form-group">
              <label>Capacity :</label>
              <input type="text" name="hotel_id" id="capacity" placeholder="Enter Capacity" class="form-control" />
            </div>
            <div class="form-group">
              <label>Beds :</label>
              <input type="text" name="type_id" id="beds" placeholder="Enter Number of Beds" class="form-control" />
            </div>
            <div class="form-group">
              <label>Bathrooms :</label>
              <input type="text" name="status" id="bathrooms" placeholder="Enter Number of Bathrooms" class="form-control" />
            </div>
            <div class="box-footer">
              <a type="button" href="/AdminRoomTypes" class="btn btn-danger float-end m-3">Back</a>
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