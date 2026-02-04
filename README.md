# Cities & Hotels — Microservicios con Circuit Breaker (Resilience4J)

Este proyecto implementa un escenario práctico de arquitectura de microservicios donde se aplica el patrón Circuit Breaker utilizando Resilience4J para manejar fallos entre servicios distribuidos.

El sistema está compuesto por dos microservicios:

- cities-service: administra ciudades turísticas
- hotels-service: administra hoteles asociados a cada ciudad

Ambos servicios se encuentran registrados en Eureka Server y se comunican entre sí mediante OpenFeign y Spring Cloud LoadBalancer.

---

## Objetivo del ejercicio

Demostrar en un caso real el uso de:

- Service Discovery con Eureka
- Comunicación entre microservicios
- Spring Cloud LoadBalancer
- Circuit Breaker con Resilience4J
- Retry automático
- Fallback cuando un servicio falla
- Desacople total entre servicios

---

## Escenario funcional

El servicio cities-service recibe una solicitud con:

nombre de ciudad  
pais

Y debe responder con:

- id de la ciudad
- nombre
- continente
- país
- provincia / estado
- lista de hoteles asociados

La lista de hoteles no se encuentra en cities-service, sino que se obtiene consultando al hotels-service enviando como parámetro el idCiudad.

---

## Arquitectura

Eureka Server
   | 
cities-service  <----->  hotels-service
        |
        v
Resilience4J (Circuit Breaker)

---

## ¿Qué problema resuelve el Circuit Breaker aquí?

Si hotels-service se cae, responde lento o lanza excepciones:

- cities-service no queda bloqueado
- Se ejecuta un fallback automático
- El sistema sigue respondiendo correctamente
- Se evita que la falla se propague

---

## Tecnologías utilizadas

- Spring Boot
- Spring Cloud Eureka Client
- Spring Cloud LoadBalancer
- OpenFeign
- Resilience4J
- Maven

---

## Flujo de ejecución

1. Cliente consulta: /cities/hotels?name=...&country=...
2. cities-service busca la ciudad
3. cities-service consulta a hotels-service vía Feign
4. Si hotels-service responde, se arma el DTO completo con hoteles
5. Si hotels-service falla, se activa Circuit Breaker y se ejecuta fallback

---

## Endpoints principales

### Cities

GET /cities/hotels?name={name}&country={country}

### Hotels

GET /hotels/city/{cityId}

---

## Qué demuestra este proyecto

- Arquitectura de microservicios
- Manejo de fallos entre servicios
- Patrones de resiliencia
- Comunicación desacoplada entre servicios

---

## Cómo ejecutar

1. Levantar Eureka Server
2. Levantar hotels-service
3. Levantar cities-service
4. Probar endpoint de cities-service
5. Apagar hotels-service y volver a probar para ver el Circuit Breaker en acción

---

## Autor

Iván Becerra
