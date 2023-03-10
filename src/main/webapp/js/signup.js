import {FormValidator} from "./formValidator.js"

// input 엘리먼트 쿼리셀렉트
const accountInput = document.querySelector('input[name="account"]');
const passwordInput = document.querySelector('input[name="password"]');
const passwordConfirmInput = document.querySelector(
    'input[name="passwordConfirm"]');
const nameInput = document.querySelector('input[name="name"]');
const emailInput = document.querySelector('input[name="email"]');
const submitButton = document.querySelector('input[type="submit"]');

// 폼 검증 클래스 인스턴스 생성
const accountValid = new FormValidator(accountInput, /^[a-z0-9]{5,9}$/);
const passwordValid = new FormValidator(passwordInput,
    /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
const passwordConfirmValid = new FormValidator(passwordConfirmInput,
    /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
const nameValid = new FormValidator(nameInput, /^[ㄱ-ㅎ|가-힣]{3,4}$/);
const emailValid = new FormValidator(emailInput,
    /^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]/);

/**
 * 제출 버튼 클릭시 각 항목 검증 여부 가져와서 확인 후 처리.
 * 비밀번호 일치여부도 확인
 * @param event 이벤트 객체
 */
function onSubmitClick(event) {
  const allInputValidList = [accountValid.validation, passwordValid.validation, passwordConfirmValid.validation, nameValid.validation, emailValid.validation];
  for (const valid of allInputValidList) {
    if (valid === false) {
      alert("정보가 올바르지 않습니다.");
      event.preventDefault();
      return;
    }
  }
  if (passwordInput.value !== passwordConfirmInput.value) {
    alert("비밀번호가 일치하지 않습니다.");
    event.preventDefault();
  }
}

submitButton.addEventListener("click", onSubmitClick);

