# Spring Boot Cache Example (In-memory Cache)

This project demonstrates how to use in-memory caching in a Spring Boot application without specifying an external cache provider (like Redis or Ehcache). By default, Spring Boot uses `ConcurrentMapCache` for caching.

## Prerequisites

To run this project, you need:

- **Java 8 or later**
- **Maven** or **Gradle** for building the project

## Features

- **In-memory caching**: Utilizes Spring Boot's default caching mechanism, `ConcurrentMapCache`, which stores data in memory.
- **Cacheable methods**: Methods annotated with `@Cacheable` will cache the results and avoid recalculating them for the same input.

## Setup Instructions

### 1. Create a Spring Boot Application

You can create a Spring Boot project using [Spring Initializr](https://start.spring.io/) or manually using your preferred build tool (Maven or Gradle).

Include the following dependencies:
- **Spring Web**
- **Spring Boot Starter Cache**

### 2. Enable Caching in Your Application

In your main application class, enable caching by adding the `@EnableCaching` annotation. This will activate Spring Boot's caching support.

### 3. Define a Service with Cacheable Methods

Create a service class and annotate the methods with `@Cacheable`. This will cache the results of the method based on the cache name and key. The first call to the method will store the result in the cache, and subsequent calls with the same input will fetch the result from the cache.

### 4. Implement a Controller to Use the Caching Service

Create a simple REST controller that calls the cacheable service. When you call the endpoint with the same request multiple times, the first request will have a delay (simulated by `Thread.sleep`), but subsequent calls will return almost instantly since the result is cached.

### 5. Run the Application

Run the Spring Boot application. Once it's running, you can test the caching behavior by making repeated requests to the endpoint using tools like Postman, curl, or your browser.

## Cache Details

- **Cache Name**: A name used to identify the cache (e.g., `items`).
- **Cache Key**: A unique key used to store and retrieve cached values (e.g., based on method parameters like an ID).

## Testing the Cache

1. **First Request (Slow)**: The first time you request an item (e.g., `/item?id=1`), the method will simulate a delay (like a database call or processing).
2. **Subsequent Requests (Fast)**: On subsequent requests with the same `id`, the result will be fetched from the cache and returned almost instantly.

## Limitations of In-memory Cache

- **Non-persistent**: Data is stored only in memory and is lost when the application is restarted.
- **Not Distributed**: The cache is local to each application instance, so in a distributed environment, each instance has its own cache.
- **Memory-bound**: The cache will consume memory, which could be problematic for large datasets.

## Optional Improvements

- **TTL (Time-to-Live)**: You can configure automatic expiration of cached entries. For more advanced expiration handling, you can switch to a more sophisticated cache provider, such as Redis or Ehcache.
- **Distributed Caching**: If your application is distributed, consider using a distributed cache provider like Redis to ensure cache consistency across instances.

## Conclusion

This example demonstrates how to use basic in-memory caching in a Spring Boot application with the default `ConcurrentMapCache`. This setup is suitable for simple applications but might not meet the needs of production environments requiring persistent or distributed caching solutions.

---

**Note**: If you need more advanced features, like cache expiration or distributed caching, you can integrate with external cache providers like Redis, Ehcache, or Caffeine.
