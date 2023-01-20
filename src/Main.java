public class Main {

    //multithreading create using 2 ways
    //1- extend Thread
    //2- implement Runnable interface

    //play with main thread
    static class Ram{
        public void print() throws InterruptedException {
            for(int i=0;i<5;i++) {
                System.out.println("Ram");
                Thread.sleep(10);
            }
        }
    }
    //Thread define using 2 way
    //1 - extend thread

    static class Ronaldo1 extends Thread{
        @Override
        public void run(){
            for(int i=0;i<5;i++){
                System.out.println("Ronaldo Heavy");
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //2 - implements Runnable interface (In java multiple inheritance is not availabel
    // thats why we use this to extend a another class and aquire there property)

    static class ROnaldo implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<5;i++){
                System.out.println("Ronaldo");
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        //same thread main 1
        Ram ram = new Ram();
        ram.print();//effect on main thread
        // implements Runnable Thread object
        ROnaldo r =new ROnaldo();
        Thread t = new Thread(r);
        t.start();

        // extends Thread object
        Ronaldo1 ro = new Ronaldo1();
        ro.start();
        for(int i=0;i<5;i++) {
            System.out.println("Mexico");
            Thread.sleep(1);//effect on main thread
        }


        System.out.println("Hello world!");
    }
}