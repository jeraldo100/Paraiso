<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <link href="/styles/Contact.css" rel="stylesheet" />
  </head>

  <body>

    <section id="contact" class="contact mb-5 mt-5">
      <div class="container" data-aos="fade-up">
        <div class="section-title text-center">
          <p>Contact Us</p>
        </div>
      </div>

      <div data-aos="fade-up">
        <iframe style="border: 0; width: 100%; height: 350px"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3931.824969050881!2d126.14940267353794!3d9.780873276769967!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3303f63fa9732585%3A0x34db0037dcc8540a!2sSiargao%20Island%20Getaway!5e0!3m2!1sen!2sph!4v1711879355460!5m2!1sen!2sph"></iframe>
      </div>

      <div class="container" data-aos="fade-up">
        <div class="row mt-5">
          <div class="col-lg-4">
            <div class="info">
              <div class="address">
                <i class="fa-solid fa-location-dot"></i>
                <h4>Location:</h4>
                <p>Brgy. Cambutuanon, General Luna, 8419 Surigao del Norte</p>
              </div>

              <div class="open-hours">
                <i class="fa-solid fa-clock"></i>
                <h4>Open Hours:</h4>
                <p>
                  Monday-Saturday:<br />
                  06:00 AM - 12:00 PM
                </p>
              </div>

              <div class="email">
                <i class="fa-solid fa-envelope"></i>
                <h4>Email:</h4>
                <p>paraiso@gmail.com</p>
              </div>

              <div class="phone">
                <i class="fa-solid fa-phone"></i>
                <h4>Call:</h4>
                <p>09482440776</p>
              </div>
            </div>
          </div>

          <div class="col-lg-8 mt-5 mt-lg-0">
            <form action="" role="form" class="" id="emailForm">
              <div class="row">
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required />
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required />
                </div>
              </div>
              <div class="form-group mt-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required />
              </div>
              <div class="form-group mt-3">
                <textarea class="form-control" name="message" rows="8" placeholder="Message" required></textarea>
              </div>
              <div class="text-center mt-3">
                <button type="button" id="sendBtn">Send Message</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <section id="team" class="team" style="margin: 100px 0">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>Meet Our Team</h2>
          <p>The Management Team</p>
        </div>

        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="member" data-aos="zoom-in" data-aos-delay="100">
              <img src="/images/Contact/jerald.jpg" class="img-fluid" alt="" />
              <div class="member-info">
                <div class="member-info-content">
                  <h4>Jerald Bulos</h4>
                  <span>Hotel Manager</span>
                </div>
                <div class="social">
                  <a href=""><i class="fa-brands fa-x-twitter"></i></a>
                  <a href=""><i class="fa-brands fa-facebook"></i></a>
                  <a href=""><i class="fa-brands fa-instagram"></i></a>
                  <a href=""><i class="fa-brands fa-linkedin"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="member" data-aos="zoom-in" data-aos-delay="200">
              <img src="/images/Contact/flocer.jpg" class="img-fluid" alt="" />
              <div class="member-info">
                <div class="member-info-content">
                  <h4>Flocer Angelo M. Bustamante</h4>
                  <span>Hotel Manager</span>
                </div>
                <div class="social">
                  <a href=""><i class="fa-brands fa-x-twitter"></i></a>
                  <a href=""><i class="fa-brands fa-facebook"></i></a>
                  <a href=""><i class="fa-brands fa-instagram"></i></a>
                  <a href=""><i class="fa-brands fa-linkedin"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="member" data-aos="zoom-in" data-aos-delay="300">
              <img src="/images/Contact/amiel.jpg" class="img-fluid" alt="" />
              <div class="member-info">
                <div class="member-info-content">
                  <h4>Amiel Gonzales</h4>
                  <span>Hotel Manager</span>
                </div>
                <div class="social">
                  <a href=""><i class="fa-brands fa-x-twitter"></i></a>
                  <a href=""><i class="fa-brands fa-facebook"></i></a>
                  <a href=""><i class="fa-brands fa-instagram"></i></a>
                  <a href=""><i class="fa-brands fa-linkedin"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
    $(document).ready(function () {
      $("#sendBtn").click(function () {
        var name = $("#name").val();
        var email = $("#email").val();
        var subject = $("#subject").val();
        var message = $("textarea[name='message']").val();

        var mailtoLink = "mailto:morilangelo808@gmail.com?" +
          "subject=" + encodeURIComponent(subject) +
          "&body=" + encodeURIComponent(message + "\n\n");

        window.location.href = mailtoLink;
      });
    });
  </script>

  </html>