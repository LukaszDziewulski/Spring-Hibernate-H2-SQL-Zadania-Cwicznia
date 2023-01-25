# JWT w Spring Boot 2.7

Kod do artykułu ze strony: https://javascratches.pl/jwt-w-spring-boot-2-7/

Aplikacja udostępnia dwa endpointy:

1. Endpoint logowania do API `/login`
```bash
curl -i -X POST http://localhost:8080/login \
-H 'Content-Type: application/json' \
-d '{"username":"admin","password":"sekret2"}'
```
3. Enpoint `/hello` wymagający autoryzacji. Zwraca prosty komunikat.  
W nagłówku `Authorization:` należy przekazać otrzymany token.
```bash
curl -i -X GET http://localhost:8080/hello \
  -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1MzgxNTgzOCwiaWF0IjoxNjUzODE1Nzc4fQ.1YfHz6jmjl1UsX3AGznMMJGxp4wtn7Y11ltSVquWBV0gGHRn7U1L686gWGJWSdmRiIisgizMmJXfBftFVPt_Lg'
```

