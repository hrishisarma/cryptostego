package cryptostegoproject;
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
public class Encode {

    public static void main(String[] args) 
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
      
          /*  File fileName=new File(imagepath);
            BufferedImage image=null,new_image=null;
            new_image=ImageIO.read(fileName);
            image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      int w=image.getWidth();
      int h=image.getHeight();
      int pixel=w*h;
      int tpixel=pixel*6;
      pixel=(tpixel/8);
      pixel=pixel-124;
            System.out.println(pixel);*/
            //Enter plain text message
            //JFrame frame =new JFrame();
            String x="";
           // x = (String)JOptionPane.showInputDialog(frame,"Enter your message (maximum of 256 characters) :\n","Message Input",JOptionPane.PLAIN_MESSAGE);
            x=entermsg();
            while(x.length()==0)
            {
                JOptionPane.showMessageDialog(null, "Message cannot be of length zero", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                x=entermsg();
                //frame.dispose();
                
            }
            
            //else
            if(x.length()!=0)
            {
           // System.out.println("enter plain text: ");
            //String x=new Scanner(System.in).nextLine();
            
            //System.out.println("enter password (length min(4) and max(14): ");
            //String pass=new Scanner(System.in).nextLine();
            
            String pass =enterpass();
            
            System.out.println(x);
            //int length = x.length();
            
            //encodePassandLength(pass);
           
            while((pass.length()<4))
            {
                //System.out.println("Enter password of length minimum 4 and maximum 14");
                JOptionPane.showMessageDialog(null, "Password must be of minimum length 4", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                pass=enterpass();
                //frame.dispose();
            }
            
             while((pass.length()>14))
            {
                //System.out.println("Enter password of length minimum 4 and maximum 14");
                JOptionPane.showMessageDialog(null, "Password must be of maximum length 14", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                pass=enterpass();
                //frame.dispose();
            }
            
             if((pass.length()>=4) && (pass.length()<=14))
            {
            encodePlainText(x,pass,pass.length(),imagepath);
            //frame.dispose();
            }
            
            }
    }
        }
        
           catch(Exception  e)
      {
          System.out.println(e);
      }
  }
    
    public static void encodePlainText(String x, String pass, int passlen, String ip)
    {
        try
        {
        String words="C:\\Users\\Progyan\\Documents\\NetBeansProjects\\CryptoStegoPROJECT\\src\\cryptostegoproject\\dictionary.txt";
            File file= new File(words);
    
            FileInputStream fis = new FileInputStream(file);
            FileInputStream fis1 = new FileInputStream(file);
            
            BufferedReader br= new BufferedReader(new InputStreamReader(fis));
            BufferedReader br1= new BufferedReader(new InputStreamReader(fis1));
            
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
             String[] breakOriginel=x.split(" ");
             String bkStr="";
        int spaceFound=0;
        int Found;
        String coddedForm="",newWord;
        
        for(int j=0;j<breakOriginel.length;j++)
        {
            Found=0;
            
            if((j!=0) && (spaceFound==0))
                coddedForm=coddedForm+" ";
            
            bkStr=breakOriginel[j];
            
                int r=0;
                for(r=0;r<dicWords.length;r++)
                {
                    
                    if((bkStr.trim()).equals(dicWords[r].trim()))
                    {
                        Found=1;
                        spaceFound=0;
                        coddedForm=coddedForm+codeWords[r];
                        break;
                    }
                    
                }
                
                if(Found==0)
                {
                    if((breakOriginel[j].trim().isEmpty()))
                    {
                        coddedForm=coddedForm+" ";
                        spaceFound=1;
                    }
                    else
                    {
                        
                        spaceFound=0;
                        String aChar="";
                        newWord=bkStr.trim();
                        
                        //crypto algo for words not found
                         byte[] b= newWord.getBytes();
                         for(int x1=0; x1<b.length; x1++)
                    {
                        int w=b[x1];
                        w=w+3;
                        b[x1]=(byte)w;
                    }
                    for(int x1=0; x1<b.length; x1++)
                    {
                        int i1=b[x1];
                        aChar += new Character((char) i1).toString();
                        
                    }
                    aChar+="1";
                         
                        coddedForm=coddedForm+aChar;
                    }
                }
            }
        String cf=coddedForm.replace("1","");
            System.out.println("coded form of secret message: "+cf);
            JOptionPane.showMessageDialog(null,"Coded form of Message is \n"+cf+" ","Message Decode",JOptionPane.INFORMATION_MESSAGE);
            int smsglength=coddedForm.length();
            encodePassandLength(pass,smsglength,passlen,ip);
           cipherTextToBinary(coddedForm,ip);
        }
        
         catch(Exception  e)
      {
          System.out.println(e);
      }
             
    }
    
    public static void cipherTextToBinary(String x, String ip)
    {
        byte[] b= x.getBytes();
        int test[]=new int[8];//temporary array to store 8 bits of a single character
        int data[]=new int[b.length*8];//stores binary code of secret message
        int z=0;
                for(int i=0; i<b.length; i++)
                {
                    int v=b[i];
                   // System.out.println(v);
                    //System.out.println(Integer.toBinaryString(v));
                        int temp=Integer.parseInt(Integer.toBinaryString(v));
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
                         //System.out.println("");
                      /*  for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                       //System.out.println("");
                       
                       for(int u=0;u<test.length;u++)
                       {
                           data[z]=test[u];
                           z++;
                       }
                }

                System.out.print("data:");
                for(int u=0;u<data.length;u++)
                     {
                           System.out.print(data[u]);
                       }
                System.out.println("");
               // System.out.println(data.length);
                int h=data.length;
                embedSecretMessage(data, h,ip);
    }
    
    public static void embedSecretMessage(int data[] ,int l,String x)
    {
                int pixel[][],Width,Height,pix;
        try
        {
            
            //cryptostegoproject.NewJFrame.main(null);
             
            //File fileName=new File("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\Encode\\src\\cryptostegoproject\\steganography.png");
    File fileName=new File(x);
            BufferedImage image=null,new_image=null;
            new_image=ImageIO.read(fileName);
            /* BufferedImage dst = new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    dst.getGraphics().drawImage(new_image, 0, 0, null);
		
    System.out.println("Before: " + dst.getRGB(1, 1));
    //int x=-5263980;
    //dst.setRGB(0, 0,x);
    System.out.println("After : " + dst.getRGB(1, 2));
    
    ImageIO.write(dst, "png", new File("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\Encode\\src\\cryptostegoproject\\steganography.png"));
            */
          //  System.out.println(new_image.getHeight()+"  , "+new_image.getWidth());
      image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      pixel= new int[image.getWidth()][image.getHeight()];
      	Width=image.getWidth();
        int e=1,pi=0,pj=0;
		Height=image.getHeight();
                pix=l/6;
               
                if(l%6!=0)
                {
                    pix=pix+1;
                }
                int imagedata[]=new int[pix];
                int id=0;
                
    /*            
                pj=pix;
                
                
                if(pj>Width)
                {
                    pi=pj/Width;
                    pj=pj-(pi*Width);
                }
                
		for(int i=0;i<Width;i++)
		{
			for(int j=0;j<Height;j++)
			{
				pixel[i][j]=image.getRGB(i, j);
			}
		}
                
  */
     //           System.out.println("[0][0]: "+image.getRGB(0, 0));
       //         System.out.println("[0][1]: "+image.getRGB(0, 1));
                int t=1;
                int im=0,jm=0;
                while(t<=pix)
                {
                   // System.out.println("["+im+"]["+jm+"] : "+image.getRGB(im, jm));
                    Color col = new Color(image.getRGB(im,jm), true);
                 // System.out.println(image.getRGB(pi,pj));
                int red = col.getRed();
                int green = col.getGreen();
                int blue = col.getBlue();
      //     System.out.println("Red:"+red+"Green:"+green+"Blue:"+blue);
                    
                    System.out.println("["+im+"]["+jm+"] : Red:"+red+"  Green:"+green+"  Blue:"+blue);
                    jm++;
                    if(jm==Height-1)
                    {
                        im++;
                        jm=-1;
                    }
                    t++;
                }
                im=0;
                jm=0;
                t=1;
                int di=0;
  while(e<=l)
  {
      
      
Color col = new Color(image.getRGB(pi,pj), true);
     // System.out.println(image.getRGB(pi,pj));
int red = col.getRed();
int green = col.getGreen();
int blue = col.getBlue();
 //           System.out.println("Red:"+red+"Green:"+green+"Blue:"+blue);
            
          //  image.setRGB(1, 1,5262978 );
            
            //convert to binary
            int[] arr = {red, green, blue};
            int p=0;
            int rgb[]=new int[24];
for (int i : arr)
{
            int z=i;
            //System.out.println(z);
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
                //           System.out.print(test[u]);
                           p++;
                       }
            
       //     System.out.println("");
}    

    System.out.println("rgb before embed["+pi+"]["+pj+"]: ");
    for(int j=0;j<24;j++)
    {
            System.out.print(rgb[j]);
            if((j==7)||(j==15))
            {
                System.out.print(" ");
            }
        }
      System.out.println("");
  //  for(int dj=0;dj<data.length;dj++)
    //{
      //  System.out.print(data[dj]);
    //}
    
    
    if(di<data.length) // embed in red  
    {
        rgb[6]=data[di];
        rgb[7]=data[di+1];
        di=di+2;
    }
     
    if(di<data.length) //embed in green
    {
        rgb[14]=data[di];
        rgb[15]=data[di+1];
        di=di+2;
    }
    
    if(di<data.length) //embed in blue
    {
        rgb[22]=data[di];
        rgb[23]=data[di+1];
        di=di+2;
    }
    
    System.out.println("rgb after embed["+pi+"]["+pj+"]: ");
    
        for(int j=0;j<24;j++)
    {
            System.out.print(rgb[j]);
            if((j==7)||(j==15))
            {
                System.out.print(" ");
            }
        }
      System.out.println("");
    // converting to 2's compement...starting from right the while loop runs until we encounter a '1'
        p=23;
        int k=0;
    while(rgb[p]==0)
    {
        k++;
        p--;
    }
    
    p=23-k;
    
    for(int j=0;j<p;j++)
    {
        if(rgb[j]==0)
        {
            rgb[j]=1;
        }
        else
            rgb[j]=0;
    }
    
            //System.out.println("");
    //print out the 2's complement
 //   for(int j=0;j<24;j++)
   // {
     //       System.out.print(rgb[j]);
       // }
    double sum=0; // to store decimal value of the 2's complement
    int pow=0;
    for(int j=23;j>=0;j--)
    {
            if(rgb[j]==0)
            {
                sum+=0;
            }
            else
            {
                sum=sum+(1*Math.pow(2,pow));
            }
            pow++;
        }
            System.out.println("");
            int d=(int)sum;
            //System.out.println(d);
            
            imagedata[id]=d; // imagedata[] stores 2's complement of rgb values of different pixels
            id++;
            
            if(pj==Height-1)
            {
                pi++;
                pj=-1;
            }
            pj++;
            e=e+6;
 } 
  pi=0;
  pj=0;
    for(int j=0;j<imagedata.length;j++)
    {
        //System.out.println(imagedata[j]);
        image.setRGB(pi,pj,-imagedata[j]);
        if(pj==Height-1)
        {
            pi++;
            pj=-1;
        }
        pj++;
        
    }
    
                //System.out.println("[0][0]: "+image.getRGB(0, 0));
                //System.out.println("[0][1]: "+image.getRGB(0, 1));
    
                 while(t<=pix)
                {
                   // System.out.println("["+im+"]["+jm+"] : "+image.getRGB(im, jm));
                    Color col = new Color(image.getRGB(im,jm), true);
                 // System.out.println(image.getRGB(pi,pj));
                int red = col.getRed();
                int green = col.getGreen();
                int blue = col.getBlue();
 //           System.out.println("Red:"+red+"Green:"+green+"Blue:"+blue);
                    
                    System.out.println("["+im+"]["+jm+"] : Red:"+red+"  Green:"+green+"  Blue:"+blue);
                    jm++;
                    if(jm==Height-1)
                    {
                        im++;
                        jm=-1;
                    }
                    t++;
                }

                    ImageIO.write(image, "png", new File(x));
                    
                    //System.out.println("done");
                    //Timer time=new Timer();
                    //time.schedule(p(),0, 5000);
                   // process p= new process();
                    //p.p();
                 /*   JFrame frame = new JFrame("PROCESSING");

    ImageIcon loading = new ImageIcon("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\CryptoStegoPROJECT\\src\\cryptostegoproject\\Processing.gif");
    JLabel j= new JLabel(loading);
    frame.add(j);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setVisible(true);
//    frame.wait(5000);
    //frame.dispose();*/
                    JOptionPane.showMessageDialog(null, "Message successfully encoded in image","Message Encode Success", JOptionPane.INFORMATION_MESSAGE);
                    
                   
  
        }
        catch(Exception e)
        {
         e.printStackTrace();   
        }
        	
    }
    
        public static void encodePassandLength(String pass,int length, int passlen, String x)
        {
            try
            {
                byte[] b= pass.getBytes();
        int test[]=new int[8];//temporary array to store 8 bits of a single character
        int data[]=new int[b.length*8];//stores binary code of password
        int l[]=new int[24];
        int pl[]=new int[4];
        int z=0;
                for(int i=0; i<b.length; i++)
                {
                    int v=b[i];
                   // System.out.println(v);
                    //System.out.println(Integer.toBinaryString(v));
                        int temp=Integer.parseInt(Integer.toBinaryString(v));
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
                         //System.out.println("");
                      /*  for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                       //System.out.println("");
                       
                       for(int u=0;u<test.length;u++)
                       {
                           data[z]=test[u];
                           z++;
                       }
                }
                
                //length=length*8;
                int i=23;
                while(length>0)
                {
                    l[i]=length%2;
                    i--;
                    length=length/2;
                }
                
                i=3;
                while(passlen>0)
                {
                    pl[i]=passlen%2;
                    i--;
                    passlen=passlen/2;
                }
                
                System.out.println("password length");
                          for(int y=0;y<pl.length;y++)
                        {
                            System.out.print(pl[y]);
                         }
                
                
                
              //  int j=i;
                
              /*  for(int g=0;g<=j;g++)
                {
                    l[i]=0;
                }
               /* int len=Integer.parseInt(Integer.toBinaryString(length));
                System.out.println(len);
                        int k=0;
                        while(len>0) // to break for eg. 1100 into 1,1,0,0 and store in integer array 
                        {
                            
                            int r=len%10;
                            len=len/10;
                            
                            if(k!=0)
                            {
                                int j=k;
                                while(j!=0)
                                {
                                l[j]=l[j-1];
                                 j--;
                                }
                                l[0]=r;
                               System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                l[k]=r;
                                System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                        
                           /* int q=l.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    l[q]=l[q-1];
                                    q--;
                                 }
                                l[0]=0;
                                k++;
                            }*/
                         
                         System.out.println("secret message length");
                         for(int y=0;y<l.length;y++)
                        {
                            System.out.print(l[y]);
                         }
                         System.out.println("");
                         System.out.println("password data");
                          for(int y=0;y<data.length;y++)
                        {
                            System.out.print(data[y]);
                         }
                          int f2=0;
                          int f[]=new int[data.length+l.length+pl.length+2];
                          
                          for(int f1=0;f1<pl.length;f1++)
                          {
                                  f[f2]=pl[f1];
                                  f2++;
                          }
                          //no. of tries password 
                          f[f2]=1;
                          f2++;
                          f[f2]=1;
                          f2++;
                          for(int f1=0;f1<data.length;f1++)
                          {
                                  f[f2]=data[f1];
                                  f2++;
                          }
                          
                          for(int f1=0;f1<l.length;f1++)
                          {
                                  f[f2]=l[f1];
                                  f2++;
                          }
                          
                          
                          
                          System.out.println("");
                          
                          for(int g1=0;g1<f.length;g1++)
                          {
                              System.out.print(f[g1]);
                          }
                

                          
                         //embed pass and secret msg length
                           int pixel[][],Width,Height,pix;
//File fileName=new File("C:\\Users\\Progyan\\Documents\\NetBeansProjects\\Encode\\src\\cryptostegoproject\\steganography.png");
File fileName=new File(x);
            BufferedImage image=null,new_image=null;
            new_image=ImageIO.read(fileName);
      image=new BufferedImage(new_image.getWidth(), new_image.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = image.createGraphics();
      graphics.drawImage(new_image,0,0,null);
      graphics.dispose();
      pixel= new int[image.getWidth()][image.getHeight()];
      	Width=image.getWidth();
	Height=image.getHeight();
                int t=pl.length+data.length+l.length+2;
                int im=Width-1,jm=Height-1;
                int di=0;
                int pix1=t/6;
               
                if(t%6!=0)
                {
                    pix1=pix1+1;
                }
                
                
                int imagedata[]=new int[pix1];
                int id=0;
       
     while(t>0)
                { 
Color col = new Color(image.getRGB(im,jm), true);
int red = col.getRed();
int green = col.getGreen();
int blue = col.getBlue();
            //convert to binary
            int[] arr = {red, green, blue};
            int p=0;
            int rgb[]=new int[24];
             int test1[]=new int[8];
for (int i1 : arr)
{
            int z1=i1;
            //System.out.println(z);
                    int temp=Integer.parseInt(Integer.toBinaryString(z1));
              //      System.out.println(temp);
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
                                test1[j]=test1[j-1];
                                 j--;
                                }
                                test1[0]=r;
                      //          System.out.print(test[0]);
                                k++;
                            }
                            else
                            {
                                test1[k]=r;
                        //        System.out.print(test[k]);
                                k++;
                            }
                        }
                        //System.out.println("");
                        /*for(int y=0;y<test.length;y++)
                        {
                            System.out.print(test[y]);
                        }*/
                   
                            int q=test1.length;// q=8
                            q=q-1;
                            k=k-1;//k gives the actual length
                         while(k!=7)//to convert to common binary length, i.e, 6 bits or 7bits to 8 bit
                            {
                                q=k+1;
                                while(q!=0)
                                {
                                    test1[q]=test1[q-1];
                                    q--;
                                 }
                                test1[0]=0;
                                k++;
                            }
            
                            for(int u=0;u<test1.length;u++)
                       {
                           rgb[p]=test1[u];
                //           System.out.print(test[u]);
                           p++;
                       }
            
       //     System.out.println("");

}
    System.out.println("rgb before embed["+im+"]["+jm+"]: ");
    for(int j=0;j<24;j++)
    {
            System.out.print(rgb[j]);
            if((j==7)||(j==15))
            {
                System.out.print(" ");
            }
        }
      System.out.println("");
  //  for(int dj=0;dj<data.length;dj++)
    //{
      //  System.out.print(data[dj]);
    //}
   
                    //System.out.println(f.length);
                    //System.out.println("");
    if(di<f.length) // embed in red  
    {
        rgb[6]=f[di];
        rgb[7]=f[di+1];
        di=di+2;
    }
     
    if(di<f.length) //embed in green
    {
        rgb[14]=f[di];
        rgb[15]=f[di+1];
        di=di+2;
    }
    
    if(di<f.length) //embed in blue
    {
        rgb[22]=f[di];
        rgb[23]=f[di+1];
        di=di+2;
    }
    
    System.out.println("rgb after embed["+im+"]["+jm+"]: ");
    
        for(int j=0;j<24;j++)
    {
            System.out.print(rgb[j]);
            if((j==7)||(j==15))
            {
                System.out.print(" ");
            }
        }
      System.out.println("");
    // converting to 2's compement...starting from right the while loop runs until we encounter a '1'
        p=23;
        int k=0;
    while(rgb[p]==0)
    {
        k++;
        p--;
    }
    
    p=23-k;
    
    for(int j=0;j<p;j++)
    {
        if(rgb[j]==0)
        {
            rgb[j]=1;
        }
        else
            rgb[j]=0;
    }
    
            //System.out.println("");
    //print out the 2's complement
 //   for(int j=0;j<24;j++)
   // {
     //       System.out.print(rgb[j]);
       // }
    double sum=0; // to store decimal value of the 2's complement
    int pow=0;
    for(int j=23;j>=0;j--)
    {
            if(rgb[j]==0)
            {
                sum+=0;
            }
            else
            {
                sum=sum+(1*Math.pow(2,pow));
            }
            pow++;
        }
            System.out.println("");
            int d=(int)sum;
            //System.out.println(d);
            
            imagedata[id]=d; // imagedata[] stores 2's complement of rgb values of different pixels
            id++;
            
            if(jm==0)
            {
                im--;
                jm=Height;
            }
            jm--;
            t=t-6;
 } 
 int pi=Width-1;
 int pj=Height-1;
    for(int j=0;j<imagedata.length;j++)
    {
        //System.out.println(imagedata[j]);
        image.setRGB(pi,pj,-imagedata[j]);
        if(pj==0)
        {
            pi--;
            pj=Height;
        }
        pj--;
        
    }
    
                //System.out.println("[0][0]: "+image.getRGB(0, 0));
                //System.out.println("[0][1]: "+image.getRGB(0, 1));
                  t=0;
                 while(t>pl.length+data.length+l.length)
                {
                    im=Width-1;
                    jm=Height-1;
                   // System.out.println("["+im+"]["+jm+"] : "+image.getRGB(im, jm));
                    Color col = new Color(image.getRGB(im,jm), true);
                 // System.out.println(image.getRGB(pi,pj));
                int red = col.getRed();
                int green = col.getGreen();
                int blue = col.getBlue();
 //           System.out.println("Red:"+red+"Green:"+green+"Blue:"+blue);
                    
                    System.out.println("["+im+"]["+jm+"] : Red:"+red+"  Green:"+green+"  Blue:"+blue);
                    
                    if(jm==0)
                    {
                        im--;
                        jm=Height;
                    }
                    jm--;
                    t=t-6;
                }

                    ImageIO.write(image, "png", new File(x));
                        
            
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        
    
}
        
        public static String imageselect()
        {
             String imagepath="";
            try{
               JFileChooser fileopen = new JFileChooser();
            javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("png or gif images","png","gif");
      fileopen.setFileFilter(filter);
    //fileopen.addChoosableFileFilter(filter);


    int ret = fileopen.showDialog(null, "Select Image");

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
        
        public static String entermsg()
        {
            String x="";
            x=(String)JOptionPane.showInputDialog(null,"Enter your message:\n","Message Input",JOptionPane.PLAIN_MESSAGE);
            x=x.toLowerCase();
            return x;
        }
            
             public static String enterpass()
        {
            String x="";
            x=(String)JOptionPane.showInputDialog(null,"Enter Password of minimum length 4 and maximum length 14 \n","Password Input",JOptionPane.PLAIN_MESSAGE);
            return x;
        }
             
      /*       public static void p()
        {
            JFrame frame = new JFrame("PROCESSING");

    ImageIcon loading = new ImageIcon("Processing.gif");
    frame.add(new JLabel("loading... ", loading, JLabel.CENTER));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(214, 138);
    frame.setVisible(true);

    //return 0;
        }*/
}

/*class process
        {
        public static void p()
        {
            try
            {
            JFrame frame = new JFrame("PROCESSING");

    ImageIcon loading = new ImageIcon("Processing.gif");
    frame.add(new JLabel("loading... ", loading, JLabel.CENTER));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(214, 138);
    frame.setVisible(true);
//    frame.wait(5000);
    frame.dispose();
            }
        
    catch (Exception e)
    {
        e.printStackTrace();
    }
        }
}*/