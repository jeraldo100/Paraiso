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
        <h1 class="text-center p-3">Add New Voucher</h1>
        <div class="card-body">
          <form action="/admin/updateVouchers/${voucher.voucher_id }" method="post">
            <div class="form-group">
              <label>Voucher Code :</label>
              <input type="text" name="voucher_code" id="voucher_code" placeholder="Enter Voucher Code" class="form-control" />
            </div>
            <div class="form-group">
              <label>Description :</label>
              <input type="text" name="description" id="description" placeholder="Enter Description" class="form-control" />
            </div>
            <div class="form-group">
              <label>Amount :</label>
              <input type="number" name="amount" id="amount" placeholder="Enter Amount" class="form-control" />
            </div>
            <div class="form-group">
              <label>Validity :</label>
              <input type="date" name="validation" id="validation" placeholder="Enter Validity (yyyy-mm-dd)" class="form-control" />
            </div>
            <div class="box-footer">
              <a type="button" href="/admin/AdminDiscount" class="btn btn-danger float-end m-3">Back</a>
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