/**
 * 페지네이션 onClick 이벤트핸들러
 * @param pageNumber
 */
function paging(pageNumber){
  /**
   * 페이징을 위한 쿼리스트링
   * 현재 페이지를 제외한 쿼리스트링
   * @type {string}
   */
  let queryString = (new URL(document.location)).searchParams.toString().replace(/currentPage=[\d+]$/,"");
  if (queryString.length===0){
    queryString = "?currentPage=";
  } else {
    queryString = "?"+queryString+"&currentPage=";
  }
  queryString = queryString+pageNumber;
  location.href=queryString;
  // location.replace(queryString);
}