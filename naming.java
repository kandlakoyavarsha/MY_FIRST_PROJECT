class M extends Thread
{
   public void run()
  {
    int u=0;
    while(true)
    {
        if(u==10)
        break;
        System.out.println("Running");
        u++;
        
    }
    System.out.println(Thread.currentThread().getName());
    System.out.println(Thread.currentThread().isAlive());
  }
}
class A
{
    public static void main(String...args)
    {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Varsha");
         System.out.println(Thread.currentThread().getName());
         M ob=new M();
         ob.start();
          System.out.println(Thread.currentThread().getName());
          ob.setName("Candy");
           System.out.println(ob.getName());
           System.out.println(ob.isAlive());
            System.out.println(Thread.currentThread().isAlive());

    }
}