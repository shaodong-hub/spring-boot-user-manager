//package com.github.user.manager.security.cache;
//
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
//import org.springframework.boot.autoconfigure.cache.CacheProperties;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//import java.util.LinkedHashSet;
//import java.util.List;
//
///**
// * @author 石少东
// * @date 2020-08-24 17:00
// * @since 1.0
// */
//
//
//@Configuration
//public class ConfigRedisCacheManagerJdk {
//
//
//    /**
//     * 生成默认的 RedisCacheManager
//     *
//     * @param cacheProperties                     cacheProperties
//     * @param cacheManagerCustomizers             cacheManagerCustomizers
//     * @param redisCacheConfiguration             redisCacheConfiguration
//     * @param redisCacheManagerBuilderCustomizers redisCacheManagerBuilderCustomizers
//     * @param redisConnectionFactory              redisConnectionFactory
//     * @param resourceLoader                      resourceLoader
//     * @return RedisCacheManager
//     */
//    @Bean("JdkCacheManager")
//    @Primary
//    public RedisCacheManager cacheManager(CacheProperties cacheProperties, CacheManagerCustomizers cacheManagerCustomizers,
//                                          ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration,
//                                          ObjectProvider<RedisCacheManagerBuilderCustomizer> redisCacheManagerBuilderCustomizers,
//                                          RedisConnectionFactory redisConnectionFactory, @NotNull ResourceLoader resourceLoader) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(
//                determineConfiguration(cacheProperties, redisCacheConfiguration, resourceLoader.getClassLoader()));
//        List<String> cacheNames = cacheProperties.getCacheNames();
//        if (!cacheNames.isEmpty()) {
//            builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
//        }
//        redisCacheManagerBuilderCustomizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
//        return cacheManagerCustomizers.customize(builder.build());
//    }
//
//    private RedisCacheConfiguration determineConfiguration(CacheProperties cacheProperties,
//                                                           @NotNull ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration,
//                                                           ClassLoader classLoader) {
//        return redisCacheConfiguration.getIfAvailable(() -> createConfiguration(cacheProperties, classLoader));
//    }
//
//    private org.springframework.data.redis.cache.RedisCacheConfiguration createConfiguration(
//            @NotNull CacheProperties cacheProperties, ClassLoader classLoader) {
//        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer(classLoader)));
//        if (redisProperties.getTimeToLive() != null) {
//            config = config.entryTtl(redisProperties.getTimeToLive());
//        }
//        if (redisProperties.getKeyPrefix() != null) {
//            config = config.prefixKeysWith(redisProperties.getKeyPrefix());
//        }
//        if (!redisProperties.isCacheNullValues()) {
//            config = config.disableCachingNullValues();
//        }
//        if (!redisProperties.isUseKeyPrefix()) {
//            config = config.disableKeyPrefix();
//        }
//        return config;
//    }
//
//
//}
