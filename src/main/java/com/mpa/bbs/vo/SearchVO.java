package com.mpa.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	/**
	 * 검색조건 객체
	 */
	@Getter
	@Setter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public class SearchVO {
		/**
		 * 검색 키워드
		 */
		private String keyword;

		/**
		 * 게시판 ID
		 */
		private Integer boardId;

		/**
		 * 검색조건 시작날짜
		 */
		private String startDate;

		/**
		 * 검색조건 종료날짜
		 */
		private String endDate;

		/**
		 * 페지네이션값, 현재페이지
		 */
		@Builder.Default
		private Integer currentPage = 1;

		/**
		 * dbLimit offset. preparedStatement 사용을 위해서는 currentPage 값으로 연산 불가능..
		 */
		@Builder.Default
		private Integer dbLimitOffset = 0;
	}
