<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Paraiso Hotel Dashboard</title>

  <!--BOOTSTRAP LINK-->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

  <!-- CSS LINK -->

  <link rel="stylesheet" href="/styles/dashboardAdmin/booking.css" />
</head>

<body>
  <div class="container-fluid">
    <div class="row flex-nowrap">
      <jsp:include page="sidebar.jsp"></jsp:include>
      <!-- Main Content -->
      <div class="col">
        <div class="container-fluid" id="main-content">
          <div class="row">
            <div class="col-lg-15 ms-auto p-4 overflow-hidden">
              <h1 class="display-3">Good morning, Admin!</h1>
              <hr />
              <div class="d-flex align-items-center justify-content-between mb-4">
                <h1>Bookings</h1>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                  <button type="button" class="btn btn-success">Print</button>
                  <button type="button" class="btn btn-success">Add</button>
                  <select name="" id="" class="form-select shadow-none bg-light w-auto">
                    <option value="0">Select timeline</option>
                    <option value="1">Past 30 Days</option>
                    <option value="2">Past 60 Days</option>
                    <option value="3">Past 90 Days</option>
                    <option value="4">Past 1 Year</option>
                    <option value="5">All time</option>
                  </select>
                </div>
              </div>

              <div class="row mb-4">
                <div class="col-md-12 b-4">
                  <a href="#" class="text-decoration-none">
                    <div class="card text-center p-3 text-success table-responsive"
                      style="max-height: 100%; overflow-y: auto">
                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th></th>
                            <th>Booking ID</th>
                            <th>User ID</th>
                            <th>Room ID</th>
                            <th>Check In</th>
                            <th>Check Out</th>
                            <th>Total Price</th>
                            <th>Approval</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td><input type="checkbox" /></td>
                            <td>121313</td>
                            <td>1212</td>
                            <td>12</td>
                            <td>fev2</td>
                            <td>fev4</td>
                            <td>$12121</td>
                            <td>
                              <button class="btn btn-success">Approve</button>
                              <button class="btn btn-danger">
                                Disapprove
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-success">
                                Edit
                              </button>
                              <button type="button" class="btn btn-danger">
                                Delete
                              </button>
                            </td>
                          </tr>
                          <tr>
                            <td><input type="checkbox" /></td>
                            <td>121313</td>
                            <td>1212</td>
                            <td>12</td>
                            <td>fev2</td>
                            <td>fev4</td>
                            <td>$12121</td>
                            <td>
                              <button class="btn btn-success approve">Approve</button>
                              <button class="btn btn-danger disapprove">
                                Disapprove
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-success">
                                Edit
                              </button>
                              <button type="button" class="btn btn-danger">
                                Delete
                              </button>
                            </td>
                          </tr>
                          <tr>
                            <td><input type="checkbox" /></td>
                            <td>121313</td>
                            <td>1212</td>
                            <td>12</td>
                            <td>fev2</td>
                            <td>fev4</td>
                            <td>$12121</td>
                            <td>
                              <button class="btn btn-success">Approve</button>
                              <button class="btn btn-danger">
                                Disapprove
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-success">
                                Edit
                              </button>
                              <button type="button" class="btn btn-danger">
                                Delete
                              </button>
                            </td>
                          </tr>
                          <tr>
                            <td><input type="checkbox" /></td>
                            <td>121313</td>
                            <td>1212</td>
                            <td>12</td>
                            <td>fev2</td>
                            <td>fev4</td>
                            <td>$12121</td>
                            <td>
                              <button class="btn btn-success" id="approved">
                                Approve
                              </button>
                              <button class="btn btn-danger" id="disapproved">
                                Disapprove
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-success">
                                Edit
                              </button>
                              <button type="button" class="btn btn-danger">
                                Delete
                              </button>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script> -->
</body>

<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
  integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
  integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script> -->

<!-- IONICONS LINK -->
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="paraiso.js"></script>

</html>