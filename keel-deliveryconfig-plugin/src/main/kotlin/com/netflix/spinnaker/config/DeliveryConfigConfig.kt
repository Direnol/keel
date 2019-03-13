package com.netflix.spinnaker.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.spinnaker.keel.api.deliveryconfig.DeliveryConfig
import com.netflix.spinnaker.keel.deliveryconfig.resource.DeliveryConfigHandler
import com.netflix.spinnaker.keel.front50.Front50Service
import com.netflix.spinnaker.keel.plugin.ResourceValidator
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty("keel.plugins.deliveryConfig.enabled")
//I wasn't sure I hated the name DeliveryConfig until this happened
class DeliveryConfigConfig {

  @Bean
  fun deliveryConfigHandler(
    front50Service: Front50Service,
    objectMapper: ObjectMapper,
    validators: List<ResourceValidator<*>>
  ) = DeliveryConfigHandler(
      front50Service,
      objectMapper,
      validators
  )
}