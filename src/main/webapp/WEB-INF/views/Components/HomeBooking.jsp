<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
     <link rel="stylesheet" href="/styles/HomeBooking.css" type="text/css" />
  </head>

  <body>
    <section class="home-booking">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <form action="#" class="filter-form">
              <div class="filter-form-item">
                <p>Check In</p>
                <div class="filter-form-datepicker">
                  <span class="fa-regular fa-calendar"></span>
                  <input type="text" class="datepicker-pop check-in" />
                  <i class="fa-solid fa-angle-down"></i>
                </div>
              </div>
              <div class="filter-form-item">
                <p>Check Out</p>
                <div class="filter-form-datepicker">
                  <span class="fa-regular fa-calendar"></span>
                  <input type="text" class="datepicker-pop check-out" />
                  <i class="fa-solid fa-angle-down"></i>
                </div>
              </div>
              <div class="filter-form-item filter-form-item--select">
                <p>Adults</p>
                <div class="filter-form-select">
                  <span class="fa-solid fa-user"></span>
                  <select>
                    <option value="">1 Adult</option>
                    <option value="">2 Adults</option>
                    <option value="">3 Adults</option>
                    <option value="">4 Adults</option>
                    <option value="">5 Adults</option>
                    <option value="">6 Adults</option>
                    <option value="">7 Adults</option>
                    <option value="">8 Adults</option>
                  </select>
                </div>
              </div>
              <div class="filter-form-item filter-form-item--select">
                <p>Kids</p>
                <div class="filter-form-select">
                  <span class="fa-solid fa-child"></span>
                  <select>
                    <option value="">1 Kid</option>
                    <option value="">2 Kids</option>
                    <option value="">3 Kids</option>
                    <option value="">4 Kids</option>
                    <option value="">5 Kids</option>
                    <option value="">6 Kids</option>
                    <option value="">7 Kids</option>
                    <option value="">8 Kids</option>
                  </select>
                </div>
              </div>
              <button type="submit">CHECK AVAILABILITY</button>
            </form>
          </div>
        </div>
      </div>
    </section>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/superfish/1.7.10/js/superfish.min.js"></script>					
	
    <script src="/scripts/HomeBooking.js"></script>
  </body>
</html>
