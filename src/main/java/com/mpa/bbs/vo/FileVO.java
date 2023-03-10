package com.mpa.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * 파일 VO
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

	/**
	 * UUID - auto increment
	 */
	private String uuid;

	/**
	 * 서버상 파일명
	 */
	@NonNull
	private String nameOnServer;

	/**
	 * 등록 시 파일명
	 */
	@NonNull
	private String nameOriginal;

	/**
	 * 파일사이즈
	 */
	@NonNull
	private Integer size;

	/**
	 * 서버 저장 경로
	 */
	@NonNull
	private String path;

	/**
	 * 파일 확장자명
	 */
	@NonNull
	private String extension;


}
