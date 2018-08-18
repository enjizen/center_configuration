package com.wanchalermyuphasuk.configuration.controller


import com.wanchalermyuphasuk.configuration.model.Properties
import com.wanchalermyuphasuk.configuration.service.PropertiesService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.*


@RunWith(MockitoJUnitRunner::class)
class ConfigurationControllerTest {

    @InjectMocks
    lateinit var configurationController: ConfigurationController

    @Mock
    lateinit var propertiesServiceMock: PropertiesService


    @Test
    fun `test_getConfiguration`() {


        val application = "api-gateway"
        val profile = "default"

        val propertiesList = mutableListOf(
                Properties(1, "api-gateway", "default", "host", "http://localhost:8989/gate_way")
        )

        `when`(propertiesServiceMock.getProperties(application, profile)).thenReturn(propertiesList)

        configurationController.getConfiguration(application, profile)

        verify(propertiesServiceMock, times(1)).getProperties(anyString(), anyString())

    }

}