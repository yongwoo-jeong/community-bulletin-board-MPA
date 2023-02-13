package version.mpa.bbs.filter;//package version.mpa.multiboard.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 정적 리소스 파일 요청 방지
// */
//@WebFilter("/*")
//public class StaticResourceFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		String path = req.getServletPath();
//
//		// Exclude static resources from the filter
////		if (path.startsWith("/css") || path.startsWith("/js") || path.endsWith(".ico")) {
////			return;
////		} else {
////			chain.doFilter(request, response);
////		}
//	}
//}
