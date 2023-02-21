package version.mpa.bbs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 캐릭터셋 인코딩
 */
@WebFilter("/*")
public class ServletFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 문자 인코딩
		request.setCharacterEncoding("utf-8");
		//사전작업(한글처리)의 내용이 서버상의 다음번 컴포넌트에게 계속 적용되기 위한 작업...
		chain.doFilter(request, response);
	}
}
