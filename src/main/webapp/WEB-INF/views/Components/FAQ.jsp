<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="stylesheet" href="/styles/FAQ.css" />
  </head>

  <body>
    <body></body>
    <div class="col-md-12 px-0">
      <div class="faq_area pt-5 pb-5" id="faq">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-12 col-sm-8 col-lg-6">
              <div
                class="section_heading text-center"
                style="visibility: visible"
              >
                <h3 class="mb-3"><span>Frequently </span> Asked Questions</h3>
                <p>
                  Get the scoop! Browse our FAQs for quick answers to all your
                  hotel stay questions.
                </p>
                <div class="line mb-5"></div>
              </div>
            </div>
          </div>
          <div class="row justify-content-center p-0 m-0">
            <div class="col-6 col-sm-4 p-0 m-0">
              <img
                src="/images/FAQ/question.svg"
                alt=""
                class="float-left d-none d-lg-block p-0 m-0"
                style="width: 300px; height: 300px"
              />
            </div>

            <div class="col-6 col-sm-4 col-lg-8 ml-0 pl-0">
              <div class="accordion faq-accordian" id="faqAccordion">
                <div class="card border-0" style="visibility: visible">
                  <div class="card-header" id="headingOne">
                    <h6
                      class="mb-0 collapsed"
                      data-toggle="collapse"
                      data-target="#collapseOne"
                      aria-expanded="true"
                      aria-controls="collapseOne"
                    >
                      How can I make a reservation?<span
                        class="fa-solid fa-caret-up lni-chevron-up"
                      ></span>
                    </h6>
                  </div>
                  <div
                    class="collapse"
                    id="collapseOne"
                    aria-labelledby="headingOne"
                    data-parent="#faqAccordion"
                  >
                    <div class="card-body">
                      <p>
                        Booking is quick and easy! Our user-friendly online
                        booking system allows you to browse available rooms,
                        view rates, and secure your reservation in just a few
                        clicks.
                      </p>
                      <p>
                        Prefer a personal touch? Call us directly at
                        +639482440776 and our friendly reservations agents will
                        be happy to assist you.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="card border-0" style="visibility: visible">
                  <div class="card-header" id="headingTwo">
                    <h6
                      class="mb-0 collapsed"
                      data-toggle="collapse"
                      data-target="#collapseTwo"
                      aria-expanded="true"
                      aria-controls="collapseTwo"
                    >
                      Can I modify or cancel my reservation online?<span
                        class="fa-solid fa-caret-up lni-chevron-up"
                      ></span>
                    </h6>
                  </div>
                  <div
                    class="collapse"
                    id="collapseTwo"
                    aria-labelledby="headingTwo"
                    data-parent="#faqAccordion"
                  >
                    <div class="card-body">
                      <p>
                        For your convenience, we offer a user-friendly online
                        reservation portal. Simply log in to your account,
                        select "Manage Reservations," and choose the reservation
                        you'd like to modify or cancel. There you'll see options
                        to adjust your dates or even cancel entirely
                      </p>
                      <p>
                        If you encounter any difficulties or have questions,
                        please don't hesitate to contact our friendly
                        reservations team at +639482440776 for further
                        assistance.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="card border-0" style="visibility: visible">
                  <div class="card-header" id="headingThree">
                    <h6
                      class="mb-0 collapsed"
                      data-toggle="collapse"
                      data-target="#collapseThree"
                      aria-expanded="true"
                      aria-controls="collapseThree"
                    >
                      What forms of payment do you accept?<span
                        class="fa-solid fa-caret-up lni-chevron-up"
                      ></span>
                    </h6>
                  </div>
                  <div
                    class="collapse"
                    id="collapseThree"
                    aria-labelledby="headingThree"
                    data-parent="#faqAccordion"
                  >
                    <div class="card-body">
                      <p>
                        We offer several secure payment options to suit your
                        needs. For your convenience, we accept all major credit
                        cards and debit
                        cards with a PIN. Additionally, cash is accepted upon
                        arrival or to settle any incidentals during your stay.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/scripts/FAQ.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
