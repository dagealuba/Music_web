package filter;

import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebFilter(filterName = "ResponseHostFilter",urlPatterns = "/*")
public class ResponseHostFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, java.io.IOException {
//        System.out.println("test");
        ((HttpServletResponse) resp).setHeader("Access-Control-Allow-Origin","*");
//        ((HttpServletResponse) resp).setContentType("charset=UTF-8");
        chain.doFilter(req,resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }
}
