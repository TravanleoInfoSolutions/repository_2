package FormBuilderByHackers.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Allow origin to domains
 * 
 * @author bhavesh
 *
 */
@Component
@Order(1)
public class CORSFilter extends OncePerRequestFilter {

	@Value("${UI.URL_CLIENT}")
	private String URL_CLIENT;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", URL_CLIENT);
		response.addHeader("Access-Control-Allow-Credentials", "true");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH");
			response.addHeader("Access-Control-Allow-Headers",
					"origin, content-type, accept,Authorization,responseType");
			response.addHeader("Access-Control-Max-Age", "1");
		}
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getServletPath();
		return path.startsWith("/public") || path.startsWith("/admin");
	}

}
