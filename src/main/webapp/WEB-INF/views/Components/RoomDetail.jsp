<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/styles/RoomDetail.css" />
</head>

<body>
  <div class="row no-gutters justify-content-center mb-4 mt-5 pb-3">
    <div class="col-md-7 heading-section text-center">
      <h2>SUPERIOR KING</h2>
      <span class="subheading">₱7000.00 <span class="price-subheading">/ Per Night</span></span>
    </div>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-12 col-lg-8 order-2 order-lg-1">
        <div class="single-room-details-area mb-50">
          <div class="room-thumbnail-slides mb-50">
            <div id="room-thumbnail--slide" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="img/SuperiorKing/sp1.jpg" class="d-block w-100" alt="" />
                </div>
                <div class="carousel-item">
                  <img src="/images/RoomDetail/SuperiorKing/sp2.jpg" class="d-block w-100" alt="" />
                </div>
                <div class="carousel-item">
                  <img src="/images/RoomDetail/SuperiorKing/sp3.jpg" class="d-block w-100" alt="" />
                </div>
                <div class="carousel-item">
                  <img src="/images/RoomDetail/SuperiorKing/sp4.jpg" class="d-block w-100" alt="" />
                </div>
              </div>

              <ol class="carousel-indicators">
                <li data-target="#room-thumbnail--slide" data-slide-to="0" class="active">
                  <img src="/images/RoomDetail/SuperiorKing/sp1.jpg" class="d-block w-100" alt="" />
                </li>
                <li data-target="#room-thumbnail--slide" data-slide-to="1">
                  <img src="/images/RoomDetail/SuperiorKing/sp2.jpg" class="d-block w-100" alt="" />
                </li>
                <li data-target="#room-thumbnail--slide" data-slide-to="2">
                  <img src="/images/RoomDetail/SuperiorKing/sp3.jpg" class="d-block w-100" alt="" />
                </li>
                <li data-target="#room-thumbnail--slide" data-slide-to="3">
                  <img src="/images/RoomDetail/SuperiorKing/sp4.jpg" class="d-block w-100" alt="" />
                </li>
              </ol>
            </div>
          </div>

          <!-- Room Features -->
          <div class="room-features-area d-flex flex-wrap mb-5 mt-5">
            <h6>Size: <span>31 m² </span></h6>
            <h6>Capacity: <span>Max 5 persons</span></h6>
            <h6>Bed: <span>2 King beds</span></h6>
            <h6> Bathroom: <span>1 bathroom</span></h6>
          </div>
          <p>
            Our Superior King rooms at Paraiso Hotel are beautifully designed
            with inspiration drawn from the Siargao island tropical sea. The
            tasteful interiors feature a king-sized bed, LED flat-screen TV
            with a wide range of local and international channels, and a
            vanity desk that also functions as a work desk.
          </p>

        </div>

        <div class="room-service mb-5 mt-5">
          <h4>Room Services</h4>

          <ul>
            <li>
              <img src="/images/RoomDetail/icon1.png" alt="" /> Air Conditioning
            </li>
            <li><img src="/images/RoomDetail/icon2.png" alt="" /> Free drinks</li>
            <li>
              <img src="/images/RoomDetail/icon3.png" alt="" /> Restaurant quality
            </li>
            <li><img src="/images/RoomDetail/icon4.png" alt="" /> Cable TV</li>
            <li>
              <img src="/images/RoomDetail/icon5.png" alt="" /> Unlimited Wifi
            </li>
            <li><img src="/images/RoomDetail/icon6.png" alt="" /> Service 24/7</li>
          </ul>
        </div>
      </div>

      <div class="col-12 col-lg-4 mb-5 order-1 order-lg-2">
        <div class="hotel-reservation--area mb-100">
          <form action="#" method="post">
            <div class="form-group mb-30">
              <label for="checkInDate">Date</label>
              <div class="input-daterange" id="datepicker">
                <div class="row no-gutters">
                  <div class="col-6">
                    <input type="text" class="input-small form-control" name="checkInDate" id="checkInDate"
                      placeholder="Check In" />
                  </div>
                  <div class="col-6">
                    <input type="text" class="input-small form-control" name="checkOutDate" placeholder="Check Out" />
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group mb-30">
              <label for="guests">Guests</label>
              <div class="row">
                <div class="col-6">
                  <select name="adults" id="guests" class="form-control">
                    <option value="adults">Adults</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                  </select>
                </div>
                <div class="col-6">
                  <select name="children" id="children" class="form-control">
                    <option value="children">Children</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="form-group">
              <button type="submit" class="btn roomDetailButton w-100 mt-4">
                Book Now
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
  <script src="/scripts/RoomDetail.js"></script>
</body>

</html>