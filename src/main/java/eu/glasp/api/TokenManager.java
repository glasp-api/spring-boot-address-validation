package eu.glasp.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.api.AccessTokenApi;
import org.openapitools.client.model.TokenRequest;
import org.openapitools.client.model.TokenResponse;

import java.util.Objects;
import java.util.logging.Logger;

public class TokenManager {
    private static final Logger logger = Logger.getLogger(TokenManager.class.getName());
    private static final Object lock = new Object();

    private String jwt;
    private Long expiryTimestamp;
    private final String user;
    private final String password;

    private final AccessTokenApi accessTokenApi;

    public TokenManager(String user, String password, Integer timeout){
        this.user = user;
        this.password = password;
        this.expiryTimestamp = System.currentTimeMillis();
        this.accessTokenApi = new AccessTokenApi();

        this.accessTokenApi.getApiClient().setReadTimeout(timeout);
        this.accessTokenApi.getApiClient().setWriteTimeout(timeout);
        this.accessTokenApi.getApiClient().setConnectTimeout(timeout);
    }

    public String getToken() throws ApiException {
        if (System.currentTimeMillis() < expiryTimestamp){
            return this.jwt;
        } else {
            return this.requestToken();
        }
    }

    private String requestToken() throws ApiException {
        synchronized (TokenManager.lock){
            if (!(System.currentTimeMillis() < this.expiryTimestamp)){
                TokenRequest tokenRequest = new TokenRequest();
                tokenRequest.setUserName(this.user);
                tokenRequest.setUserPassword(this.password);
                TokenResponse tokenResponse = this.accessTokenApi.accessToken(tokenRequest);
                logger.info("Successfully received a new access token for Glasp API.");
                this.jwt = tokenResponse.getAccessToken();
                //subtract 30seconds buffer from returned expiry timestamp
                this.expiryTimestamp = System.currentTimeMillis()
                        + (Long.parseLong(Objects.requireNonNull(tokenResponse.getExpiresIn())) - 30) * 1000L;
            }
        }
        return this.jwt;
    }
}
