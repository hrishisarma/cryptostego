
package cryptostegoproject;

import static cryptostegoproject.Encode.imageselect;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Decode 
{
    public static void main(String args[])
    {
       try
        {
            String imagepath="";
            imagepath=imageselect();
            int x2=2;
            JFrame frame1 = new JFrame();
            int x3=1;
            
            
             if (!imagepath.equals("")) 
             {
             File fileName1=new File(imagepath);
            BufferedImage image1=null,new_image1=null;
            new_image1=ImageIO.read(fileName1);
            image1=new BufferedImage(new_image1.getWidth(), new_image1.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics1 = image1.createGraphics();
      graphics1.drawImage(new_image1,0,0,null);
      graphics1.dispose();
      int w1=image1.getWidth();
      int h1=image1.getHeight();
      //System.out.println(x);
     // JFrame frame1 = new JFrame();
        frame1.setSize(w1,h1);
        frame1.setTitle("Selected Image");
        //JLabel label = new JLabel("Hello, World!");
        ImageIcon image2 = new ImageIcon(imagepath);
        //System.out.println(image2);
        JLabel imageLabel = new JLabel(image2);
        //label.setOpaque(true);
     //   label.setBackground(myColor);
        frame1.add(imageLabel);
        //frame1.add(label);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
             x2=JOptionPane.showConfirmDialog(null,
"Have you selected the correct image?", "Confirm", JOptionPane.YES_NO_OPTION);
             //imageLabel.removeAll();
             // frame1.dispose();
             frame1.remove(imageLabel);
             x3=0;
          
             }
             
             
            while(x2!=0)
            { 
                if(x3==1)
                {
                    break;
                }
              imagepath=imageselect();  
              if (!imagepath.equals("")) 
              {
               File fileName3=new File(imagepath);
            BufferedImage image3=null,new_image3=null;
            new_image3=ImageIO.read(fileName3);
            image3=new BufferedImage(new_image3.getWidth(), new_image3.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics3 = image3.createGraphics();
      graphics3.drawImage(new_image3,0,0,null);
      graphics3.dispose();
      int w3=image3.getWidth();
      int h3=image3.getHeight();
      //System.out.println(x);
     // JFrame frame3 = new JFrame();
      
        frame1.setSize(w3,h3);
        frame1.setTitle("Selected Image");
        ImageIcon image4 = new ImageIcon(imagepath);
        JLabel imageLabel3 = new JLabel(image4);
        frame1.add(imageLabel3);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
            x2=JOptionPane.showConfirmDialog(null,
"Have you selected the correct image?", "Confirm", JOptionPane.YES_NO_OPTION);
            frame1.remove(imageLabel3);
              }
              else
              {
                  break;
              }
            }
            
            
            
            
            //if(x2==0)
            //{
                frame1.dispose();
            //}
           
           // System.out.println("ok: "+x2);

    if (!imagepath.equals("")) 
    {
      //System.out.println(x);
    
        
        String pass="";
        pass=enterpass(imagepath);
//        System.out.println(pass.length());
        while((pass.length())==0)
        {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            pass=enterpass(imagepath);
        }
        
      //  while((pass.length()>14))
    //    {
    //        JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong Input", JOptionPane.ERROR_MESSAGE);
     //       pass=enterpass();
     //   }
        
        if((pass.length()>0))
        {
                
                 byte[] b= pass.getBytes();
                 String s="";
                for(int i=0; i<b.length; i++)
                {
                    int v=b[i];
                    String t=Integer.toBinaryString(v);
                    int cal=8-t.length();
                    if(cal!=0)
                    {
                            for(int h=0;h<cal;h++)
                            {
                                t="0"+t;
                            }
                    }
                    s+=t;
                }
                System.out.println("Enter'd passwrd: "+s); 
                String smsg1=getPassandLength(s,imagepath);
                
                if(smsg1=="")
                {
                    //JOptionPane.showMessageDialog(null, "Password is wrong", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
               // System.out.println(smsg);
                String smsg=getmsgfromcode(smsg1);
               JOptionPane.showMessageDialog(null,"Decoding successful. Decoded Message is \n"+smsg+" ","Message Decode",JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 
    
    
    
        public static String decodemessage(int limit, String ip)
        {
            String msg="";
    try
    {
        
         // File fileName=new File("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\Encode\\src\\cryptostegoproject\\steganography.png");
        File fileName=new File(ip);
          BufferedImage image=null,new_image=null;
          new_image=ImageIO.read(fileName);
           image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
           Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
           int im=0,jm=0,t=0;
           int x=0,Width,Height;
           Width=image.getWidth();
           Height=image.getHeight();
            int data[]=new int[limit+4];
           while(t<limit)
           {
               Color col = new Color(image.getRGB(im,jm), true);
     //System.out.println(image.getRGB(im,jm));
               
              int p=0;
            int rgb[]=new int[24];
           
        int red = col.getRed();
        int green = col.getGreen();
        int blue = col.getBlue();
      // System.out.println("Red:"+ red+"Green:"+ green+"Blue:"+ blue);
        
        int[] arr = {red, green, blue};
        
        for (int i : arr)
{
            int z=i;
           // System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z));
              //      System.out.println(temp);
                    
                    int test[]=new int[8];
                    
                    
                        int n=temp;
                        int k=0;
                        while(n>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r=n%10;
                            n=n/10;
                            
                            if(k!=0)
                            {
                                int j=k;
                                while(j!=0)
                                {
                                test[j]=test[j-1];
                                 j--;
                                }
                                test[0]=r;
                      //          System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                test[k]=r;
                        //        System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                           int q=test.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    test[q]=test[q-1];
                                    q--;
                                 }
                                test[0]=0;
                                k++;
                            }
            
                            for(int u=0;u<test.length;u++)
                       {
                           rgb[p]=test[u];
                          // System.out.print(test[u]);
                           p++;
                       }

}
      int[] arr1 = {6,7,14,15,22,23};
        for(int v: arr1)
        {
            data[x]=rgb[v];
           // System.out.println(data[x]);
            x++;
        }
t=t+6;

if(jm==Height)
{
    jm=-1;
    im++;
}

jm++;


           }
           
           int u=limit;
           //int z=(u/8);
           int s=0,e=8;
           double sum=0;
           while(e<=u)
           {
               
               int pow=0;
               for(int i=(e-1);i>=s;i--)
               {
                    if(data[i]==0)
            {
                sum+=0;
            }
            else
            {
                sum=sum+(1*Math.pow(2,pow));
            }
            pow++;
               }
              //System.out.println(sum);
              
               s+=8;
               e+=8;
               //Double d=new Double(sum);
               //int y=d.intValue();
               int y=(int)sum;
               System.out.print((char)y);
               msg+=(char)y;
               sum=0;
           }
           
           
    }
    catch (Exception e)
    {
       e.printStackTrace();    
    }
    
    return msg;
    }
    
    
    
    
    
    
    
    
    
    public static String getPassandLength(String pass, String x1)
    {
        String m="";
        try
        {
            //File fileName=new File("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\Encode\\src\\cryptostegoproject\\steganography.png");
            File fileName=new File(x1);
          BufferedImage image=null,new_image=null;
          new_image=ImageIO.read(fileName);
           image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
           Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      
      //extract passwrd length
      int ip=image.getWidth()-1;
      int yp=image.getHeight()-1;
      Color col1 = new Color(image.getRGB(ip,yp), true);
       int red1 = col1.getRed();
        int green1 = col1.getGreen();
        //int blue1= col1.getBlue();
        int rgb1[]=new int[16];
        int[] arr1 = {red1, green1};
        int p1=0;
        for (int i : arr1)
{
            int z=i;
           // System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z));
              //      System.out.println(temp);
                    
                    int test[]=new int[8];
                    
                    
                        int n=temp;
                        int k=0;
                        while(n>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r=n%10;
                            n=n/10;
                            
                            if(k!=0)
                            {
                                int j=k;
                                while(j!=0)
                                {
                                test[j]=test[j-1];
                                 j--;
                                }
                                test[0]=r;
                      //          System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                test[k]=r;
                        //        System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                            int q=test.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    test[q]=test[q-1];
                                    q--;
                                 }
                                test[0]=0;
                                k++;
                            }
            
                            for(int u=0;u<test.length;u++)
                       {
                           rgb1[p1]=test[u];
                         //  System.out.print(rgb[p]);
                           p1++;
                       }
                            //System.out.println("");
            }
        p1=0;
        int plen[]=new int[4];
        int parr[]={6,7,14,15};
        
        for(int i:parr)
        {
            plen[p1]=rgb1[i];
            p1++;
        }
        int pow1=0;
        double sum1=0;
        for(int i=3;i>=0;i--)
               {
                    if(plen[i]==0)
            {
                sum1+=0;
            }
            else
            {
                sum1=sum1+(1*Math.pow(2,pow1));
            }
            pow1++;
           }
   //sump length of password     
        int sump=(int)sum1;
            System.out.println(sump);
        
      
      
      int im=0,jm=0,t=14+(sump*8);
      int c=t;
           int x=0,Width,Height;
           Width=image.getWidth();
           Height=image.getHeight();
           im=Width-1;
           jm=Height-1;
            int data[]=new int[18+(sump*8)];
            int d=0;
           
           while(t>0)
           {
               
                Color col = new Color(image.getRGB(im,jm), true);
     //System.out.println(image.getRGB(im,jm));
               
              int p=0;
            int rgb[]=new int[24];
           
        int red = col.getRed();
        int green = col.getGreen();
        int blue = col.getBlue();
      // System.out.println("Red:"+ red+"Green:"+ green+"Blue:"+ blue);
        
        int[] arr = {red, green, blue};
        
        for (int i : arr)
{
            int z=i;
           // System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z));
              //      System.out.println(temp);
                    
                    int test[]=new int[8];
                    
                    
                        int n=temp;
                        int k=0;
                        while(n>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r=n%10;
                            n=n/10;
                            
                            if(k!=0)
                            {
                                int j=k;
                                while(j!=0)
                                {
                                test[j]=test[j-1];
                                 j--;
                                }
                                test[0]=r;
                      //          System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                test[k]=r;
                        //        System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                            int q=test.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    test[q]=test[q-1];
                                    q--;
                                 }
                                test[0]=0;
                                k++;
                            }
            
                            for(int u=0;u<test.length;u++)
                       {
                           rgb[p]=test[u];
                         //  System.out.print(rgb[p]);
                           p++;
                       }
                            //System.out.println("");
            }
        
        
       
        
        int[] arr2 = {6,7,14,15,22,23};
        for(int v: arr2)
        {
            data[d]=rgb[v];
            //System.out.println(data[x]);
            d++;
        }
t=t-6;

if(jm==0)
{
    jm=Height-1;
    im--;
}

jm--;     
           } 
            System.out.println("");
           for(int u=0;u<data.length;u++)
           {
               System.out.print(data[u]);
           }
           
           
            System.out.println("");
          // String x1=Arrays.toString(data);
            //System.out.println("x1: "+x1);
           int passwrd[]=new int[sump*8];
           int msglen[]=new int[8];
           int passtry[]=new int[2];
           double sum=0;
           int k=sump*8;
           
           passtry[0]=data[4];
           passtry[1]=data[5];
           
           for(int w=0;w<k;w++)
           {
               passwrd[w]=data[w+6];
           }
           
           int w1=6+k;
           for(int w=0;w<8;w++)
           {
               msglen[w]=data[w1];
               w1++;
           }
            System.out.println("password try: "+passtry[0]+passtry[1]);
             
            double sumptry=0; // to store decimal value of the 2's complement
    int pow2=0;
    for(int j=1;j>=0;j--)
    {
            if(passtry[j]==0)
            {
                sumptry+=0;
            }
            else
            {
                sumptry+=(1*Math.pow(2,pow2));
            }
            pow2++;
        }
            System.out.println("");
            int d1=(int)sumptry;
            //d1++;
            System.out.println("d1 ha: "+d1);
            
            if(d1==0)
            {
                 JOptionPane.showMessageDialog(null, "Wrong password attempted 3 or more times.\nThe message cannot be extracted!", "Attempts Exceeded!", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
           String r="";
           
           for(int u=0;u<passwrd.length;u++)
           {
               System.out.print(passwrd[u]);
               r+=String.valueOf(passwrd[u]);
           }
           
            System.out.println("");
            
            int pow=0;
            
           for(int u=0;u<msglen.length;u++)
           {
               System.out.print(msglen[u]);
               
           }
           
            System.out.println("");
                for(int i=7;i>=0;i--)
               {
                    if(msglen[i]==0)
            {
                sum+=0;
            }
            else
            {
                sum=sum+(1*Math.pow(2,pow));
            }
            pow++;
           }
                
            int sumf=(int)sum;
            sumf=sumf*8;
              // System.out.println(sumf);
           
           
            System.out.println("");
            System.out.println("r: "+r);
            System.out.println("pass: "+pass);
           
         /*  String x1=Arrays.toString(passwrd);
           
           x1.replace("[","");
           x1.replace("]","");
           x1.replace(", ","");
           
           System.out.println(x1);
           */
            System.out.println(sumf);
           if(pass.equals(r))
           {
               //System.out.println("Password Correct!!!!");
                JOptionPane.showMessageDialog(null, "You have entered Correct Password", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
               m=decodemessage(sumf,x1);
           }
           else
           {
               System.out.println("Wrong Password!!!!");
               d1--;
               int tp=d1;
               System.out.println(d1);
               int ptryleft[]=new int[2];
                 int g=1;
                while(tp>0)
                {
                    ptryleft[g]=tp%2;
                    g--;
                    tp=tp/2;
                }
                g=0;
                /*while(g<2)
                {
                System.out.print(ptryleft[g]);
                g++;
                }*/
                 fileName=new File(x1);
          image=null;
          new_image=null;
          new_image=ImageIO.read(fileName);
           image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
           graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      
      //extract passwrd length
      ip=image.getWidth()-1;
      yp=image.getHeight()-1;
      col1 = new Color(image.getRGB(ip,yp), true);
       red1 = col1.getRed();
        green1 = col1.getGreen();
        int blue1= col1.getBlue();
        int rgb12[]=new int[24];
        int arr12[] ={red1, green1,blue1};
        p1=0;
        for (int i : arr1)
{
            int z=i;
           // System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z));
              //      System.out.println(temp);
                    
                    int test[]=new int[8];
                    
                    
                        int n=temp;
                        int k1=0;
                        while(n>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r1=n%10;
                            n=n/10;
                            
                            if(k1!=0)
                            {
                                int j=k1;
                                while(j!=0)
                                {
                                test[j]=test[j-1];
                                 j--;
                                }
                                test[0]=r1;
                      //          System.out.print(test[0]);
                                k1++;
                            }
                            else
                            {
                                test[k1]=r1;
                        //        System.out.print(test[k]);
                                k1++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                            int q=test.length;// q=8
                            q=q-1;
                            k1=k1-1;//k gives the actual length
                         while(k1!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k1+1;
                                while(q!=0)
                                {
                                    test[q]=test[q-1];
                                    q--;
                                 }
                                test[0]=0;
                                k1++;
                            }
            
                            for(int u=0;u<test.length;u++)
                       {
                           rgb12[p1]=test[u];
                         //  System.out.print(rgb[p]);
                           p1++;
                       }
                            //System.out.println("");
            }
        p1=23;
         rgb12[22]=ptryleft[0];
         rgb12[23]=ptryleft[1];
         
          int k2=0;
    while(rgb12[p1]==0)
    {
        k2++;
        p1--;
    }
    
    p1=23-k2;
    
    for(int j=0;j<p1;j++)
    {
        if(rgb12[j]==0)
        {
            rgb12[j]=1;
        }
        else
            rgb12[j]=0;
    }
     double sumpt=0; // to store decimal value of the 2's complement
    int powp=0;
    for(int j=23;j>=0;j--)
    {
            if(rgb12[j]==0)
            {
                sumpt+=0;
            }
            else
            {
                sumpt=sumpt+(1*Math.pow(2,powp));
            }
            powp++;
        }
            System.out.println("");
            int ptry=(int)sumpt;
            
            image.setRGB(ip,yp,-ptry);
             ImageIO.write(image, "png", new File(x1));
    
                JOptionPane.showMessageDialog(null, "Wrong password!!!\n You have "+d1+" attempts left", "ERROR!", JOptionPane.ERROR_MESSAGE);
           }
        
            }
        }
       
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return m;
    }
    
public static String getmsgfromcode(String m)
{
    String f="";
    try
    {
        System.out.println("Code s: "+m);
        String words="C:\\Users\\Progyan\\Documents\\NetBeansProjects\\CompressionStarNT\\src\\dictionary.txt";
           // String newfile="C:\\Users\\Progyan\\Documents\\NetBeansProjects\\CompressionStarNT\\src\\newwords.txt";
            String newWord="";
            String coddedForm="";
            String newCode="";
            int Found=0;
            
            File file= new File(words);
            
            FileInputStream fis = new FileInputStream(file);
            FileInputStream fis1 = new FileInputStream(file);
            
            BufferedReader br= new BufferedReader(new InputStreamReader(fis));
            BufferedReader br1= new BufferedReader(new InputStreamReader(fis1));
        
            //File file1= new File(newfile);
            
           // FileInputStream fis2 = new FileInputStream(file1);
            //FileInputStream fis3 = new FileInputStream(file1);
            
            //BufferedReader br2= new BufferedReader(new InputStreamReader(fis2));
            //BufferedReader br3= new BufferedReader(new InputStreamReader(fis3));
        
            String strLine;
            String strLine1;
            
            String newStr;
            String newStr1;
            int lines=0;
            
            
            while((strLine = br.readLine())!=null) 
            {
                newStr=strLine.trim();
                if(newStr!=null)
                    lines++;
            }
            
            br.close();
            
            
            String[] dicWords=new String[lines];
            String[] codeWords=new String[lines];
            String[] dicData=new String[2];
            
            int i=0;
            
            while((strLine1 = br1.readLine())!=null) 
            {
                newStr1=strLine1.trim();
                
                if(newStr1!=null)
                {
                    dicData=newStr1.split(":");
                    
                    dicWords[i]=dicData[0].trim();
                    codeWords[i]=dicData[1].trim();
                    i++;
                    
                    
                }
            }
            
            br1.close();
            
             int count=0;
        for(int i1=0;i1<m.length();i1++)
        {
            if(m.charAt(i1)==32)
            {
                count++;
            }
        }

         String cwrds[]=new String[m.length()-count];
        cwrds=m.split(" ");
        System.out.println("code 333");
        for(int i1=0;i1<cwrds.length;i1++)
        {
            int found=1;
            System.out.println(cwrds[i1]);
            
            for(int y=0;y<codeWords.length;y++)
            {
                if(cwrds[i1].equals(codeWords[y]))
                {
                    f+=dicWords[y];
                    break;
                }
                
                if(y==codeWords.length-1)
                {
                    found=0;
                }
            }
            
            if(found==0)
            {
                cwrds[i1]=cwrds[i1].replace("1","");
                System.out.println("lol "+cwrds[i1]);
                byte[]b=cwrds[i1].getBytes();
                for(int x1=0; x1<b.length; x1++)
                    {
                        int w=b[x1];
                        w=w-3;
                        b[x1]=(byte)w;
                    }
                
                for(int x1=0; x1<b.length; x1++)
                    {
                        int i2=b[x1];
                        f+= new Character((char) i2).toString();
                    }
            }
            
            f+=" ";        
        }
        
        
        
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return f;
}


 public static String imageselect()
        {
             String imagepath="";
            try{
               JFileChooser fileopen = new JFileChooser();
            javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("png or gif images","png","gif");
      fileopen.setFileFilter(filter);


    int ret = fileopen.showDialog(null, "Choose Image");

    if (ret == JFileChooser.APPROVE_OPTION) 
    {
      File file = fileopen.getSelectedFile();
      
      imagepath=file.getPath();
            
        }
   
            }
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
    
        return imagepath;
        }
 
     public static String enterpass(String x1)
        {
           String x=""; 
            try
            {
             File fileName=new File(x1);
          BufferedImage image=null,new_image=null;
          new_image=ImageIO.read(fileName);
           image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
           Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      
      //extract passwrd length
      int ip=image.getWidth()-1;
      int yp=image.getHeight()-1;
      Color col1 = new Color(image.getRGB(ip,yp), true);
       //int red1 = col1.getRed();
        //int green1 = col1.getGreen();
        int blue1= col1.getBlue();
       // int rgb1[]=new int[8];
       // int[] arr1 = {red1, green1};
        int p1=0;
            int z=blue1;
           // System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z));
              //      System.out.println(temp);
                    
                    int test[]=new int[8];
                    
                    
                        int n=temp;
                        int k=0;
                        while(n>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r=n%10;
                            n=n/10;
                            
                            if(k!=0)
                            {
                                int j=k;
                                while(j!=0)
                                {
                                test[j]=test[j-1];
                                 j--;
                                }
                                test[0]=r;
                      //          System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                test[k]=r;
                        //        System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                            int q=test.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    test[q]=test[q-1];
                                    q--;
                                 }
                                test[0]=0;
                                k++;
                            }
    
                         int passtry[]=new int[2];
                         passtry[0]=test[6];
                         passtry[1]=test[7];
    double sumptry=0; // to store decimal value of the 2's complement
    int pow2=0;
    for(int j=1;j>=0;j--)
    {
            if(passtry[j]==0)
            {
                sumptry+=0;
            }
            else
            {
                sumptry+=(1*Math.pow(2,pow2));
            }
            pow2++;
        }
            System.out.println("");
            int d1=(int)sumptry;
                    /*        for(int u=0;u<test.length;u++)
                       {
                           rgb1[p1]=test[u];
                         //  System.out.print(rgb[p]);
                           p1++;
                       }
                            //System.out.println("");
            */
            
            if(d1==0)
            {
                 JOptionPane.showMessageDialog(null, "Wrong password attempted 3 or more times.\nThe message cannot be extracted!", "Attempts Exceeded!", JOptionPane.ERROR_MESSAGE);
                 System.exit(0);
            }     
            else
            {
            x=(String)JOptionPane.showInputDialog(null,"Enter Password.\n You have "+d1+" attempts left","Password Input",JOptionPane.PLAIN_MESSAGE);
            }
//            System.out.println(x.length());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return x;
        }
}
