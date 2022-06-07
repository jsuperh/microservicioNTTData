package com.microservicio.microservicio.service.impl;

import com.microservicio.microservicio.service.CalculeTipoCambioExterno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculaTipoCambioTest {

    //2. Vamos a Simular la interface de calculadora tipo cambio externo
    @Mock
    CalculeTipoCambioExterno calculeTipoCambioExterno;

    //1. Vamos a indicar a nuestro test q vamos a iniciar el test de la clase
    @InjectMocks
    CalculaTipoCambio calculaTipoCambio;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        when(calculeTipoCambioExterno.calcularTipoCambio(5,8)).thenReturn(10);
    }

    @Test
    void nuestroTipoCambio() {
        Assertions.assertEquals(10,calculaTipoCambio.nuestroTipoCambio(5,8));

    }
}