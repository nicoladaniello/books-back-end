package io.githgub.nicoladaniello.books.security;

public class SecurityConstants {
    public static final String JWT_SECRET = "HJGhugvHjvGHvc67Tfvgyu7T65767Rt67fv67KOIH7uG867fghFgHv65dKKV5cfdhHGFcGhjHbv877gYhBVHJaaz";
    public static final long EXPIRATION_TIME = 12L * 30L * 24 * 60 * 60 * 1000; // 360 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/companies";
    public static final String SIGN_IN_URL = "/authenticate";
}
