package app.security;

public final class SecurityConstants {

	public static final String SECRET = "mySecretKey";

	public static final long TOKEN_EXPIRATION_TIME = 86400000;
	public static final String TOKEN_PREFIX = "Basic ";
	public static final String HEADER_STRING = "Authorization";
	public static final String EDIT_PROFILE_PATH = "/editUser/{id}";
	public static final String CARD_PATH = "/addCard/{id}";
	public static final String LOGIN_PATH = "/login";
	public static final String REGISTRATION_PATH = "/register";
	public static final String LOGINADM_PATH = "/loginAsAdmin";
	public static final String name = "/userName/{id}";
	public static final String surname = "/userSurname/{id}";
	public static final String rank = "/userRank/{id}";
	public static final String pass = "/userPass/{id}";
	public static final String miles = "/userMiles/{id}";
	public static final String addMiles = "/addMiles/{id}/{miles}";
	public static final String updRank = "/updateRank/{id}";
	public static final String getCard = "/getCards/{id}";
	public static final String pay = "/pay/{id}/{price}";
	public static final String mail = "/userMail/{id}";
}