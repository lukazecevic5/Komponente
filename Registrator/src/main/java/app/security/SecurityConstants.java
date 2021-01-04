package app.security;

public final class SecurityConstants {

	public static final String SECRET = "mySecretKey";

	public static final long TOKEN_EXPIRATION_TIME = 86400000;
	public static final String TOKEN_PREFIX = "Basic ";
	public static final String HEADER_STRING = "Authorization";
	public static final String EDIT_PROFILE_PATH = "/editUser";
	public static final String CARD_PATH = "/addCard";
	public static final String LOGIN_PATH = "/login";
	public static final String REGISTRATION_PATH = "/register";
	public static final String LOGINADM_PATH = "/loginAsAdmin";
	public static final String name = "/userName/{email}";
	public static final String surname = "/userSurname/{email}";
	public static final String rank = "/userRank/{email}";
	public static final String pass = "/userPass/{email}";
	public static final String miles = "/userMiles/{email}";
	public static final String addMiles = "/addMiles/{email}/{miles}";
	public static final String updRank = "/updateRank/{email}";
	public static final String getCard = "/getCard/{email}";

}