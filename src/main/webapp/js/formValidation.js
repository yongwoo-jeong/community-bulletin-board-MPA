/**
 * 유저 입력값 검증을 위한 클래스
 */
class FormValidation {
  /**
   * 현재 FORM 검증 여부
   * @type {boolean}
   */
  isValid = false;

  /**
   * 경고문구 ON OFF 여부
   * @type {boolean}
   */
  isWarningOn = false;

  /**
   * 생성자
   * @param targetNode 타겟이 되는 HTML 엘리먼트 노드
   * @param regex 정규식
   */
  constructor(targetNode,regex) {
    this.targetNode = targetNode.parentNode;
    this.regex = regex;
  }

  /**
   * 폼 검증 메서드
   * @param formValue event.target.value
   * @param addWarningOption(default: true;)
   */
  isValidate(formValue, addWarningOption = true) {
    // 폼 길이, 정규식 패턴 확인
    if (!this.regex.test(formValue)) {
      // 경구문구 삽입옵션, 현재 경고문 존재 여부 확인
      if (addWarningOption && !this.isWarningOn) {
        this.insertWarning();
        this.isWarningOn = true;
      }
      return false;
    }
    this.isValid = true;
    // 경고문구 있을 경우 삭제
    this.deleteWarningElement()
    return true;
  }


  /**
   * 경고문 span 태그 삽입
   */
  insertWarning() {
    const newElement = document.createElement("span");
    newElement.innerText = '형식 불일치';
    newElement.style.color = 'red';
    this.targetNode.appendChild(newElement);
  }

  /**
   * 폼 검증된 경우 경고 태그 삭제
   */
  deleteWarningElement(){
    if (this.isWarningOn){
      this.targetNode.querySelector("span").remove();
    }
  }
}

export default FormValidation;