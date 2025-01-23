Spring Boot Cache Example (In-memory Cache)
This project demonstrates the use of in-memory caching in a Spring Boot application without specifying an external cache provider, such as Redis or Ehcache. By default, Spring Boot uses ConcurrentMapCache for caching.

Prerequisites
To run this project, you need the following:

Java 8 or later installed
Maven or Gradle for building the project
Features
In-memory caching: Uses Spring Boot's default caching mechanism, ConcurrentMapCache, which stores data in memory.
Cacheable methods: Methods annotated with @Cacheable will have their results cached, avoiding recalculating results for the same input.
Setup Instructions
1. Create a Spring Boot Application
If you haven’t already, you can create a Spring Boot project using Spring Initializr or manually using your preferred build tool (Maven or Gradle).

Include the Spring Web and Spring Boot Starter Cache dependencies.
2. Enable Caching in Your Application
In the main application class, enable caching by using the @EnableCaching annotation. This will tell Spring Boot to activate the caching support.

3. Define a Service with Cacheable Methods
Create a service class with methods annotated with @Cacheable. This annotation marks the method's result for caching based on the provided cache name and key. The result of the first call will be cached, and subsequent calls with the same input will retrieve the cached value without re-executing the method.

4. Implement a Controller to Use the Caching Service
Create a simple REST controller that calls the cacheable service. When you hit the endpoint with the same request multiple times, the method will initially be slow (because of a simulated delay), but subsequent calls will return almost instantly due to the cached result.

5. Run the Application
After setting up the service and controller, you can run the application. Once the application is running, you can test the caching behavior using any HTTP client (Postman, curl, or your browser).

Cache Details
Cache Name: A name used to identify the cache (e.g., "items").
Cache Key: A key used to uniquely identify cached values. This can be based on method parameters, such as an ID.
Testing the Cache
First Request (Slow): The first time a request is made to the endpoint, the method will simulate a delay, such as sleeping for a few seconds.
Subsequent Requests (Fast): The next time the same request is made, the method will return almost instantly, as the result is fetched from the cache.
Limitations of In-memory Cache
Non-persistent: Data is stored only in memory and is lost when the application is restarted.
Not distributed: The cache is local to each application instance. In a distributed environment, each instance will have its own separate cache.
Memory-bound: The cache will consume system memory and should be carefully managed for large data sets.
Optional Improvements
TTL (Time-to-Live): If you need to automatically expire cache entries after a certain time, consider using a more advanced cache provider, such as Redis or Ehcache, which allow for setting expiration policies.
Distributed Caching: For larger-scale applications or microservices, consider integrating a distributed cache provider like Redis to share the cache across instances.
Conclusion
This project demonstrates how to set up basic in-memory caching in a Spring Boot application using the default ConcurrentMapCache provider. It's suitable for simple applications but may not be sufficient for production environments that require persistent or distributed caching solutions.
