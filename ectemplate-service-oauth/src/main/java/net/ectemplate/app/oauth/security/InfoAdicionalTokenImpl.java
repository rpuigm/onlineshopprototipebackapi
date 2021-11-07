package net.ectemplate.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import net.ectemplate.app.oauth.entities.Usuario;
import net.ectemplate.app.oauth.services.UsuarioServiceI;

@Component
public class InfoAdicionalTokenImpl implements TokenEnhancer {

	@Autowired
	private UsuarioServiceI usuarioServiceI;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		Usuario usuario = usuarioServiceI.fingByUsername(authentication.getName());
		info.put("nombre", usuario.getNombre());
		info.put("apellidos", usuario.getApellidos());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
