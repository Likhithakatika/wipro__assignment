
Fixed movie-microservices projects (movie, booking, review, api-gateway, discovery-server)

How to run:
1) Open terminals and run services in this order:
   - discovery-server
   - movie-service
   - booking-service
   - review-service
   - api-gateway

Example:
cd discovery-server
mvn spring-boot:run

If 'mvn spring-boot:run' fails, try:
mvn clean package
java -jar target/*.jar

Notes:
- Each service uses H2 in-memory DB
- Services register with Eureka at http://localhost:8761
- API Gateway listens on http://localhost:8080 and routes /movies, /theaters, /bookings, /reviews
