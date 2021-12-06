package pers.vv.study.test.mockito;

public class MyService {

    private final ExternalService externalService;

    public MyService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public void m1() {
        externalService.m1();
    }

    public void m2() {
        try {
            externalService.m1();
        } catch (Exception e) {
            externalService.m2();
        }
    }
}
