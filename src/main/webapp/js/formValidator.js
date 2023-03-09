/**
 * 유저 입력값 검증을 위한 클래스
 */
export class FormValidator {
  constructor(element, regex) {
    /**
     * 타겟 필드
     */
    this.element = element;
    /**
     * 정규식
     */
    this.regex = regex;
    /**
     * 검증 여부
     * @type {boolean} default false
     */
    this.validation = false;
    /**
     * 경고 문구 여부
     * @type {boolean} default false
     */
    this.isWarningOn = false;
    this.element.addEventListener('change', (event) => {
      this.validate(event.target.value);
    });
  }

  /**
   * 입력값 검증 메서드
   * @param targetValue
   */
  validate(targetValue) {
    this.validation = this.regex.test(targetValue);
    this.updateWarning();
  }

  /**
   * 경고문구 업데이트 메서드
   */
  updateWarning(){
    const targetNode = this.element.parentNode;
    if (!this.isWarningOn && !this.validation){
      const newElement = document.createElement("span");
      newElement.innerText = '형식 불일치';
      newElement.style.color = 'red';
      targetNode.appendChild(newElement);
      this.isWarningOn = true;
    } else if(this.isWarningOn && this.validation){
      targetNode.querySelector("span").remove();
      this.isWarningOn = false;
    }
  }
}
