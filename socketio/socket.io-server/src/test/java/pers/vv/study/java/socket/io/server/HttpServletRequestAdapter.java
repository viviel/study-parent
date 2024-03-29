package pers.vv.study.java.socket.io.server;

import pers.vv.study.common.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class HttpServletRequestAdapter implements HttpServletRequest {

    private final byte[] bytes;

    private final HttpServletRequest req;

    public HttpServletRequestAdapter(HttpServletRequest req) {
        this.req = req;
        try {
            ServletInputStream is = req.getInputStream();
            bytes = StreamUtils.copyToByteArray(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getAuthType() {
        return req.getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return req.getCookies();
    }

    @Override
    public long getDateHeader(String name) {
        return req.getDateHeader(name);
    }

    @Override
    public String getHeader(String name) {
        return req.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return req.getHeaders(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return req.getHeaderNames();
    }

    @Override
    public int getIntHeader(String name) {
        return req.getIntHeader(name);
    }

    @Override
    public HttpServletMapping getHttpServletMapping() {
        return req.getHttpServletMapping();
    }

    @Override
    public String getMethod() {
        return req.getMethod();
    }

    @Override
    public String getPathInfo() {
        return req.getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return req.getPathTranslated();
    }

    @Override
    public PushBuilder newPushBuilder() {
        return req.newPushBuilder();
    }

    @Override
    public String getContextPath() {
        return req.getContextPath();
    }

    @Override
    public String getQueryString() {
        return req.getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return req.getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String role) {
        return req.isUserInRole(role);
    }

    @Override
    public Principal getUserPrincipal() {
        return req.getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return req.getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        return req.getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
        return req.getRequestURL();
    }

    @Override
    public String getServletPath() {
        return req.getServletPath();
    }

    @Override
    public HttpSession getSession(boolean create) {
        return req.getSession(create);
    }

    @Override
    public HttpSession getSession() {
        return req.getSession();
    }

    @Override
    public String changeSessionId() {
        return req.changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return req.isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return req.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return req.isRequestedSessionIdFromURL();
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return req.isRequestedSessionIdFromURL();
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return req.authenticate(response);
    }

    @Override
    public void login(String username, String password) throws ServletException {
        req.login(username, password);
    }

    @Override
    public void logout() throws ServletException {
        req.logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return req.getParts();
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return req.getPart(name);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> httpUpgradeHandlerClass)
            throws IOException, ServletException {
        return req.upgrade(httpUpgradeHandlerClass);
    }

    @Override
    public Map<String, String> getTrailerFields() {
        return req.getTrailerFields();
    }

    @Override
    public boolean isTrailerFieldsReady() {
        return req.isTrailerFieldsReady();
    }

    @Override
    public Object getAttribute(String name) {
        return req.getAttribute(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return req.getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
        return req.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
        req.setCharacterEncoding(env);
    }

    @Override
    public int getContentLength() {
        return req.getContentLength();
    }

    @Override
    public long getContentLengthLong() {
        return req.getContentLengthLong();
    }

    @Override
    public String getContentType() {
        return req.getContentType();
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return bis.read();
            }
        };
    }

    @Override
    public String getParameter(String name) {
        return req.getParameter(name);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return req.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
        return req.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return req.getParameterMap();
    }

    @Override
    public String getProtocol() {
        return req.getProtocol();
    }

    @Override
    public String getScheme() {
        return req.getScheme();
    }

    @Override
    public String getServerName() {
        return req.getServerName();
    }

    @Override
    public int getServerPort() {
        return req.getServerPort();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return req.getReader();
    }

    @Override
    public String getRemoteAddr() {
        return req.getRemoteAddr();
    }

    @Override
    public String getRemoteHost() {
        return req.getRemoteHost();
    }

    @Override
    public void setAttribute(String name, Object o) {
        req.setAttribute(name, o);
    }

    @Override
    public void removeAttribute(String name) {
        req.removeAttribute(name);
    }

    @Override
    public Locale getLocale() {
        return req.getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return req.getLocales();
    }

    @Override
    public boolean isSecure() {
        return req.isSecure();
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return req.getRequestDispatcher(path);
    }

    @Override
    public String getRealPath(String path) {
        return req.getRealPath(path);
    }

    @Override
    public int getRemotePort() {
        return req.getRemotePort();
    }

    @Override
    public String getLocalName() {
        return req.getLocalName();
    }

    @Override
    public String getLocalAddr() {
        return req.getLocalAddr();
    }

    @Override
    public int getLocalPort() {
        return req.getLocalPort();
    }

    @Override
    public ServletContext getServletContext() {
        return req.getServletContext();
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return req.startAsync();
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
            throws IllegalStateException {
        return req.startAsync(servletRequest, servletResponse);
    }

    @Override
    public boolean isAsyncStarted() {
        return req.isAsyncStarted();
    }

    @Override
    public boolean isAsyncSupported() {
        return req.isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
        return req.getAsyncContext();
    }

    @Override
    public DispatcherType getDispatcherType() {
        return req.getDispatcherType();
    }
}
