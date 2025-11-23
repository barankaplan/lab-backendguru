curl -X POST http://localhost:8080/api/machine/off \
-H "Content-Type: application/json" \
-d '{"source":"MOBILE"}'

curl -X POST http://localhost:8080/api/machine/off \
-H "Content-Type: application/json" \
-d '{"source":"VOICE"}'

curl -X POST http://localhost:8080/api/machine/off \
-H "Content-Type: application/json" \
-d '{"source":"WEB"}'

curl -X POST http://localhost:8080/api/machine/off \
-H "Content-Type: application/json" \
-d '{"source":"XYZ"}'



curl -X POST http://localhost:8080/api/machine/on \
-H "Content-Type: application/json" \
-d '{"source":"MOBILE"}'

curl -X POST http://localhost:8080/api/machine/on \
-H "Content-Type: application/json" \
-d '{"source":"VOICE"}'

curl -X POST http://localhost:8080/api/machine/on \
-H "Content-Type: application/json" \
-d '{"source":"WEB"}'

curl -X POST http://localhost:8080/api/machine/on \
-H "Content-Type: application/json" \
-d '{"source":"XYZ"}'
