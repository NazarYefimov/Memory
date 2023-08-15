package org.example;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class StringTransformer {
    public static String transform(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        LoggingAspect aspect = new LoggingAspect();
        LoggingControlMBeanImpl controlMBean = new LoggingControlMBeanImpl(aspect);
        ObjectName objectName = new ObjectName("org.example:type=LoggingControl");
        mBeanServer.registerMBean(controlMBean, objectName);

        controlMBean.enableLogging();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String transformed = transform(input);
        System.out.println("Transformed string: " + transformed);

        controlMBean.disableLogging();
    }
}