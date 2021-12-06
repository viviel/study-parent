package pers.vv.study.test.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class MockitoTest {

    private MyService myService;

    private ExternalService externalService;

    @BeforeEach
    void setUp() {
        externalService = mock(ExternalService.class);
        myService = new MyService(externalService);
    }

    @Test
    void t1() {
        myService.m1();
        verify(externalService).m1();
        verifyNoMoreInteractions(externalService);
    }

    @Test
    void t2() {
        doThrow(IllegalArgumentException.class).when(externalService).m1();
        myService.m2();
        verify(externalService).m1();
        verify(externalService).m2();
        verifyNoMoreInteractions(externalService);
    }
}
