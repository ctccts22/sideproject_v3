package v3.sideproject.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import java.util.*
import javax.crypto.SecretKey

class JwtTokenProvider {
    @Value("\${app.jwt-secret}")
    private val secretKey: String? = null

    @Value("\${app.jwt-expiration-milliseconds}")
    private val accessTokenValid: Long? = null

    private fun getSignKey(): SecretKey {
        val keyBytes = Decoders.BASE64.decode(this.secretKey)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun publishAccessToken(authentication: Authentication): String {
        val now = Date()
        val accessValidDate = Date(now.time + accessTokenValid!!)
        return Jwts.builder()
                .claim("email", authentication.name)
                .claim("role", authentication.authorities)
                .issuedAt(now)
                .expiration(accessValidDate)
                .signWith(getSignKey())
                .compact()
    }
}