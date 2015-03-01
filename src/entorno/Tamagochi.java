package entorno;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.j3d.utils.geometry.Primitive; // Contains the object loaded from disk.
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.geometry.Sphere; // Contains the object loaded from disk.
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import logica.MaquinaTamagochi;
/**
 *
 * @author Shinsnake
 */
public class Tamagochi extends Frame implements ActionListener{
 
  private Canvas3D canvas3D;
  private Appearance ap;
  private Texture feliz, enfermo;
  private static Texture texture;
  private TextureLoader loader;

  private JPanel jpB;
          private JPanel jpL;
          private JPanel jpPb;
          private JPanel jpL1;


  private JButton bcomer; //comer
  private JLabel lhambre; 
  private JButton bdormir; //dormir
  private JLabel lsueno;
  private JButton bjugar; //jugar
  private JLabel lEnergia;
          private JLabel mensaje;
          private JLabel estado; //TODO: delete

  private BarraSueno PbSuenio;
  private BarraHambre PbHambre;
  private BarraEnergia PbEnergia;
  
  static Sphere sphere;
  
  MaquinaTamagochi tamagochi;


  public Tamagochi() {

      super("Tamagochi 3D");
     
      setResizable(false); setSize(1300, 1500);
      GraphicsConfiguration config =     
      SimpleUniverse.getPreferredConfiguration();
      canvas3D = new Canvas3D(config);
                  canvas3D.setBounds(100, 100, 500, 500);


      bcomer=new JButton("Comer");
                  bcomer.setBounds(300, 200, 50, 50);
                  lhambre=new JLabel("Hambre");

      bdormir=new JButton("Dormir");
                  bdormir.setBounds(300, 200, 50, 50);
      lsueno=new JLabel("Sueno");

      bjugar=new JButton("Jugar");
                  bjugar.setBounds(300, 200, 50, 50);
      lEnergia=new JLabel("Aburrimiento");

                  mensaje = new JLabel("Hola, soy Rayman");
                  mensaje.setBounds(1000, 500, 50, 50);
                  
                  estado = new JLabel("Estado Actual"); // TODO: delete
      
      TransformGroup tg = new TransformGroup();
      tamagochi = new MaquinaTamagochi(tg, mensaje, estado);           

      
      PbEnergia = new BarraEnergia(tamagochi);
      PbHambre = new BarraHambre(tamagochi);
      PbSuenio = new BarraSueno(tamagochi);


      jpB = new JPanel();
                  jpL = new JPanel();
                  jpL1 = new JPanel();

      jpL.add(lhambre);
      jpL.add(PbSuenio);
      jpB.add(bcomer);

      jpL.add(lsueno); jpL.add(PbHambre);
      jpB.add(bdormir);

      jpL.add(lEnergia); jpL.add(PbEnergia);
      jpB.add(bjugar);
                  jpL1.add(mensaje);
                  jpL1.add(estado);//TODO: delete




                  add("North", jpL);
                  add("Center", jpB);
                  add("East", jpL1);
                  add("South",canvas3D);
      setup3DGraphics();
      setVisible(true);
      
      //TODO:delete
     
      
      bcomer.addActionListener(this);
      bjugar.addActionListener(this);
      bdormir.addActionListener(this);
      
      
      
      


  }

  public void actionPerformed (ActionEvent e){
      JButton boton = (JButton)e.getSource();
      if(boton.getText().equals("Comer")){
          tamagochi.comer();
      }
      else if(boton.getText().equals("Dormir")){
          tamagochi.dormir();
      }
      else if(boton.getText().equals("Jugar")){
          tamagochi.jugar();
      }
  }
  
  void setup3DGraphics() {

      DirectionalLight light1;
      SimpleUniverse universe = new SimpleUniverse(canvas3D);
      BranchGroup group = new BranchGroup();
      int primflags = Primitive.GENERATE_NORMALS +
      Primitive.GENERATE_TEXTURE_COORDS/*+Primitive.ENABLE_APPEARANCE_MODIFY*/ ; 

          //ap.setTextureUnitState(textureUnitState);  
      sphere = new Sphere(0.5f, primflags, ap);
      sphere.setCapability(Primitive.ENABLE_APPEARANCE_MODIFY); 
      ap = sphere.getAppearance();
      ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
          ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
          ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
          group.addChild(sphere);
      universe.getViewingPlatform().setNominalViewingTransform();
      universe.addBranchGraph(group);
  }


//  public static void main(String[] args) { 
//
//      Tamagochi t = new Tamagochi();
//      //t.cambiarTexto(t.getMensaje());
//
//
//  }


      public void windowClosing(WindowEvent e) { 

          System.exit(0); 
      }
      
  /* public void cambiarTexto(Label mensaje){
       mensaje.setText("Uff estuvo cerca!");
   }
  */ 
   public JLabel getMensaje(){
        return mensaje;
   }
       
}
