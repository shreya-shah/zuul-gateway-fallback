package com.prac.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class SimpleFilter extends ZuulFilter {
    @Override
    public String filterType() {

        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info(
                String.format("%s request to %s on: ", request.getMethod(), request.getRequestURL().toString()) + new Date()
        );

        /*
        * BUILDING JWT TOKEN
        * */
        /*    Map<String, Object> claims = new HashMap();
            claims.put("username", "abc.xyz");
            claims.put("role", "ADMIN");

            String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "S3cr3t").setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000)).addClaims(claims).compact();
            log.info(String.format("JWT CREATED IS: %s", jwt));

*/
        /*
        * PARSING JWT TOKEN
        * */

//        String jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzY2NzE1NTYsInJvbGUiOiJBRE1JTiIsInVzZXJuYW1lIjoiYWJjLnh5eiJ9.HBWkCEvPhvEprsK9qHlvTGs7-YbrdVnFFRMmAZNoaxI";
//        Map<String, Object> claimsRecieved = Jwts.parser().setSigningKey("S3cr3t").parseClaimsJws(jwtToken).getBody();
//
//        String authentication = Objects.requireNonNull(WebUtils.getCookie(request, "authentication")).getValue();
//        log.info("COOKIE RETRIEVED::::: " + authentication);
        return null;
    }
}
