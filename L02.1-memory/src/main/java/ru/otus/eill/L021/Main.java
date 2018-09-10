package ru.otus.eill.L021;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    private static final int COUNT = 1000000;

    public static void main(String[] args) {
        System.out.println("enter primitive type or full class name of desired object");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String input = sc.next();
            switch (input) {
                case "boolean":
                    System.out.println(checkBoolean());
                    break;
                case "byte":
                    System.out.println(checkByte());
                    break;
                case "char":
                    System.out.println(checkChar());
                    break;
                case "short":
                    System.out.println(checkShort());
                    break;
                case "int":
                    System.out.println(checkInt());
                    break;
                case "float":
                    System.out.println(checkFloat());
                    break;
                case "long":
                    System.out.println(checkLong());
                    break;
                case "double":
                    System.out.println(checkDouble());
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("not a primitive type, maybe the class instance");
                    System.out.println(checkObject(input));
                    break;

            }
        }

    }

    private static long checkBoolean() {
        long freemem = Runtime.getRuntime().freeMemory();
        boolean[] a = new boolean[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = true;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkByte() {
        long freemem = Runtime.getRuntime().freeMemory();
        byte[] a = new byte[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Byte.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkChar() {
        long freemem = Runtime.getRuntime().freeMemory();
        char[] a = new char[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Character.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkShort() {
        long freemem = Runtime.getRuntime().freeMemory();
        short[] a = new short[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Short.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkInt() {
        long freemem = Runtime.getRuntime().freeMemory();
        int[] a = new int[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Integer.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkFloat() {
        long freemem = Runtime.getRuntime().freeMemory();
        float[] a = new float[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Float.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkLong() {
        long freemem = Runtime.getRuntime().freeMemory();
        long[] a = new long[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Long.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkDouble() {
        long freemem = Runtime.getRuntime().freeMemory();
        double[] a = new double[COUNT];
        for (int i=0; i<COUNT; i++) {
            a[i] = Double.MAX_VALUE;
        }
        long freemem_new = Runtime.getRuntime().freeMemory();
        return((freemem - freemem_new) / COUNT);
    }

    private static long checkObject(String name) {
        try {
            Class<?> cl = Class.forName(name);
            Constructor<?> cons = cl.getConstructor();
            long freemem = Runtime.getRuntime().freeMemory();
            Object a[] = new Object[COUNT];
            for (int i=0; i<COUNT; i++) {
                a[i] = cons.newInstance();
            }
            long freemem_new = Runtime.getRuntime().freeMemory();
            return((freemem - freemem_new) / COUNT);
        } catch (ClassNotFoundException e) {
            System.out.println("the is no class you looking for");
            return(0);
        } catch (NoSuchMethodException e) {
            System.out.println("class you're trying to instantiate has no default constructor, aborting");
            return(0);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("something went wrong when we've tried to instantiate the class you specified. Try another class");
            return(0);
        }
    }

}
