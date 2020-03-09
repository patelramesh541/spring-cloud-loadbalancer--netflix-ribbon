# spring-cloud-loadbalancer-netflix-ribbon
Two ways to make client side load balancing
First case,
-> All services register it self to Service Discovery.
-> and client will take service urls from Service discovery and do load balance using `@LoadBalanced` annotation.
Second case,
-> Service should not need to register itself to service discovery. Basically here we do not need service discovery.
-> Client use `RibbonClient` annotation to do load balance at client end. 
