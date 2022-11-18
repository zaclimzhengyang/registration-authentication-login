package com.example.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    /*
        registrationService.register() > registrationRequest.getEmail()

        registrationService.register() > appUserService.signUpUser()
        appUserService.signUpUser() > appUserRepository.findByEmail()
     */
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    /*
        registrationService.confirmToken() made use of confirmationTokenService.getToken() to get token
        confirmationTokenService.getToken() made use of confirmationTokenRepository.findByToken()
     */
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
