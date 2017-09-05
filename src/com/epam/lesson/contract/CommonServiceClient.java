package com.epam.lesson.contract;

/**
 * @author ABarmin
 */
public class CommonServiceClient {
    public static void main(String[] args) {
        CommonService service = new CommonServiceImpl();
        service.publicMethod("");
    }
}
