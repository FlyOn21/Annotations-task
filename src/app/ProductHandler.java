package app;

import app.config.Config;
import app.utils.CheckJavaVersion;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProductHandler {



    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        // Check runtime Java version, because part of next implementation work in Java 16 and later
        // If possible runtime in Java less than 16, need to change implementation method getAnnot
        if (!CheckJavaVersion.checkRunIsAllow()) {
            System.out.println(Config.versionNotAllowMessage);
            System.exit(1);
        }
        ProductInfo infoProduct = new ProductInfo();
        Class<? extends ProductInfo> infoClass = infoProduct.getClass();
        getAnnot(infoClass);
        Method method = infoClass.getMethod("getData");
        getAnnot(method);
    }

    static void getAnnot(AnnotatedElement element) {

            Annotation[] annotations = element.getAnnotations();

            for (Annotation annotation : annotations) {
                // This syntax is correct for Java 16 and later
                if (annotation instanceof Product product) {
                    System.out.printf("Product: %s, quota: %d%n", product.name(), product.quota());
                }
            }
    }
}
