package SpringBootKurs.controller;

import SpringBootKurs.model.LoginRequest;
import SpringBootKurs.model.TokenResponse;
import SpringBootKurs.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginControler {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        authenticationManager.authenticate(authentication);

        return new TokenResponse(tokenService.generateToken(loginRequest.getUsername()));
    }
}