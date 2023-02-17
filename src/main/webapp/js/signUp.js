import formValidation from "./formValidation.js"

// input 엘리먼트 쿼리셀렉트
const accountInput = document.querySelector('input[name="account"]');
const passwordInput = document.querySelector('input[name="password"]');
const passwordConfirmInput = document.querySelector('input[name="passwordConfirm"]');
const nameInput = document.querySelector('input[name="name"]');
const emailInput = document.querySelector('input[name="email"]');
const submitButton = document.querySelector('input[type="submit"]');

// 폼 검증 클래스 인스턴스 생성
let accountValid = new formValidation(accountInput,/^[a-z0-9]{5,9}$/);
let passwordValid = new formValidation(passwordInput,  /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
let passwordConfirmValid = new formValidation(passwordConfirmInput, /^[a-z0-9`~!@#$%^&*()-_=+]{6,15}$/);
let nameValid = new formValidation(nameInput, /^[ㄱ-ㅎ|가-힣]{3,4}$/);
let emailValid = new formValidation(emailInput, /^[-0-9A-Za-z!#$%&'*+/=?^_`{|}~.]+@[-0-9A-Za-z!#$%&'*+/=?^_`{|}~]+[.][0-9A-Za-z]/);

// submit 클릭 시 최종 검증 여부 조회를 위한 불린값 선언
let isAccountValid = false;
let isPasswordValid = false;
let isPasswordConfirmValid = false;
let isNameValid = false;
let isEmailValid = false;


/**
 * 아이디 인풋 이벤트핸들러
 * @param event
 */
function onAccountChange(event){
  isAccountValid = accountValid.isValidate(event.target.value);
}

/**
 * 비밀번호 이벤트핸들러
 * @param event
 */
function onPasswordChange(event){
  isPasswordValid = passwordValid.isValidate(event.target.value);
}

/**
 * 비밀번호 확인 이벤트핸들러
 */
function onPasswordConfirmChange(event){
  isPasswordConfirmValid = passwordConfirmValid.isValidate(event.target.value);
}

/**
 * 이름 이벤트핸들러
 * @param event
 */
function onNameChange(event){
  isNameValid = nameValid.isValidate(event.target.value);
}

/**
 * 이메일 이벤트핸들러
 * @param event
 */
function onEmailChange(event){
  isEmailValid = emailValid.isValidate(event.target.value);
}

/**
 * 제출 버튼 클릭시 각 항목 검증 여부 가져와서 확인 후 처리.
 * 비밀번호 일치여부도 이때 확인
 * @param event
 */
function onSubmitClick(event){
  let allInputValidList = [isAccountValid, isPasswordValid, isPasswordConfirmValid, isNameValid, isEmailValid];
  console.log(allInputValidList);
  for (let valid of allInputValidList){
    if (valid === false){
      alert("정보가 올바르지 않습니다.");
      event.preventDefault();
      return;
    }
  }
  if (passwordInput.value !== passwordConfirmInput.value){
    alert("비밀번호가 일치하지 않습니다.");
    event.preventDefault();
  }
}

// 각 input 이벤트리스너 등록
accountInput.addEventListener("change",onAccountChange);
passwordInput.addEventListener("change", onPasswordChange);
passwordConfirmInput.addEventListener("change", onPasswordConfirmChange);
nameInput.addEventListener("change", onNameChange);
emailInput.addEventListener("change", onEmailChange);
submitButton.addEventListener("click", onSubmitClick);

