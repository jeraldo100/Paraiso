

const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".login-container");
const sign_in_btn2 = document.querySelector("#sign-in-btn2");
const sign_up_btn2 = document.querySelector("#sign-up-btn2");

loginBtn.onclick = function() {
  modal.style.display = "block";
  container.classList.remove("loginSignUpMode");
  container.classList.remove("loginSignUpMode2");
}

signUpBtn.onclick = function() {
  modal.style.display = "block";
  container.classList.add("loginSignUpMode");
  container.classList.add("loginSignUpMode2");
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

sign_up_btn.addEventListener("click", () => {
    container.classList.add("loginSignUpMode");
});
sign_in_btn.addEventListener("click", () => {
    container.classList.remove("loginSignUpMode");
});
sign_up_btn2.addEventListener("click", () => {
    container.classList.add("loginSignUpMode2");
});
sign_in_btn2.addEventListener("click", () => {
    container.classList.remove("loginSignUpMode2");
});



